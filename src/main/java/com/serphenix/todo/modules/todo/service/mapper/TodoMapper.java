package com.serphenix.todo.modules.todo.service.mapper;

import com.serphenix.todo.modules.todo.domain.dto.TodoDto;
import com.serphenix.todo.modules.todo.entity.Todos;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TodoMapper {

    public static TodoDto makeTodoDto(Todos todo) {
        return new TodoDto(
                todo.getId(),
                todo.getContent(),
                todo.isStatus(),
                todo.getCreatedAt()
        );
    }

}
