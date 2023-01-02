package com.example.LibraryApplication.service.login;
import lombok.Data;

@Data
public class LogInResponse {
    private Integer userId;
    private Integer userRoleId;
    private Integer userSessionId;
    private String personName;
}
