package com.agperezb.apiuser.controller;

import com.agperezb.apiuser.entity.User;
import com.agperezb.apiuser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/user/exist/{id}")
    public Boolean existUserById(@PathVariable UUID id) {
        return this.userService.existUserById(id);
    }


    @PostMapping("/user")
    public ResponseEntity<Object> save(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getById(id).map(user ->
                new ResponseEntity<>(user, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
