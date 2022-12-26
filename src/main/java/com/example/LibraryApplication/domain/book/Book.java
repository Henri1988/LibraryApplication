package com.example.LibraryApplication.domain.book;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "location", nullable = false)
    private String location;

}