package com.example.LibraryApplication.service.library;
import lombok.Data;

@Data
public class ReturnBorrowRequest {
    private Integer userId;
    private Integer bookId;
    private Integer borrowId;
}
