package com.example.Library_Management_System.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "author_name")
    String name;

    int age;

    @Column(unique = true,nullable = false)
    String email;

    @UpdateTimestamp
    Date lastActivity;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)   //CascadeType.ALL helps to apply same  parent's CRUD operation on child
    List<Book> books=new ArrayList<>();
}
