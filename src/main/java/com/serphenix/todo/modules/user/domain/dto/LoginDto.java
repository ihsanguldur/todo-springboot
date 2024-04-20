package com.serphenix.todo.modules.user.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public record LoginDto(
        @Schema(description = "bearer token") String token
) implements Serializable {}
