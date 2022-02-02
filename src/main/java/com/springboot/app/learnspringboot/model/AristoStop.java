package com.springboot.app.learnspringboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Entity
@Table(name = "aristo_stops_transactions")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class AristoStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String accountNumber;
    @Column
    private ZonedDateTime startDate;
    @Column
    private ZonedDateTime endDate;
    @Column
    private String stopCode;
    @Column
    private String stopReason;
    @Column
    private String donationFlag;
    @Version
    private int version;
    @Override
    public String toString() {
        return "AristoStop{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", stopCode='" + stopCode + '\'' +
                ", stopReason='" + stopReason + '\'' +
                ", donationFlag='" + donationFlag + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

}


