package com.example.Library_Management_System.service;

import com.example.Library_Management_System.model.Book;

import java.util.List;

public interface BookService {
    String addBook(Book book);

    void deleteBook(int id);

    List<String> booksByGener(String gener);

    List<String> getBookBypages(int a, int b);

    List<String> getAuthorByGener(String gener);
}
