package com.example.Library_Management_System.service.Impl;

import com.example.Library_Management_System.exception.AuthorNotFoundException;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.model.Book;
import com.example.Library_Management_System.repository.AuthorRepository;
import com.example.Library_Management_System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {
        Author a=authorRepository.save(author);
        return "Author added successfully!";
    }

    @Override
    public String updateAuthorEmail(int id, String email) {
        Optional<Author>optionalAuthor=authorRepository.findById(id);
        if(optionalAuthor.isEmpty())
        {
            throw  new AuthorNotFoundException("Invalid Author Id");
        }
        Author author=optionalAuthor.get();
        author.setEmail(email);
        this.addAuthor(author);
        return "Author Email Updated";
    }

    @Override
    public List<String> getAuthorBooks(int id) {

        Optional<Author> optionalAuthor=authorRepository.findById(id);

        if(optionalAuthor.isEmpty())
        {
            throw new AuthorNotFoundException("Invalid Author id");
        }
        Author author=optionalAuthor.get();
        List<Book> bookList=author.getBooks();
        List<String> bookNameList=new ArrayList<>();
        for (Book b:bookList)
        {
            bookNameList.add(b.getTitle());
        }
        return bookNameList;
    }

    @Override
    public List<String> getAuthorByNoOfBooks(int x) {

       List<Author> authorList=authorRepository.findAll();

       List<String> authorsNameList=new ArrayList<>();
       for(Author a: authorList)
       {
           if(a.getBooks().size()>x)
           {
               authorsNameList.add(a.getName());
           }

       }
       return authorsNameList;
    }
}
