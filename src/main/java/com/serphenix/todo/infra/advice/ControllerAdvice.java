package com.serphenix.todo.infra.advice;

import com.serphenix.todo.infra.exception.DataFetchException;
import com.serphenix.todo.infra.exception.UserNotFoundException;
import com.serphenix.todo.infra.response.ResponseHandler;
import com.serphenix.todo.infra.response.dto.ApiErrorResponse;
import com.serphenix.todo.infra.response.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<ApiErrorResponse>> handleMethodArgumentNotValidException(Exception exception) {
        log.error("unexpected error: ", exception);

        List<String> message = new ArrayList<>();
        ((MethodArgumentNotValidException) exception).getFieldErrors().forEach(entry -> {
            message.add(entry.getDefaultMessage());
        });

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), message.toString());

        return new ResponseEntity<>(ResponseHandler.generateErrorResponse(apiErrorResponse), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response<ApiErrorResponse>> handleDataIntegrityViolationException(Exception exception) {
        log.error("unexpected error: ", exception);

        String [] messages = exception.getMessage().split("\\[");
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), messages[1].replace("]","").trim());

        return new ResponseEntity<>(ResponseHandler.generateErrorResponse(apiErrorResponse), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response<ApiErrorResponse>> handleUserNotFoundException(Exception exception) {
        log.error("unexpected error: ", exception);

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), exception.getMessage());

        return new ResponseEntity<>(ResponseHandler.generateErrorResponse(apiErrorResponse), HttpStatus.BAD_REQUEST);
    }
}
