package com.example.LibraryApplication.service.library;
import lombok.Data;
import java.time.LocalDate;



@Data
public class ReturnBorrowRequest {
    private Integer userId;
    private Integer bookId;
    private Integer borrowId;
    //private LocalDate returnedDate;
}
