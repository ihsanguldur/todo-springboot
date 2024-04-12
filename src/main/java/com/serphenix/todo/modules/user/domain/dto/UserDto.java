package com.serphenix.todo.modules.user.domain.dto;

import com.serphenix.todo.modules.todo.entity.Todos;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public record UserDto (
        @Schema(description = "id of user") int id,
        @Schema(description = "username of user") String username,
        @Schema(description = "todos of user") Set<Todos> todos,
        @Schema(description = "creation time of user")LocalDateTime createdAt
)
implements Serializable {}
