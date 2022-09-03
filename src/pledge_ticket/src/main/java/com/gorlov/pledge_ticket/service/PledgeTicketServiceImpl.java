package com.gorlov.pledge_ticket.service;

import com.gorlov.pledge_ticket.models.PledgeTicket;
import com.gorlov.pledge_ticket.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PledgeTicketServiceImpl implements PledgeTicketService {

    private static final Map<Long, PledgeTicket> tickets = new HashMap<Long, PledgeTicket>();
    private static final AtomicInteger PLEDGE_TICKET_ID = new AtomicInteger();

    @Override
    public void create(PledgeTicket pledgeTicket) {
        final long ticket_id = PLEDGE_TICKET_ID.incrementAndGet();
        pledgeTicket.setId(ticket_id);
        tickets.put(ticket_id, pledgeTicket);
    }

    @Override
    public List<PledgeTicket> readAll() {
        return new ArrayList<>(tickets.values());
    }

    @Override
    public List<PledgeTicket> readAll(User user) {
        return tickets.values()
                .stream()
                .filter(item -> item.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public PledgeTicket read(long id) {
        return tickets.get(id);
    }

    @Override
    public boolean update(PledgeTicket pledgeTicket, long id) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
