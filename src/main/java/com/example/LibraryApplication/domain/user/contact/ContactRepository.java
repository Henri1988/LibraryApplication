package com.example.LibraryApplication.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select c from Contact c where c.user.id = ?1")
    Contact findContactInfoByUserId(Integer id);

}