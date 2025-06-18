package com.example.batch.repositories;

import com.example.batch.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {
    @Query("SELECT u FROM User u")
    List<User> findUserCustom();
}