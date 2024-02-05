package com.excalibur.spring6webapp.services;

import com.excalibur.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
