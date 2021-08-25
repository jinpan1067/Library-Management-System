package com.example.librarysystem.repository;

import com.example.librarysystem.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
}
