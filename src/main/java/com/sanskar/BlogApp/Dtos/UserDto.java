package com.sanskar.BlogApp.Dtos;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

}
