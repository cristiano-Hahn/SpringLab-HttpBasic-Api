package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.repository.dto.AccountCreateDto;
import com.example.security.service.AccountCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    private final AccountCreateService accountCreateService;

    @Autowired
    public AccountController(AccountCreateService accountCreateService) {
        this.accountCreateService = accountCreateService;
    }

    @PostMapping("/account/create")
    public ResponseEntity<User> createUser(@RequestBody AccountCreateDto accountCreateDto) {

        Optional<User> saved = accountCreateService.execute(accountCreateDto.getUsername(), accountCreateDto.getPassword());

        if (saved.isPresent())
            return new ResponseEntity<>(saved.get(), null, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(saved.get(), null, HttpStatus.BAD_REQUEST);
    }
}
