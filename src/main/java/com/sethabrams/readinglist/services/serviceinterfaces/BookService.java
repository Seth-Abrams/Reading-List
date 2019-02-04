package com.sethabrams.readinglist.services.serviceinterfaces;

import com.sethabrams.readinglist.domain.Book;
import org.springframework.http.ResponseEntity;
import java.net.URISyntaxException;
import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    ResponseEntity<?> getBook(Long id);

    ResponseEntity<Book> addBook(Book book) throws URISyntaxException;

    ResponseEntity<Book> updateBook(Book book);

    ResponseEntity<?> deleteBook(Long id);
}
