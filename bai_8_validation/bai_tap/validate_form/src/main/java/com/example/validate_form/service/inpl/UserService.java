package com.example.validate_form.service.inpl;

import com.example.validate_form.repository.IUserRepository;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
}
