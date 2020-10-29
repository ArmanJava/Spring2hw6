package com.geekbrains.book.store.repositories;

import com.geekbrains.book.store.entities.Author;
import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
}
