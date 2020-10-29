package com.geekbrains.book.store;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FullServerRunTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void fullRestTest() {
        // List<Product> products = this.restTemplate.getForObject("/api/v1/products", List.class);
        List<BookDto> books = restTemplate.getForObject("/api/v1/books", List.class);
        System.out.println(books);
        assertThat(books).isNotNull();
    }
}
