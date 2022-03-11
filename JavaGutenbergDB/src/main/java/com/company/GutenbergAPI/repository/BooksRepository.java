package com.company.GutenbergAPI.repository;

import com.company.GutenbergAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
