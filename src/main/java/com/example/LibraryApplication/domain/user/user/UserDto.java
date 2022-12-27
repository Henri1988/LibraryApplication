package com.example.LibraryApplication.domain.user.user;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String userName;
    private String password;
}