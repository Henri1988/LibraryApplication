package com.example.LibraryApplication.service.library;


import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.user.contact.Contact;
import lombok.Data;

@Data
public class LateReturnResponseItem {

    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer bookId;
    private String title;
    private Integer borrowId;
    private Long daysOver;
}
