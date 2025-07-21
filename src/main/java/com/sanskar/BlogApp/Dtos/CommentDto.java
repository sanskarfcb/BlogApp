package com.sanskar.BlogApp.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private String commenterUsername;
    private LocalDateTime createdAt;
}
