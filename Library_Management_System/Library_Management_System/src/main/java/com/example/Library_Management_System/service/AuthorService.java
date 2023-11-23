package com.example.Library_Management_System.service;

import com.example.Library_Management_System.model.Author;

import java.util.List;

public interface AuthorService {

    public String addAuthor(Author author);
    public String updateAuthorEmail(int id, String email);
    public List<String> getAuthorBooks(int id);
    public List<String> getAuthorByNoOfBooks(int x);

}
