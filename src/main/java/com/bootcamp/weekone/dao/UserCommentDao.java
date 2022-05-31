package com.bootcamp.weekone.dao;


import com.bootcamp.weekone.entities.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentDao extends JpaRepository<UserComment, Long> {
}
