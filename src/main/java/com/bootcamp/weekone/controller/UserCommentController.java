package com.bootcamp.weekone.controller;


import com.bootcamp.weekone.dao.UserCommentDao;
import com.bootcamp.weekone.entities.UserComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_comment")
@RequiredArgsConstructor
public class UserCommentController {

    private final UserCommentDao userCommentDao;

    @PostMapping
    public ResponseEntity<UserComment> registerComment(@RequestBody UserComment userComment){
        if(!userComment.getUser().isActive()){
            throw new RuntimeException("User is not active and cannot comment.");
        }
        userCommentDao.save(userComment);
        return new ResponseEntity<>(userComment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserComment>> findAll(){
        return ResponseEntity.ok(userCommentDao.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserComment> deleteComment(@PathVariable Long id){
        boolean isExist = userCommentDao.existsById(id);
        if(!isExist){
            throw new RuntimeException("Comment does not exist!");
        }
        UserComment userComment = userCommentDao.findById(id).orElseThrow();
        userCommentDao.deleteById(id);
        return ResponseEntity.ok(userComment);
    }

    @PutMapping("/{id}/{comment}")
    public ResponseEntity<UserComment> updateComment(@PathVariable Long id, @PathVariable String comment){
        boolean isExist = userCommentDao.existsById(id);
        if(!isExist){
            throw new RuntimeException("Comment does not exist!");
        }
        UserComment userComment = userCommentDao.findById(id).orElseThrow();
        userComment.setComment(comment);
        userCommentDao.save(userComment);
        return ResponseEntity.ok(userComment);
    }

}
