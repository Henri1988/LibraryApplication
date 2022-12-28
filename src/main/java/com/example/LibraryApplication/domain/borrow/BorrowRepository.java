package com.example.LibraryApplication.domain.borrow;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}