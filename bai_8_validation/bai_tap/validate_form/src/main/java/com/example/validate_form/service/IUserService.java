package com.example.validate_form.service;
import com.example.validate_form.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(int id);

    void save(User user);

    void update(User user);
}
