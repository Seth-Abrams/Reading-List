package com.sethabrams.readinglist.services;

import com.sethabrams.readinglist.domain.Book;
import com.sethabrams.readinglist.repositories.BookRepository;
import com.sethabrams.readinglist.services.serviceinterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceLayer implements BookService {

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceLayer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public List<Book> getAllBooks(){
        return bookRepository.findAll();
   }

   public ResponseEntity<?> getBook(Long id){
       Optional<Book> book = bookRepository.findById(id);
       return book.map(response -> ResponseEntity.ok().body(response))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   public ResponseEntity<Book> addBook(Book book) throws URISyntaxException {
        Book newBook = bookRepository.save(book);
        return ResponseEntity.created(new URI("/api/group" + newBook.getId()))
                .body(newBook);
   }

   public ResponseEntity<Book> updateBook(Book book){
        Book updateBook = bookRepository.save(book);
        return ResponseEntity.ok().body(updateBook);
   }

   public ResponseEntity<?> deleteBook(Long id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
   }

}
