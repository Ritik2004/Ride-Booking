package com.example.demo.controller;


import com.example.demo.dto.UserRequestDTO;
import com.example.demo.service.UserService;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getByid/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
         return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO dto){
        return ResponseEntity.ok(userService.updateUser(id,dto));
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        User user = userService.createUser(userRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
