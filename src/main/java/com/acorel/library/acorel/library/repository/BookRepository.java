package com.acorel.library.acorel.library.repository;

import com.acorel.library.acorel.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
