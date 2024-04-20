package com.serphenix.todo.modules.todo.service;

import com.serphenix.todo.infra.exception.UserNotFoundException;
import com.serphenix.todo.modules.todo.domain.dto.TodoDto;
import com.serphenix.todo.modules.todo.domain.request.TodoCreateRequest;
import com.serphenix.todo.modules.todo.entity.Todos;
import com.serphenix.todo.modules.todo.repository.TodoRepository;
import com.serphenix.todo.modules.todo.service.mapper.TodoMapper;
import com.serphenix.todo.modules.user.entity.Users;
import com.serphenix.todo.modules.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    private final UserRepository userRepository;

    public TodoDto createTodo(@Valid TodoCreateRequest request, String username) {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("user not found with username %s", username)));


        // save ederken relation nasil saglaniyor buna bak
        Todos todo = Todos.builder()
                .content(request.getContent())
                .status(true)
                .user(user)
                .build();
        Todos createdTodo = todoRepository.save(todo);

        return TodoMapper.makeTodoDto(createdTodo);
    }
}
