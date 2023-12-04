package com.leeonscoding.nplus1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add sample authors and books here
        Author author1 = new Author();
        author1.setName("Author 1");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setName("Author 2");
        authorRepository.save(author2);

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setAuthor(author1);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setAuthor(author1);
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setTitle("Book 3");
        book3.setAuthor(author2);
        bookRepository.save(book3);

    }
}

