package com.gorlov.pledge_ticket.controllers;

import com.gorlov.pledge_ticket.models.PledgeTicket;
import com.gorlov.pledge_ticket.models.User;
import com.gorlov.pledge_ticket.repositories.PledgeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PledgeTicketConroller {

    private final PledgeTicketRepository pledgeTicketRepository;

    @Autowired
    public PledgeTicketConroller(PledgeTicketRepository pledgeTicketRepository) {
        this.pledgeTicketRepository = pledgeTicketRepository;
    }

    @GetMapping(value = "/pledge_ticket")
    public List<PledgeTicket> getAll() {
        return pledgeTicketRepository.findAll();
    }

    @GetMapping(value = "/pledge_ticket/{user_id}")
    public List<PledgeTicket> getAllByUser(@PathVariable(name = "user_id") long id) {
        return pledgeTicketRepository.findAllByUserId(id);
    }

    @PostMapping(value = "/pledge_ticket")
    public ResponseEntity<?> create(@RequestBody PledgeTicket pledgeTicket) {
        pledgeTicketRepository.save(pledgeTicket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//
//    @DeleteMapping(value = "/pledge_ticket/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
//        final boolean deleted = pledgeTicketService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @PutMapping(value = "/pledge_ticket/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody PledgeTicket pledgeTicket) {
//        final boolean updated = pledgeTicketService.update(pledgeTicket, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

}
