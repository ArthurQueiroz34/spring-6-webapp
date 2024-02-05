package com.excalibur.spring6webapp.services;

import com.excalibur.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
