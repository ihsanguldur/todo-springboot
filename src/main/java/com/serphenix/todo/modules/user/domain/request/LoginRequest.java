package com.serphenix.todo.modules.user.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5990925562996344772L;

    @NotEmpty(message = "username can not be empty")
    private String username;

    @NotEmpty(message = "password can not be empty")
    @Length(min = 6, max = 30, message = "password must be min 6 and max 30 character")
    private String password;
}
