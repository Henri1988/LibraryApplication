package com.example.LibraryApplication.domain.returnborrow;

import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.user.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "return_borrow", schema = "library")
public class ReturnBorrow {
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

    @Column(name = "returned_date", nullable = false)
    private LocalDate returnedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "borrow_id", nullable = false)
    private Borrow borrow;

}