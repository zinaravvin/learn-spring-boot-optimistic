package com.springboot.app.learnspringboot;

import com.springboot.app.learnspringboot.controller.AristoStopsController;
import com.springboot.app.learnspringboot.model.AristoStop;
import com.springboot.app.learnspringboot.repository.AristoStopsRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class OptimisticLockTest {
@Autowired
	AristoStopsRepository repository;
	public static final Logger log = LoggerFactory.getLogger(OptimisticLockTest.class);

	@Test
	void testOptimisticLock() {


	}

}
