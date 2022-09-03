package com.gorlov.note_book.note_book.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "NOTE_BOOK")
@Data
public class NoteBook {
    @Id
    @GeneratedValue
    private long id;

    private Date date;
    private String title;
    private String description;
}
