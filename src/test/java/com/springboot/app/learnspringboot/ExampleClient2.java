package com.springboot.app.learnspringboot;

import com.springboot.app.learnspringboot.model.AristoStop;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class ExampleClient2 {

    @Autowired
    private AristoStopsRepository repo;
    @Test
    public void run(ApplicationContext context) {
        AristoStop aristoStop = (AristoStop) repo.getAllByAccountNumber("12345");
        repo.save(aristoStop);
        int accountId = aristoStop.getId();
        System.out.println("-- employee persisted --");
        System.out.println(findEmployee(accountId));

        ExecutorService es = Executors.newFixedThreadPool(2);

        //user 1
        es.execute(() -> {
            System.out.println(" -- user1 updating salary to 2000 --");
            AristoStop aristoStop1 = findEmployee(accountId);
            System.out.println("user1 loaded entity: " + aristoStop1);
            aristoStop1.setStopCode("SP");
            //little delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                repo.save(aristoStop1);
            } catch (Exception e) {
                System.err.println("user1 " + e);
                System.out.println("user1 after error: " + findEmployee(accountId));
                return;
            }
            System.out.println("user1 finished: " + findEmployee(accountId));
        });

        //user 2
        es.execute(() -> {
            System.out.println(" -- user2 updating salary to 4000 --");
            AristoStop aristoStop2 = findEmployee(accountId);
            System.out.println("user2 loaded entity: " + aristoStop2);
            aristoStop2.setStopCode("ST");
            try {
                repo.save(aristoStop2);
            } catch (Exception e) {
                System.err.println("user2: " + e);
                System.out.println("user2 after error: " + findEmployee(accountId));
                return;
            }
            System.out.println("user2 finished: " + findEmployee(accountId));
        });

        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }

    private AristoStop findEmployee(int accountId) {
        Optional<AristoStop> opt = repo.findById(accountId);
        return opt.isPresent() ? opt.get() : null;
    }
}
