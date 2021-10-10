package com.geekbrains.keeper.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    Integer id;
    String username;
    String password;
}
