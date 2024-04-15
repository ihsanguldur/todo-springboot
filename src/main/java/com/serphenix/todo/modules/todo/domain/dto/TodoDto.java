package com.serphenix.todo.modules.todo.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

public record TodoDto(
        @Schema(description = "id for todo") Integer id,
        @Schema(description = "content for todo") String content,
        @Schema(description = "status for todo") boolean status,
        @Schema(description = "creation time for todo") LocalDateTime createdAt
) implements Serializable {}
