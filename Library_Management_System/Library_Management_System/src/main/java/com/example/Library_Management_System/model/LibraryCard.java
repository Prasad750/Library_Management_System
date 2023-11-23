package com.example.Library_Management_System.model;

import com.example.Library_Management_System.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class LibraryCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cardNo;

    @CreationTimestamp
    Date issueDate;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();
}
