package com.example.LibraryApplication.service.contact;


import com.example.LibraryApplication.domain.user.contact.Contact;
import com.example.LibraryApplication.domain.user.contact.ContactMapper;
import com.example.LibraryApplication.domain.user.contact.ContactRepository;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.service.register.RegisterRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {
    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactRepository contactRepository;

    public void addNewContact(User user, RegisterRequest request) {
        Contact contact = contactMapper.toEntity(request);
        contact.setUser(user);
        contactRepository.save(contact);
    }
}
