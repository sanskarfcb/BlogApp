package com.sanskar.BlogApp.Repository;

import com.sanskar.BlogApp.Entity.Comment;
import com.sanskar.BlogApp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);
}
