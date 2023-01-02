package com.example.LibraryApplication.domain.returnborrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReturnBorrowRepository extends JpaRepository<ReturnBorrow, Integer> {
}