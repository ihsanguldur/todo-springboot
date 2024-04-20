package com.serphenix.todo.modules.todo.controller;

import com.serphenix.todo.infra.response.ResponseHandler;
import com.serphenix.todo.infra.response.dto.Response;
import com.serphenix.todo.modules.todo.controller.apidoc.TodoAPI;
import com.serphenix.todo.modules.todo.domain.dto.TodoDto;
import com.serphenix.todo.modules.todo.domain.request.TodoCreateRequest;
import com.serphenix.todo.modules.todo.service.TodoService;
import com.serphenix.todo.security.helper.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController implements TodoAPI {

    private final TodoService todoService;

    @Override
    @PostMapping("/todo")
    public Response<TodoDto> create(@RequestHeader("Authorization") String bearerToken, @RequestBody @Valid TodoCreateRequest request) {
        String[] bearerTokenArray = bearerToken.split(" ");
        String username = JwtHelper.extractUsername(bearerTokenArray[1]);

        return ResponseHandler.generateResponse(todoService.createTodo(request, username));
    }
}
