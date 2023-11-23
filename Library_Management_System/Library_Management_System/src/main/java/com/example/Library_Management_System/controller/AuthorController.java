package com.example.Library_Management_System.controller;


import com.example.Library_Management_System.model.Author;
import com.example.Library_Management_System.service.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author)
    {
        String resp= authorServiceImpl.addAuthor(author);
        return new ResponseEntity(resp, HttpStatus.CREATED);
    }

    //update emailId
    @PutMapping("/update/{email}")
    public ResponseEntity updateAuthorEmail(@RequestParam("id")int id,@PathVariable("email") String email)
    {
        try {
            String resp= authorServiceImpl.updateAuthorEmail(id,email);
            return new ResponseEntity(resp,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    //names of all books of author

    @GetMapping("/getAuthorBooks")
    public ResponseEntity getAuthorBooks(@RequestParam("id") int id)
    {
        try {
            List<String> bookList= authorServiceImpl.getAuthorBooks(id);
            return new ResponseEntity(bookList,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    // author with more than x no of books
    @GetMapping("/getAuthorByNoOfBooks/{x}")
    public ResponseEntity getAuthorByNoOfBooks(@PathVariable("x") int x)
    {
        List<String>resp= authorServiceImpl.getAuthorByNoOfBooks(x);
        return new ResponseEntity(resp,HttpStatus.FOUND);
    }
}
