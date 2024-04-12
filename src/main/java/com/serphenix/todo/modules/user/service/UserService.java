package com.serphenix.todo.modules.user.service;

import com.serphenix.todo.modules.user.domain.dto.UserDto;
import com.serphenix.todo.modules.user.domain.request.UserCreateRequest;
import com.serphenix.todo.modules.user.entity.Users;
import com.serphenix.todo.modules.user.repository.UserRepository;
import com.serphenix.todo.modules.user.service.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // access with security
    // private final PasswordEncoder passwordEncoder;

    public UserDto createUser(@Valid UserCreateRequest request) {
        Users user = Users.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();

        Users createdUser = userRepository.save(user);
        log.info("User created: ", createdUser.getId());

        return UserMapper.makeUserDto(createdUser);
    }
}
