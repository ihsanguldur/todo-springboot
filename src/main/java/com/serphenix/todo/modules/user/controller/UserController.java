package com.serphenix.todo.modules.user.controller;

import com.serphenix.todo.infra.response.ResponseHandler;
import com.serphenix.todo.infra.response.dto.Response;
import com.serphenix.todo.modules.user.controller.apidoc.UserAPI;
import com.serphenix.todo.modules.user.domain.dto.LoginDto;
import com.serphenix.todo.modules.user.domain.dto.UserDto;
import com.serphenix.todo.modules.user.domain.request.LoginRequest;
import com.serphenix.todo.modules.user.domain.request.UserCreateRequest;
import com.serphenix.todo.modules.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;

    @Override
    @PostMapping("/register")
    public Response<UserDto> create(@Valid @RequestBody UserCreateRequest request) {
        return ResponseHandler.generateResponse(userService.createUser(request));
    }

    @Override
    @PostMapping("/login")
    public Response<LoginDto> login(@Valid @RequestBody LoginRequest request) {
        return ResponseHandler.generateResponse(userService.login(request));
    }
}
