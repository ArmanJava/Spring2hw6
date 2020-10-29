package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.beans.Cart;
import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.OrderItem;
import com.geekbrains.book.store.entities.dto.OrderItemDto;
import com.geekbrains.book.store.exceptions.ResourceNotFoundException;
import com.geekbrains.book.store.services.BookService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
@Slf4j
public class CartController {
    private BookService bookService;
    private Cart cart;

    @GetMapping
    public List<OrderItemDto> getCartItems() {

        return cart.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }

    @GetMapping("/add/{bookId}")
    public void addToCart(@PathVariable Long bookId) {
//        System.out.println(cart.getItems().stream().map(oi -> oi.getBook().getTitle()).collect(Collectors.joining()));
//        System.out.println(System.identityHashCode(cart));
        Book book = bookService.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Can't add book to cart. Book with id: " + bookId + " not found"));
        cart.add(book);
    }
}
