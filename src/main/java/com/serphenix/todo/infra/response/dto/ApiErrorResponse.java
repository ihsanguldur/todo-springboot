package com.serphenix.todo.infra.response.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ApiErrorResponse (
    @Schema(description = "http error code") Integer errorCode,
    @Schema(description = "http error name") String error,
    @Schema(description = "detailed error description") String description
){}
