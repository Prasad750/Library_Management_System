package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.Enum.CardStatus;
import com.example.Library_Management_System.model.LibraryCard;

import java.util.UUID;

public class LibraryCardTransformer {

    public static LibraryCard prepareLibraryCard()
    {
        return LibraryCard.builder()
                .cardNo(UUID.randomUUID().toString())
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }
}
