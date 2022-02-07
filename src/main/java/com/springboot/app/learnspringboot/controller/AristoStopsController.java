package com.springboot.app.learnspringboot.controller;
import com.springboot.app.learnspringboot.model.AristoStop;
import com.springboot.app.learnspringboot.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;
import com.springboot.app.learnspringboot.service.VacationTransactionService;
import java.util.List;

@ComponentScan(basePackageClasses = AristoStopsController.class)
@RestController
//@RequestMapping(value = "/aristo/stops/{accountId}",method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class AristoStopsController {
    @Autowired
    AristoStopsRepository repository;

    //public static final String ACCOUNT_BASE_URL = "/svc/v1/accounts";
    public static final Logger log = LoggerFactory.getLogger(AristoStopsController.class);
    @RequestMapping("/aristo/stops/{accountId}")
    public String returnTransaction(@PathVariable("accountId") final String accountId){
        TransactionService transactionService =new TransactionService();
        List<AristoStop> initialVersionNumber = repository.getAllByAccountNumber(accountId);
        long firstVersion = initialVersionNumber.get(0).getVersion();
         transactionService.processTransaction(accountId);

        return "Demo for Optimistic lock";
    }
}
