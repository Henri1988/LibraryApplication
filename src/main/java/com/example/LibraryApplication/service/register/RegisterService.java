package com.example.LibraryApplication.service.register;


import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.service.contact.ContactService;
import com.example.LibraryApplication.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;


    public RegisterResponse registerNewUser(RegisterRequest request) {
        User user = userService.addNewUser(request);
        contactService.addNewContact(user, request);
//        userRoleService.addNewUserRole(user.getId());
        return new RegisterResponse(user.getId());
    }
}
