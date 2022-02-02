package com.springboot.app.learnspringboot.controller;
import com.springboot.app.learnspringboot.model.AristoStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;
import com.springboot.app.learnspringboot.service.VacactionTransactionService;
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
        VacactionTransactionService transactionService = new VacactionTransactionService();
        List<AristoStop> aristoStops = repository.getAllByAccountNumber(accountId);
        log.info("Account loaded %s", aristoStops.get(0));
        repository.save(aristoStops.get(0));
        try {
            repository.save(aristoStops.get(0));
        } catch (Exception e) {
            log.error("Exception trying to save ItunesReceiptEvents in the database", e);
            throw new IllegalStateException("data is stale. Please re-try");

   }
        return "ccc";
  }
}
