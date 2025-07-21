package com.sanskar.BlogApp.Controller;

import com.sanskar.BlogApp.Dtos.CommentDto;
import com.sanskar.BlogApp.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long postId,
                                                 @RequestBody String content,
                                                 @RequestParam String username) {
        return ResponseEntity.ok(commentService.addComment(postId, username, content));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId,
                                           @RequestParam String username) {
        commentService.deleteComment(commentId, username);
        return ResponseEntity.ok("Comment deleted");
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsForPost(postId));
    }
}
