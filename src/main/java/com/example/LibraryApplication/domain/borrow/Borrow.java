package com.example.LibraryApplication.domain.borrow;

import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.user.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "borrow", schema = "library")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "borrowed_date")
    private LocalDate borrowedDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

}