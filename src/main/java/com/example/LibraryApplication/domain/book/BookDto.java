package com.example.LibraryApplication.domain.book;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.LibraryApplication.domain.book.Book} entity
 */
@Data
public class BookDto implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private LocalDate releaseTime;
    private String genre;
    private Integer lendingPeriod;
    private String location;
    private Integer quantity;
}