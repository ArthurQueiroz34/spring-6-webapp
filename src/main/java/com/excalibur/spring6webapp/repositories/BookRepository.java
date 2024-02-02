package com.excalibur.spring6webapp.repositories;

import com.excalibur.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}