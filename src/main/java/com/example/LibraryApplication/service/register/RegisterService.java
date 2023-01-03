package com.example.LibraryApplication.service.register;

import com.example.LibraryApplication.domain.user.contact.Contact;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.user.contact.ContactService;
import com.example.LibraryApplication.domain.user.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class RegisterService {

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;



    public RegisterResponse registerNewUser(RegisterRequest request) {
        User user = userService.addNewUser(request);
        contactService.addNewContact(user, request);
        return new RegisterResponse(user.getId());
    }

    public RegisterRequest findUserInfoById(Integer id, Integer userSessionId) {

        RegisterRequest response = new RegisterRequest();
        log.info("Searching member with id " + id + "...");
        User user =userService.findUserInfoById(id);
        Contact contact =contactService.findContactById(user.getId());

        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        response.setAddress(contact.getAddress());
        response.setEmail(contact.getEmail());
        response.setFirstName(contact.getFirstName());
        response.setLastName(contact.getLastName());
        response.setMobileNumber(contact.getMobileNumber());
        log.debug("User: " + response.getFirstName() + " " + response.getLastName()+ " found!");
        return response;
    }


    public RegisterRequest findUserInfoByLastName(String lastName, Integer userSessionId) {

        RegisterRequest response = new RegisterRequest();
        log.info("Searching member with lastname " + lastName + "...");
        Contact contact =contactService.findContactInfoByLastName(lastName);
        User user =userService.findUserInfoById(contact.getUser().getId());

        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        response.setAddress(contact.getAddress());
        response.setEmail(contact.getEmail());
        response.setFirstName(contact.getFirstName());
        response.setLastName(contact.getLastName());
        response.setMobileNumber(contact.getMobileNumber());
        log.info("User: " + response.getFirstName() + " " + response.getLastName()+ " found!");
        return response;

    }
}