package com.example.LibraryApplication.service.borrow;
import lombok.Data;

import java.time.LocalDate;


@Data
public class BorrowResponse {
    private Integer id;
    private Integer userId;
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
}
