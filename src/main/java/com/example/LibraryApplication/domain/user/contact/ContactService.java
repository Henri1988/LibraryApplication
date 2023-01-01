package com.example.LibraryApplication.domain.user.contact;


import com.example.LibraryApplication.domain.user.contact.Contact;
import com.example.LibraryApplication.domain.user.contact.ContactMapper;
import com.example.LibraryApplication.domain.user.contact.ContactRepository;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.service.register.RegisterRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

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

    public Contact findContactById(Integer id) {
        return contactRepository.findContactInfoByUserId(id);
    }

    public Contact findContactInfoByLastName(String lastName) {
        return contactRepository.findContactByLastName(lastName);
    }

    public Contact getUserFirstLastNameById(Integer userId) {
        return contactRepository.getUserFirstLastNameById(userId);
    }
}
