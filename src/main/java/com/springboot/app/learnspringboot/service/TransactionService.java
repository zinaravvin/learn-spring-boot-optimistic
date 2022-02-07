package com.springboot.app.learnspringboot.service;

import com.springboot.app.learnspringboot.model.AristoStop;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configurable
@Service
public class TransactionService  {
    @Autowired
    AristoStopsRepository repository;
    public static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processTransaction(String accountId) {
        log.info("Account loaded %s", accountId);
        AristoStopsRepository repository = (AristoStopsRepository)SpringUtils.ctx.getBean(AristoStopsRepository.class);
        final List <Long> versionlast = new ArrayList<>();
        updateTransactions(accountId, repository);

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(() -> {
            log.info(" -- user1 updating stop reason to CM --");
            List<AristoStop> aristoStop1 = repository.getAllByAccountNumber(accountId);
            AristoStop txnStop1 = aristoStop1.get(0);
            log.info("--user1 loaded entity: stop reason = "
                    + txnStop1.getStopReason() + " version number = " + txnStop1.getVersion());
            txnStop1.setStopReason("CM");
            try {
                Thread.sleep(1000);
                log.info("thread1 is sleeping");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                repository.saveAndFlush(txnStop1);
                aristoStop1 = repository.getAllByAccountNumber(accountId);
                log.info("--user1 updated entity: stop reason = "
                        + aristoStop1.get(0).getStopReason() + " version number = " + aristoStop1.get(0).getVersion());
            } catch (ObjectOptimisticLockingFailureException e) {
                log.info("USER1 was not fast enough " + e.getMessage());
                log.info("user1 after error: " +  txnStop1.getStopReason() + " version number = " + txnStop1.getVersion());
                return;
            }
            log.info("user1 finished: " +  aristoStop1.get(0).getStopReason() + " version number = " + aristoStop1.get(0).getVersion());
        });

        //user 2
        es.execute(() -> {
            log.info(" -- user2 updating stop reason to WW --");
            List<AristoStop> aristoStop2 = repository.getAllByAccountNumber(accountId);
            AristoStop txnStop2 = aristoStop2.get(0);
            log.info("--user2 loaded entity: stop reason = "
                    + txnStop2.getStopReason() + " version number = " + txnStop2.getVersion());
            txnStop2.setStopReason("WW");

            try {
                repository.saveAndFlush(txnStop2);
                log.info("--user2 saved data in the table");
                aristoStop2 = repository.getAllByAccountNumber(accountId);
                log.info("--user2 updated entity: stop reason = "
                        + aristoStop2.get(0).getStopReason() + " version number = " + aristoStop2.get(0).getVersion());
                versionlast.add(aristoStop2.get(0).getVersion());

            } catch (ObjectOptimisticLockingFailureException e) {
                log.info("user2: " + e.getMessage());
                log.info("user2 after error: " +  txnStop2.getStopReason() + " version number = " + txnStop2.getVersion());
                return;
            }
            log.info("user2 finished: " + aristoStop2.get(0).getStopReason() + " version number = " + aristoStop2.get(0).getVersion());

        });
        es.shutdown();


    }

    private void updateTransactions(String accountId, AristoStopsRepository repository) {
        List<AristoStop> aristoStops = repository.getAllByAccountNumber(accountId);

        AristoStop update1;
        update1 = setUpVacationTransaction(aristoStops.get(0));
        try {
            log.info("Updating the record.  ");
            repository.saveAndFlush(update1);
            aristoStops = repository.getAllByAccountNumber(accountId);
            log.info("First update. Stop reason = " +
                    aristoStops.get(0).getStopReason() + " version = "  + aristoStops.get(0).getVersion());
            //log.info(update1.toString());
        } catch (Exception e) {
            log.error("Exception trying to save stop txn data in the database", e);
            throw new IllegalStateException("data is stale. Please re-try");
        }

        AristoStop update2;
        update2 = setUpNonPaymentTransaction(aristoStops.get(0));
        try {
            log.info("Updating the record again");
            // repository.save(aristoStops.get(0));
            repository.saveAndFlush(update2);
            aristoStops = repository.getAllByAccountNumber(accountId);
            log.info("Second update. Stop reason = " +
                    aristoStops.get(0).getStopReason() + " version = "  + aristoStops.get(0).getVersion());
            //log.info(update2.toString());
        } catch (Exception e) {
            log.error("Exception trying to save stop txn in the database", e);
            throw new IllegalStateException("data is stale. Please re-try");

        }
    }

    public AristoStop setUpVacationTransaction(AristoStop account) {

        account.setStopReason("VN");
        // aristoStop.setVersion(1);
        return account;
    }
    public AristoStop setUpNonPaymentTransaction(AristoStop account) {
        account.setStopReason("NN");
        // aristoStop.setVersion(1);
        return account;
    }
}