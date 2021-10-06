package com.geekbrains.keeper.services;

import com.geekbrains.keeper.exceptions.UserNotFoundException;
import com.geekbrains.keeper.models.dto.UserDto;
import com.geekbrains.keeper.models.entities.User;
import com.geekbrains.keeper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public User getUserByCredentials(String username, String password) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

    public User createUser(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        return repository.save(user);
    }
}
