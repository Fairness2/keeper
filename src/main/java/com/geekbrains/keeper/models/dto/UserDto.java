package com.geekbrains.keeper.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserDto {
    Integer id;
    String username;
    String password;
}
