package com.example.Library_Management_System.dto.responseDTO;

import com.example.Library_Management_System.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LibraryCardResponse {

    String libraryCardNo;
    CardStatus cardStatus;
    Date issueDate;

}
