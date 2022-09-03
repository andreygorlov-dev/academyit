package com.gorlov.pledge_ticket.repositories;

import com.gorlov.pledge_ticket.models.PledgeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PledgeTicketRepository extends JpaRepository<PledgeTicket, Long>, PledgeTicketRepositoryCustom {

}
