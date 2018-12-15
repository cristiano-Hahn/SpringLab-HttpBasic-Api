package com.example.security.service;

import com.example.security.exception.UserAlreadyExistsException;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCreateService {

    private final UserRepository userRepository;

    @Autowired
    public AccountCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(String username, String password) {

        if(userRepository.findByUsername(username) != null)
            throw new UserAlreadyExistsException();

        User user = new User();
        try {
            user.setUsername(username);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setEnabled(true);
            user.setAccountExpired(false);
            user.setAccountLocked(false);
            user.setCredentialsExpired(false);

            return Optional.of(userRepository.save(user));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
