package com.sanskar.BlogApp.Service;

import com.sanskar.BlogApp.Dtos.PostDto;
import org.springframework.data.domain.Page;


public interface PostService {

    PostDto createPost(PostDto postDto , String username);
    PostDto updatePost(Long postId, PostDto postDTO, String username);
    void deletePost(Long postId, String username);
    PostDto getPostById(Long id);
    Page<PostDto> getAllPosts(int page, int size);
    Page<PostDto> getPostsByUsername(String username, int page, int size);
}
