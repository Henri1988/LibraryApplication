package com.example.LibraryApplication.domain.book;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "book", schema = "library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "release_time", nullable = false)
    private LocalDate releaseTime;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "lending_period_days", nullable = false)
    private Integer lendingPeriodDays;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}