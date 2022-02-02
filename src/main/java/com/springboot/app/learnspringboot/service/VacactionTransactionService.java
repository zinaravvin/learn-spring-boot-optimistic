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
public class VacactionTransactionService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AristoStop save(String accountId) {
        AristoStop aristoStop = new AristoStop();
        aristoStop.setStopReason("VA");
        aristoStop.setAccountNumber(accountId);
       // aristoStop.setVersion(1);
      //  int count = accountDao.update(aristoStop);
       return aristoStop;
    }


}
