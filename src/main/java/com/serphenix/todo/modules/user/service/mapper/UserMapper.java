package com.serphenix.todo.modules.user.service.mapper;

import com.serphenix.todo.modules.user.domain.dto.UserDto;
import com.serphenix.todo.modules.user.entity.Users;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {
    public static UserDto makeUserDto(Users user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                null,
                user.getCreatedAt()
        );
    }
}
