package com.serphenix.todo.infra.response;

import com.serphenix.todo.infra.response.dto.ApiErrorResponse;
import com.serphenix.todo.infra.response.dto.Response;

import java.util.Collections;

public class ResponseHandler {

    public static <T> Response<T> generateResponse(T data) {
        Response<T> response = new Response<>();
        response.setData(data);

        return response;
    }

    public static <T> Response<T> generateErrorResponse(ApiErrorResponse errorResponse) {
        Response<T> response = new Response<>();
        response.setErrors(Collections.singletonList(errorResponse));

        return response;
    }
}
