package com.gorlov.note_book.note_book.controllers;

import com.gorlov.note_book.note_book.exceptions.NoteBookException;
import com.gorlov.note_book.note_book.models.NoteBook;
import com.gorlov.note_book.note_book.repositories.NoteBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteBookController {

    private final NoteBookRepository noteBookRepository;

    @Autowired
    public NoteBookController(NoteBookRepository noteBookRepository) {
        this.noteBookRepository = noteBookRepository;
    }

    @GetMapping(value = "/bussines")
    public List<NoteBook> getAll() {
        return noteBookRepository.findAll();
    }

    @GetMapping(value = "/bussines/{id}")
    public NoteBook getAllByUser(@PathVariable(name = "id") long id) throws NoteBookException {
        return noteBookRepository.findById(id).orElseThrow(() -> new NoteBookException(id));
    }

    @PostMapping(value = "/bussines")
    public ResponseEntity<?> create(@RequestBody NoteBook noteBook) {
        noteBookRepository.save(noteBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/bussines/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) throws NoteBookException {
        NoteBook noteBook = noteBookRepository.findById(id)
                .orElseThrow(() -> new NoteBookException(id));
        noteBookRepository.delete(noteBook);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/bussines/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody NoteBook noteBook) throws NoteBookException {
        NoteBook noteBookUpdate = noteBookRepository.findById(id)
                .orElseThrow(() -> new NoteBookException(id));

        noteBookUpdate.setDate(noteBook.getDate());
        noteBookUpdate.setTitle(noteBook.getTitle());
        noteBookUpdate.setDescription(noteBook.getDescription());

        noteBookRepository.save(noteBookUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
