package com.leeonscoding.lazyexception;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //@Query("SELECT p FROM Post p JOIN FETCH p.commentList WHERE p.id = ?1")
    //Optional<Post> findById(int id);
}
