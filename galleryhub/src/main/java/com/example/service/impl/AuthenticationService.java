package com.example.service.impl;

import com.example.dto.AuthRequest;
import com.example.dto.DtoUser;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class AuthenticationService implements IAuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }
    private User createUser(AuthRequest authRequest) {
        User user = new User();
        user.setCreatedTime(new Date());
        user.setUsernameField(authRequest.getUsername());
        user.setPasswordField(passwordEncoder.encode(authRequest.getPassword()));
        return user;
    }
    @Override
    public DtoUser register(AuthRequest authRequest) {
        DtoUser dtoUser = new DtoUser();
        User save = userRepository.save(createUser(authRequest));
        BeanUtils.copyProperties(save, dtoUser);
        return dtoUser;
    }
}
