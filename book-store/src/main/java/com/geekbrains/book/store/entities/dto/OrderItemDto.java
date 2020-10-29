package com.geekbrains.book.store.entities.dto;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.entities.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class OrderItemDto {
    private String bookTitle;

    public OrderItemDto(OrderItem orderItem) {
        this.bookTitle = orderItem.getBook().getTitle();
    }
}
