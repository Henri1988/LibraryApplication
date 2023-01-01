package com.example.LibraryApplication.domain.user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select (count(u) > 0) from User u where upper(u.userName) = upper(?1)")
    boolean existsByUsername(String username);

    @Query("select u from User u where u.id = ?1")
    Optional<User> findUserById(Integer id);

    @Query("select u from User u where u.userName = ?1 and u.password = ?2")
    Optional<User> findByUsernameAndPassword(String userName, String password);









}