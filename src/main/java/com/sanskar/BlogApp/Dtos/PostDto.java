package com.sanskar.BlogApp.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String authorUsername;
    private LocalDateTime createdAt;
}
