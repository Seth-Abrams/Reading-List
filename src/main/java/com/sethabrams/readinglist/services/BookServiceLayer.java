package com.sethabrams.readinglist.services;

import com.sethabrams.readinglist.domain.Book;
import com.sethabrams.readinglist.repositories.BookRepository;
import com.sethabrams.readinglist.services.serviceinterfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceLayer implements BookService {

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceLayer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   


}
