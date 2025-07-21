package com.sanskar.BlogApp.Service.Implementation;


import com.sanskar.BlogApp.Dtos.CommentDto;
import com.sanskar.BlogApp.Entity.Comment;
import com.sanskar.BlogApp.Entity.Post;
import com.sanskar.BlogApp.Entity.User;
import com.sanskar.BlogApp.Repository.CommentRepository;
import com.sanskar.BlogApp.Repository.PostRepository;
import com.sanskar.BlogApp.Repository.UserRepository;
import com.sanskar.BlogApp.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentDto addComment(Long postId, String username, String content) {

        Post post = postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post not found"));

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setCommenter(user);

        return mapToDTO(commentRepository.save(comment));
    }
    @Override
    public void deleteComment(Long commentId, String username) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        if (!comment.getCommenter().getUsername().equals(username)) {
            throw new RuntimeException("Unauthorized to delete this comment");
        }

        commentRepository.delete(comment);
    }

    @Override
    public List<CommentDto> getCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return commentRepository.findByPost(post).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CommentDto mapToDTO(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setCommenterUsername(comment.getCommenter().getUsername());
        return dto;
    }
}
