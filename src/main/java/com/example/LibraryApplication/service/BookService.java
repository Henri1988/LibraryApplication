package com.example.LibraryApplication.service;
import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookDto;
import com.example.LibraryApplication.domain.book.BookMapper;
import com.example.LibraryApplication.domain.book.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;
    @Resource
    private BookMapper bookMapper;


    public BookDto addBook(BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        log.info("Adding book...");
        bookRepository.save(book);
        log.info("New book, title: " + book.getTitle() + " with id " + book.getId() + " added!");
        return bookMapper.toDto(book);
    }
}
