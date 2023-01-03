package com.example.LibraryApplication.domain.returnborrow;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowReturnRepository extends JpaRepository<BorrowReturn, Integer> {
}