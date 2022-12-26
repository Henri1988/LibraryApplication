package com.example.LibraryApplication.domain.book;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Book} entity
 */
@Data
public class BookDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private Integer releaseYear;
    private Integer quantity;
    private String location;
}