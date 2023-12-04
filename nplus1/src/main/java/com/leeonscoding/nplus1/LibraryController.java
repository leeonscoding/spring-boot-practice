package com.leeonscoding.nplus1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = libraryService.getAllAuthorsWithBooks();

        // Access books for each author (triggering N+1 queries)
        for (Author author : authors) {
            List<Book> books = author.getBooks(); // N additional queries here
        }

        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
}
