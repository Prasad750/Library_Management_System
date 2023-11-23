package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.model.Book;
import com.example.Library_Management_System.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController{
    @Autowired
    BookServiceImpl bookServiceImpl;
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book)
    {
        try {
            String resp= bookServiceImpl.addBook(book);
            return new ResponseEntity(resp, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    // delete a book
    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam("id") int id)
    {
        bookServiceImpl.deleteBook(id);
        return new ResponseEntity("Book deleted",HttpStatus.GONE);
    }

    // give me names of all the books of a particular genre
    @GetMapping("/booksByGener/{gener}")
    public ResponseEntity booksByGener(@PathVariable("gener") String gener)
    {
        List<String> resp= bookServiceImpl.booksByGener(gener);
        return new ResponseEntity(resp,HttpStatus.FOUND);
    }


    // give me all the books having number of pages between 'a' and 'b'
    @GetMapping("/getBooksByPages")
    public ResponseEntity getBookByPages(@RequestParam("a")int a,@RequestParam("b") int b)
    {
        List<String> resp= bookServiceImpl.getBookBypages(a,b);
        return new ResponseEntity(resp,HttpStatus.FOUND);
    }

    // give me the names of all the authors who write a particular genre

    @GetMapping("/getAuthorByGener/{gener}")
    public ResponseEntity getAuthorByGener(@PathVariable("gener") String gener)
    {
        List<String>resp= bookServiceImpl.getAuthorByGener(gener);
        return new ResponseEntity(resp,HttpStatus.FOUND);
    }

}
