package com.example.LibraryApplication.validation;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.infrastructure.exception.BusinessException;
import com.example.LibraryApplication.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String CUSTOMER_NOT_EXISTS = "Sellist klienti ei eksisteeri";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
    public static final String ISIKUKOOD_ALREADY_TAKEN = "Isikukood on kasutusel";


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
