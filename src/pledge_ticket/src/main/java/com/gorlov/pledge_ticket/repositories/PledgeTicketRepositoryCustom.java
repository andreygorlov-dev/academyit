package com.gorlov.pledge_ticket.repositories;

import com.gorlov.pledge_ticket.models.PledgeTicket;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PledgeTicketRepositoryCustom {

    @Query(value = "SELECT p FROM PledgeTicket p WHERE p.user.id = ?1")
    List<PledgeTicket> findAllByUserId(long id);

}
