package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.Enum.Gener;
import com.example.Library_Management_System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByGener(Gener gener);

    List<Book> findByNoOfPagesBetween(int a, int b);

    @Query("SELECT book.author.name FROM Book book WHERE book.gener = :gener GROUP BY book.author.name")
    List<String> findAuthorByBookGener(@Param("gener") Gener gener);
}
