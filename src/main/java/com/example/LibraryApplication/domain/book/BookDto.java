package com.example.LibraryApplication.domain.book;

import lombok.Data;

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
    private String genre;
    private Integer lendingPeriod;
    private String location;
    private Integer quantity;
}