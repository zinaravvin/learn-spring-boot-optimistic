package com.springboot.app.learnspringboot.service;

import com.springboot.app.learnspringboot.model.AristoStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;

public class NonPaymentTransactionService {
    @Autowired
    AristoStopsRepository aristoStopsRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AristoStop getById(int id) {
        AristoStop trnsaction = aristoStopsRepository.getById(id);
        trnsaction.setStopCode("NN");
        return trnsaction;
    }

}
