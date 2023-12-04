package com.leeonscoding.nplus1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthorsWithBooks() {
        return authorRepository.findAll();
    }
}
