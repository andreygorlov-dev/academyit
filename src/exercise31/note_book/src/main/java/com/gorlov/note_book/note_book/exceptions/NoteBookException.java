package com.gorlov.note_book.note_book.exceptions;

public class NoteBookException extends Exception {

    public NoteBookException(Long id) {
        super("Business is not found with id : " + id);
    }

}
