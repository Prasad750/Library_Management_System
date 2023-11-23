package com.example.Library_Management_System.dto.requestDTO;

import com.example.Library_Management_System.Enum.Gender;
import com.example.Library_Management_System.Enum.Gener;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {

    String name;
    int age;
    String email;
    Gender gender;
}
