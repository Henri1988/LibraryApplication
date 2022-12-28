package com.example.LibraryApplication.domain.borrow;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Borrow} entity
 */
@Data
public class BorrowDto implements Serializable {
    private Integer userId;
    private Integer bookId;
}