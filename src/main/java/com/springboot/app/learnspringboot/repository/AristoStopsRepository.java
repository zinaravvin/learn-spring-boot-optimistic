package com.springboot.app.learnspringboot.repository;

import com.springboot.app.learnspringboot.model.AristoStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
@Component
public interface AristoStopsRepository  extends JpaRepository<AristoStop, Integer> {
    List<AristoStop> getAllByDonationFlagFalse();
    List<AristoStop> getAllByDonationFlagTrue();
    List<AristoStop> getAllByStartDateAfter(ZonedDateTime dateTime);
    List<AristoStop> getAllByStartDateBefore(ZonedDateTime dateTime);
    @Transactional
    @Lock(LockModeType.OPTIMISTIC)
    /*@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})*/
    List<AristoStop> getAllByAccountNumber(String accountId);
    AristoStop getById(int id);

    @Query(nativeQuery = true, value = " select * from  public.aristo_stops_transactions where account_number  = :accountId")
    List<AristoStop> getStopTrans( String accountId);

}
