package com.bootcamp.weekone.controller;

import com.bootcamp.weekone.dao.UserDao;
import com.bootcamp.weekone.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user){
        user = userDao.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userDao.findById(id).orElseThrow());
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if(user.getId() == null){
            throw new RuntimeException("User id cannot be empty!");
        }
        boolean isExist = userDao.existsById(user.getId());
        if (!isExist){
            throw new RuntimeException("User does not exist!");
        }
        user = userDao.save(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/passive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id){

        User user = userDao.findById(id).orElseThrow();
        user.setActive(Boolean.FALSE);
        user = userDao.save(user);
        return ResponseEntity.ok(user);
    }
}
