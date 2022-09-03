package com.gorlov.pledge_ticket.controllers;

import com.gorlov.pledge_ticket.exception.PledgeTicketNotFoundException;
import com.gorlov.pledge_ticket.models.PledgeTicket;
import com.gorlov.pledge_ticket.repositories.PledgeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PledgeTicketController {

    private final PledgeTicketRepository pledgeTicketRepository;

    @Autowired
    public PledgeTicketController(PledgeTicketRepository pledgeTicketRepository) {
        this.pledgeTicketRepository = pledgeTicketRepository;
    }

    /**
     * Получить всех залоговые билеты
     * @return List<PledgeTicket>
     */
    @GetMapping(value = "/pledge_ticket")
    public List<PledgeTicket> getAll() {
        return pledgeTicketRepository.findAll();
    }

    /**
     * Получить залоговые белеты пользователя по id
     * @param id идентификатор пользователя
     * @return List<PledgeTicket>
     */
    @GetMapping(value = "/pledge_ticket/{user_id}")
    public List<PledgeTicket> getAllByUser(@PathVariable(name = "user_id") long id) {
        return pledgeTicketRepository.findAllByUserId(id);
    }

    /**
     * Создание залогового билета
     * @param pledgeTicket залоговый билет
     * @return ResponseEntity<?>
     */
    @PostMapping(value = "/pledge_ticket")
    public ResponseEntity<?> create(@RequestBody PledgeTicket pledgeTicket) {
        pledgeTicketRepository.save(pledgeTicket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Удаление залогового билета
     * @param id идентификатор билета
     * @return ResponseEntity<?>
     * @throws PledgeTicketNotFoundException билет не найден
     */
    @DeleteMapping(value = "/pledge_ticket/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) throws PledgeTicketNotFoundException {
        PledgeTicket pledgeTicket = pledgeTicketRepository.findById(id)
                .orElseThrow(() -> new PledgeTicketNotFoundException(id));
        pledgeTicketRepository.delete(pledgeTicket);

        return ResponseEntity.ok().build();
    }

    /**
     * Изменение залогового билет, меняем только endDate, тк нужна только пролонгация
     * @param id идентификатор билета
     * @param pledgeTicket залоговый билет
     * @return ResponseEntity<?>
     * @throws PledgeTicketNotFoundException билет не найден
     */
    @PutMapping(value = "/pledge_ticket/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody PledgeTicket pledgeTicket) throws PledgeTicketNotFoundException {
        PledgeTicket pledgeTicketUpdate = pledgeTicketRepository.findById(id)
                .orElseThrow(() -> new PledgeTicketNotFoundException(id));

        pledgeTicketUpdate.setEndDate(pledgeTicket.getEndDate());

        pledgeTicketRepository.save(pledgeTicketUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
