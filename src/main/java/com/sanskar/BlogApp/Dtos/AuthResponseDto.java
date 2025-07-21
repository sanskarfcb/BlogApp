package com.sanskar.BlogApp.Dtos;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String token;
    private String tokentype="Bearer";
}
