package com.example.Library_Management_System.service.Impl;

import com.example.Library_Management_System.Enum.Gener;
import com.example.Library_Management_System.exception.AuthorNotFoundException;
import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.model.Book;
import com.example.Library_Management_System.repository.AuthorRepository;
import com.example.Library_Management_System.repository.BookRepository;
import com.example.Library_Management_System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;


    @Override
    public String addBook(Book book) {

        Optional<Author> optionalAuthor= authorRepository.findById(book.getAuthor().getId());
        if(optionalAuthor.isEmpty())
        {
            throw new AuthorNotFoundException("Invalid Author Id !");
        }
        Author author=optionalAuthor.get();
        book.setAuthor(author);

        author.getBooks().add(book);
        Author a=authorRepository.save(author);
        return "Author successfully added";

    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<String> booksByGener(String gener) {
        List<Book> bookList=bookRepository.findByGener(Gener.valueOf(gener));
        List<String> bookNameList=new ArrayList<>();

        for(Book b:bookList)
        {
            bookNameList.add(b.getTitle());
        }
        return bookNameList;
    }

    @Override
    public List<String> getBookBypages(int a, int b) {

        List<Book> bookList=bookRepository.findByNoOfPagesBetween(a,b);
        List<String>bookNameList=new ArrayList<>();
        for(Book bk:bookList)
        {
            bookNameList.add(bk.getTitle());
        }

        return bookNameList;

    }

    @Override
    public List<String> getAuthorByGener(String gener) {

        List<String> bookList=bookRepository.findAuthorByBookGener(Gener.valueOf(gener));
        return bookList;
    }
}
