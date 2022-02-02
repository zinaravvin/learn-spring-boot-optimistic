package com.springboot.app.learnspringboot.service;

import com.springboot.app.learnspringboot.model.AristoStop;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;

import java.util.List;
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

        List<AristoStop> aristoStops = repository.getAllByAccountNumber(accountId);

        AristoStop update1;
        update1 = setUpVacationTransaction(aristoStops.get(0));
        try {
            log.info("Updating the record");
            repository.save(update1);
            log.info(update1.toString());
        } catch (Exception e) {
            log.error("Exception trying to save stop txn data in the database", e);
            throw new IllegalStateException("data is stale. Please re-try");

        }
        AristoStop update2;
        update2 = setUpNonPaymentTransaction(aristoStops.get(0));
        try {
            log.info("Updating the record again");
            // repository.save(aristoStops.get(0));
            update2 = repository.save(update2);
            log.info(update2.toString());
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