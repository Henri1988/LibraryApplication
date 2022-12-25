package com.example.LibraryApplication.domain.member;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Member} entity
 */
@Data
public class MemberDto implements Serializable {
    private final Integer id;
    private final String userName;
    private final String password;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
}