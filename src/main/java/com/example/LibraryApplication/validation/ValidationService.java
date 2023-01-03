package com.example.LibraryApplication.validation;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.infrastructure.exception.BusinessException;
import com.example.LibraryApplication.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    public void userNameAlreadyExists(String username, boolean userExists) {
        if (userExists){
            throw new BusinessException("Username " + username +" already taken."  ," choose another username");
        }
    }

    public void userExists(Optional<User> user) {
        if (user.isEmpty()) {
            throw new DataNotFoundException("Cannot log in", "Insert correct data or register account");
        }
    }
}
