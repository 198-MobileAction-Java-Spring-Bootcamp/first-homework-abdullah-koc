package com.bootcamp.weekone.dao;

import com.bootcamp.weekone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
