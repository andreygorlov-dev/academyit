package com.gorlov.pledge_ticket.service;

import com.gorlov.pledge_ticket.models.PledgeTicket;
import com.gorlov.pledge_ticket.models.User;

import java.util.List;

public interface PledgeTicketService {

    void create(PledgeTicket pledgeTicket);

    List<PledgeTicket> readAll();

    List<PledgeTicket> readAll(User user);

    PledgeTicket read(long id);

    boolean update(PledgeTicket pledgeTicket, long id);

    boolean delete(long id);
}
