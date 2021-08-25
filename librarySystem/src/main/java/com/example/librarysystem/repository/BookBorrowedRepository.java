package com.example.librarysystem.repository;

import com.example.librarysystem.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookBorrowedRepository extends CrudRepository<Book, Integer> {
}
