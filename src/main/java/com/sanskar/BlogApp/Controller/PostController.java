package com.sanskar.BlogApp.Controller;

import com.sanskar.BlogApp.Dtos.PostDto;
import com.sanskar.BlogApp.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class PostController {

    @RestController
    @RequestMapping("/api/posts")
    @RequiredArgsConstructor
    public class BlogPostController {

        private final PostService postService;

        @GetMapping
        public ResponseEntity<Page<PostDto>> getAllPosts(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "5") int size) {
            return ResponseEntity.ok(postService.getAllPosts(page, size));
        }

        @GetMapping("/{id}")
        public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
            return ResponseEntity.ok(postService.getPostById(id));
        }

        @GetMapping("/user/{username}")
        public ResponseEntity<Page<PostDto>> getPostsByUser(
                @PathVariable String username,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "5") int size) {
            return ResponseEntity.ok(postService.getPostsByUsername(username, page, size));
        }

        // These endpoints will require authentication with JWT
        @PostMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto,
                                                      @RequestParam String username) {
            return ResponseEntity.ok(postService.createPost(dto, username));
        }

        @PutMapping("/{id}")
        public ResponseEntity<PostDto> updatePost(@PathVariable Long id,
                                                      @RequestBody PostDto dto,
                                                      @RequestParam String username) {
            return ResponseEntity.ok(postService.updatePost(id, dto, username));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletePost(@PathVariable Long id,
                                            @RequestParam String username) {
            postService.deletePost(id, username);
            return ResponseEntity.ok("Post deleted");
        }
    }
}