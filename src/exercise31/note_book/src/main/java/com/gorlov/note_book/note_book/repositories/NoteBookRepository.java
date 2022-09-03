package com.gorlov.note_book.note_book.repositories;

import com.gorlov.note_book.note_book.models.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteBookRepository extends JpaRepository<NoteBook, Long> {
}
