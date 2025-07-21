package com.sanskar.BlogApp.Service;

import com.sanskar.BlogApp.Dtos.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto addComment(Long postId, String username, String content);
    void deleteComment(Long commentId, String username);
    List<CommentDto> getCommentsForPost(Long postId);
}
