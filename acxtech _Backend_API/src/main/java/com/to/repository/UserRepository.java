package com.to.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.to.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
