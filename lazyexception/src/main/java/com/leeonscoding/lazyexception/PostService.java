package com.leeonscoding.lazyexception;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired private PostRepository repository;

    public Post getPost(int id) {
        /*Post post = repository.findById(id).orElseThrow();
        List<Comment> comments = new ArrayList<>(post.getCommentList());
        return new PostDTO(post.getTitle(), comments);*/

/*        Post post = repository.findById(id).orElseThrow();
        Hibernate.initialize(post.getCommentList());
        return post;*/

        return repository.findById(id).orElseThrow();
    }

    public void addPost(Post post) {
        repository.save(post);
    }
}
