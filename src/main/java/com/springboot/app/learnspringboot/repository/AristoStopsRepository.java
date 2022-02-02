package com.springboot.app.learnspringboot.repository;

import com.springboot.app.learnspringboot.model.AristoStop;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.ZonedDateTime;
import java.util.List;

public interface AristoStopsRepository  extends PagingAndSortingRepository<AristoStop, Integer> {
    List<AristoStop> getAllByDonationFlagFalse();
    List<AristoStop> getAllByDonationFlagTrue();
    List<AristoStop> getAllByStartDateAfter(ZonedDateTime dateTime);
    List<AristoStop> getAllByStartDateBefore(ZonedDateTime dateTime);
    @Lock(LockModeType.OPTIMISTIC)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
    List<AristoStop> getAllByAccountNumber(String accountId);
    AristoStop getById(int id);

}
