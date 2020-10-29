package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.entities.Author;
import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.dto.BookDto;
import com.geekbrains.book.store.exceptions.ResourceNotFoundException;
import com.geekbrains.book.store.services.AuthorService;
import com.geekbrains.book.store.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authors")
@Api("Set of endpoints for authors")
@AllArgsConstructor
@Slf4j
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    @ApiOperation("Returns list of all authors in the system.")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }
}
