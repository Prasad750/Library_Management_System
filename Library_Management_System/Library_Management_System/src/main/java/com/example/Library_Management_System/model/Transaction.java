package com.example.Library_Management_System.model;

import com.example.Library_Management_System.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String transactionNo;

    @CreationTimestamp
    Date date;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;


    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;

    @ManyToOne
    @JoinColumn
    Book book;


}
