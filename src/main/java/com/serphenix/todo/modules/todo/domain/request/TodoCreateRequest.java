package com.serphenix.todo.modules.todo.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoCreateRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -1652775060107151137L;

    @NotEmpty(message = "content can not be empty")
    private String content;
}
