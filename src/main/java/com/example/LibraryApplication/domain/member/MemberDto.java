package com.example.LibraryApplication.domain.member;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Member} entity
 */
@Data
public class MemberDto implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
}