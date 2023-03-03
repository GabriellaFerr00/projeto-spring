package com.webservice.projetospring.controllers;

import com.webservice.projetospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //recurso web implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Gabi", "gabi@gmail.com", "99999999", "123456");
        return ResponseEntity.ok().body(user);
    }
}
