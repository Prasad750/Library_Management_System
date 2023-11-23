package com.example.Library_Management_System.dto.responseDTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StudentResponse{

    String name;
    String email;
    LibraryCardResponse libraryCardResponse;

}
