package com.sethabrams.readinglist.controllers;

import com.sethabrams.readinglist.domain.Book;
import com.sethabrams.readinglist.services.BookServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BookController {

    private final BookServiceLayer bookServiceLayer;

    @Autowired
    public BookController(BookServiceLayer bookServiceLayer) {
        this.bookServiceLayer = bookServiceLayer;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookServiceLayer.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        return bookServiceLayer.getBook(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) throws URISyntaxException {
        return bookServiceLayer.addBook(book);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return bookServiceLayer.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        return bookServiceLayer.deleteBook(id);
    }
}
