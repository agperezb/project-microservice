package com.agperezb.apiuser.service;

import com.agperezb.apiuser.entity.User;
import com.agperezb.apiuser.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> getById(UUID id) {
        return this.userRepository.findById(id);
    }

    public Boolean existUserById(UUID id) {
        return userRepository.existsById(id);
    }

}
