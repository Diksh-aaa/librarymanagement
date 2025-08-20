package com.diksha.librarymanagement.repository;

import com.diksha.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
