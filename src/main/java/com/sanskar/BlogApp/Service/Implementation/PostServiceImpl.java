package com.sanskar.BlogApp.Service.Implementation;

import com.sanskar.BlogApp.Dtos.PostDto;
import com.sanskar.BlogApp.Entity.Post;
import com.sanskar.BlogApp.Entity.User;
import com.sanskar.BlogApp.Repository.PostRepository;
import com.sanskar.BlogApp.Repository.UserRepository;
import com.sanskar.BlogApp.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDto createPost(PostDto postDto, String username) {
        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAuthor(author);

        Post saved = postRepository.save(post);
        return mapToDTO(saved);
    }

    public PostDto updatePost(Long postId, PostDto postDto, String username) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("Unauthorized to update this post");
        }

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        return mapToDTO(postRepository.save(post));
    }

    public void deletePost(Long postId, String username) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("Unauthorized to delete this post");
        }

        postRepository.delete(post);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return mapToDTO(post);
    }

    @Override
    public Page<PostDto> getAllPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return postRepository.findAll(pageable).map(this::mapToDTO);
    }

    @Override
    public Page<PostDto> getPostsByUsername(String username, int page, int size) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findByAuthor(user, pageable).map(this::mapToDTO);
    }

    private PostDto mapToDTO(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setAuthorUsername(post.getAuthor().getUsername());
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
    }
}