package com.serphenix.todo.modules.user.controller.apidoc;

import com.serphenix.todo.infra.response.dto.ApiErrorResponse;
import com.serphenix.todo.infra.response.dto.Response;
import com.serphenix.todo.modules.user.domain.dto.LoginDto;
import com.serphenix.todo.modules.user.domain.dto.UserDto;
import com.serphenix.todo.modules.user.domain.request.LoginRequest;
import com.serphenix.todo.modules.user.domain.request.UserCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "User API", description = "User Service API for user related operations")
public interface UserAPI {

    @Operation(
            summary = "Creates a new user",
            description = "Creates a new user with the specified details in request body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "unauthorized", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "forbidden", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "method not allowed", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    Response<UserDto> create(@RequestBody UserCreateRequest request);

    @Operation(
            summary = "Login with a user",
            description = "Login with a user with the specified details in request body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = LoginDto.class))),
            @ApiResponse(responseCode = "400", description = "bad request", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "unauthorized", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "403", description = "forbidden", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "method not allowed", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    Response<LoginDto> login(@RequestBody LoginRequest request);
}
