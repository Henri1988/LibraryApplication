package com.example.LibraryApplication.domain.book;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BookResponse implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private LocalDate releaseTime;
    private String genre;
    private Integer lendingPeriodDays;
    private String location;
    private Integer quantity;
}
