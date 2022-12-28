package com.example.LibraryApplication.domain.borrow;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Borrow} entity
 */
@Data
public class BorrowDto implements Serializable {
    private Integer id;
    private Integer userId;
    private String userUserName;
    private String userPassword;
    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private LocalDate bookReleaseTime;
    private String bookGenre;
    private Integer bookLendingPeriod;
    private String bookLocation;
    private Integer bookQuantity;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private LocalDate returnedDate;
}