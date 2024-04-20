package com.serphenix.todo.modules.user.service;

import com.serphenix.todo.modules.user.domain.dto.LoginDto;
import com.serphenix.todo.modules.user.domain.dto.UserDto;
import com.serphenix.todo.modules.user.domain.request.LoginRequest;
import com.serphenix.todo.modules.user.domain.request.UserCreateRequest;
import com.serphenix.todo.modules.user.entity.Users;
import com.serphenix.todo.modules.user.repository.UserRepository;
import com.serphenix.todo.modules.user.service.mapper.UserMapper;
import com.serphenix.todo.security.helper.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UserDto createUser(@Valid UserCreateRequest request) {
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        Users user = Users.builder()
                .username(request.getUsername())
                .password(hashedPassword)
                .build();


        Users createdUser = userRepository.save(user);
        log.info("User created: ", createdUser.getId());

        return UserMapper.makeUserDto(createdUser);
    }

    public LoginDto login(@Valid LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw e;
        }

        String token = JwtHelper.generateToken(request.getUsername());

        return new LoginDto(token);
    }
}
