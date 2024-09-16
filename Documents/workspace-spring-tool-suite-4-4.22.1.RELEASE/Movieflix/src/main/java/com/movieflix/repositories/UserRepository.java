package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByEmailId(String emailId);
  }
