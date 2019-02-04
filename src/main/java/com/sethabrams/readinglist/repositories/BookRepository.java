package com.sethabrams.readinglist.repositories;

import com.sethabrams.readinglist.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
