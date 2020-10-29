package com.geekbrains.book.store.entities.dto;

import com.geekbrains.book.store.entities.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel(description = "Book dto in the application.")
public interface BookDto {
    @ApiModelProperty(notes = "Unique identifier of the book. No two books can have the same id.", example = "1", required = true, position = 0)
    String getId();

    @ApiModelProperty(notes = "Title of the book.", example = "Harry Potter", required = true, position = 1)
    @Size(min = 4, max = 255)
    String getTitle();

    @ApiModelProperty(notes = "Genre of the book.", example = "FANTASY", required = true, position = 2)
    Book.Genre getGenre();

    @ApiModelProperty(notes = "Description of the book.", example = "Nice book, very nice", required = true, position = 3)
    String getDescription();

    @ApiModelProperty(notes = "Author of the book.", example = "Rowling", required = true, position = 4)
    String getAuthorName();

    @ApiModelProperty(notes = "Price of the book (RUB).", example = "450.00", required = true, position = 5)
    @Min(0)
    BigDecimal getPrice();

    @ApiModelProperty(notes = "Publish year.", example = "1998", required = true, position = 6)
    @Min(1900)
    @Max(2100)
    int getPublishYear();

    void setTitle(String title);
}
