package com.sethabrams.readinglist.services.serviceinterfaces;

import com.sethabrams.readinglist.domain.Book;

public interface BookService {

    Book getAllBooks();

    Book getBook(Long id);

    Book addBook(Book book);

    Book updateBook(Book book);

    Book deleteBook(Long id);
}
