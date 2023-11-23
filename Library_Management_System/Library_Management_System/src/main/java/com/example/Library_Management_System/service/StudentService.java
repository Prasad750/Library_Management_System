package com.example.Library_Management_System.service;

import com.example.Library_Management_System.dto.requestDTO.StudentRequest;
import com.example.Library_Management_System.dto.responseDTO.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse addStudent(StudentRequest studentRequest);

    StudentResponse getStudent(int regNo);

    void deleteStudent(int regNo);

    void updateStudentAge(int regNo, int age);

    List<String> getAllStudents();

    List<String> getAllBoys();
}
