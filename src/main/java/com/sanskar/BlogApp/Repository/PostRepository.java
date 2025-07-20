package com.sanskar.BlogApp.Repository;

import com.sanskar.BlogApp.Entity.Post;
import com.sanskar.BlogApp.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findAll(Pageable pageable);
    Page<Post> findByAuthor(User user, Pageable pageable);

}
