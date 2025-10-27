package com.example.products.controllers;

import com.example.products.domain.user.RequestUserDTO;
import com.example.products.domain.user.User;
import com.example.products.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")

public class UserController {

   @Autowired
    private UserRepository repository;

    //Buscar informações do DB
    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = repository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    //Enviar informações para o DB
    @PostMapping
    public ResponseEntity addUser(@RequestBody @Validated RequestUserDTO data){
        User newUser = new User(data);
        System.out.println(data);
        repository.save(newUser);
        return ResponseEntity.ok(data);
    }
}
