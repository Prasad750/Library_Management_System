package com.example.Library_Management_System.dto.responseDTO;

import com.example.Library_Management_System.Enum.Gener;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookResponse {

    String title;
    int noOfPages;
    Gener gener;
    double cost;
    String authorName;
}
