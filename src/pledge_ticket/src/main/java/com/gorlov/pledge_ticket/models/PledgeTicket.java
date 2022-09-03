package com.gorlov.pledge_ticket.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PLEDGE_TICKET")
@Data
public class PledgeTicket {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
    private Date startDate;
    private Date endDate;
    private double assessedValue;
    private double loanAmount;
    private String description;
    private String pledgedProperty;

}
