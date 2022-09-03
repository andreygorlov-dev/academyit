package com.gorlov.pledge_ticket.exception;

public class PledgeTicketNotFoundException extends Exception {

    public PledgeTicketNotFoundException(long pledgeTicketId) {
        super(String.format("Ticket is not found with id : '%s'", pledgeTicketId));
    }

}
