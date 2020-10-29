package com.geekbrains.book.store.repositories;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Query("select b.id as id, b.title as title, b.genre as genre, b.description as description, b.price as price, b.publishYear as publishYear, b.author.name as authorName from Book b")
    List<BookDto> findAllBooksWithAuthorName();
}
