package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserRequestDTO;

import com.example.demo.exception.UserNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;

import javax.print.attribute.UnmodifiableSetException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not found by id"+id));
    }

    public User createUser(UserRequestDTO dto){

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequestDTO dto){
         User user = userRepository.findById(id)
                 .orElseThrow(()->new UserNotFoundException("User not found with id"+ id));

         user.setName(dto.getName());
         user.setEmail(dto.getEmail());
         user.setAge(dto.getAge());

         return userRepository.save(user);
    }
}

