package com.example.LibraryApplication.domain.user.usersession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {
    @Query("select u from UserSession u where u.id = ?1")
    Optional<UserSession> getUserSessionById(Integer id);
}