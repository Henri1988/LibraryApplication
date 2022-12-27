package com.example.LibraryApplication.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.id = ?1")
    Optional<Book> findBookById(Integer id);

    @Query("select b from Book b where b.title = ?1")
    Optional<Book> findBookByTitle(String title);






}