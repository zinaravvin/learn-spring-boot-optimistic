package com.springboot.app.learnspringboot.service;

import com.springboot.app.learnspringboot.model.AristoStop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RefreshScope
public class VacationTransactionService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
