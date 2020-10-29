package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.beans.Cart;
import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.dto.BookDto;
import com.geekbrains.book.store.exceptions.BookServiceError;
import com.geekbrains.book.store.exceptions.ResourceNotFoundException;
import com.geekbrains.book.store.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@Api("Set of endpoints for books")
@AllArgsConstructor
@Slf4j
public class BookController {
    private BookService bookService;

    @GetMapping
    @ApiOperation("Returns list of all books in the store.")
    public List<BookDto> getAllBooks(@RequestParam(name = "book_title", required = false) String bookTitle) {
        List<BookDto> out = bookService.findAllBooksWithAuthorName();
        if (bookTitle != null) {
            out = out.stream().filter(b -> b.getTitle().contains(bookTitle)).collect(Collectors.toList());
        }
        return out;
    }

    @GetMapping("/simple")
    public List<BookDto> getAllBooksDto() {
        return bookService.findAllBooksWithAuthorName();
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific book by their identifier. 404 if does not exist.")
    public Book getBookById(@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        return bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with id: " + id + " not found"));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation("Creates a new book. If id != null, then it will be cleared")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createNewBook(@RequestBody Book book) {
        if (book.getId() != null) {
            book.setId(null);
        }
        return bookService.saveOrUpdate(book);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation("Update book")
    public Book modifyBook(@RequestBody Book book) {
        if (!bookService.existsById(book.getId())) {
            throw new ResourceNotFoundException("Book with id: " + book.getId() + " doesn't exists (for modification)");
        }
        return bookService.saveOrUpdate(book);
    }

    @DeleteMapping
    @ApiOperation("Delete all books from the system")
    public void deleteAllBooks() {
        bookService.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletes a book from the system. 404 if the book's identifier is not found.")
    public void deleteById(@ApiParam("Id of the book to be deleted. Cannot be empty.") @PathVariable Long id) {
        if (!bookService.existsById(id)) {
            throw new ResourceNotFoundException("Book with id: " + id + " doesn't exists (for delete)");
        }
        bookService.deleteById(id);
    }
}
