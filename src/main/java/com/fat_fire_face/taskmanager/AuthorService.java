package com.fat_fire_face.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long authorId){
        return authorRepository.findById(authorId).
                orElseThrow(() -> new NoSuchElementException("не найден автор по указанному ID " + authorId));
    }

    public Author createAuthor(Author author){
        author.setPassword(passwordEncoder.encode(author.getPassword()));
        return authorRepository.save(author);
    }

    public Author getAuthorByUsername(String username){
        return authorRepository.findByUsername(username);
    }
}
