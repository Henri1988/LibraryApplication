package com.example.LibraryApplication.service.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest implements Serializable {
    private Integer userSessionId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
}
