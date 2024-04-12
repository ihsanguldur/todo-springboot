package com.serphenix.todo.infra.advice;

import com.serphenix.todo.infra.exception.DataFetchException;
import com.serphenix.todo.infra.response.ResponseHandler;
import com.serphenix.todo.infra.response.dto.ApiErrorResponse;
import com.serphenix.todo.infra.response.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerAdvice {

    @ExceptionHandler(DataFetchException.class)
    public ResponseEntity<Response<ApiErrorResponse>> handleDataFetchException(Exception exception) {
        log.error("unexpected error: ", exception);
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), exception.getMessage());

        return new ResponseEntity<>(ResponseHandler.generateErrorResponse(apiErrorResponse), HttpStatus.BAD_REQUEST);
    }
}
