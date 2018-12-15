package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Page<User> findAll(Pageable p) {
        return userRepository.findAll(p);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PatchMapping("/users")
    public User update(@RequestBody User user) {
        User userSave = userRepository.getOne(user.getId());

        userSave.setUsername(user.getUsername());
        userSave.setAccountExpired(user.getAccountExpired());
        userSave.setAccountLocked(user.getAccountLocked());
        userSave.setCredentialsExpired(user.getCredentialsExpired());
        userSave.setEnabled(user.getEnabled());
        userSave.setPassword(user.getPassword());

        return userRepository.save(user);
    }
}
