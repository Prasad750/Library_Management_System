package com.example.Library_Management_System.transformer;

import com.example.Library_Management_System.dto.requestDTO.StudentRequest;
import com.example.Library_Management_System.dto.responseDTO.LibraryCardResponse;
import com.example.Library_Management_System.dto.responseDTO.StudentResponse;
import com.example.Library_Management_System.model.Student;

public class StudentTransformer {

    public static Student StudentRequestToStudent(StudentRequest studentRequest)
    {
      return   Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student)
    {
        LibraryCardResponse cardResponse=LibraryCardResponse.builder()
                .libraryCardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();

        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardResponse(cardResponse)
                .build();
    }
}
