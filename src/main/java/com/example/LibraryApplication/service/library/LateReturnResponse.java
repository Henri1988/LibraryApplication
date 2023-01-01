package com.example.LibraryApplication.service.library;


import lombok.Data;

@Data
public class LateReturnResponse {

    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer bookId;
    private String title;
    private Integer borrowId;
    private Integer daysOver;
}
