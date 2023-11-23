package com.example.Library_Management_System.service.Impl;

import com.example.Library_Management_System.Enum.Gender;
import com.example.Library_Management_System.dto.requestDTO.StudentRequest;
import com.example.Library_Management_System.dto.responseDTO.StudentResponse;
import com.example.Library_Management_System.model.LibraryCard;
import com.example.Library_Management_System.model.Student;
import com.example.Library_Management_System.repository.StudentRepository;
import com.example.Library_Management_System.service.StudentService;
import com.example.Library_Management_System.transformer.LibraryCardTransformer;
import com.example.Library_Management_System.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public StudentResponse addStudent(StudentRequest studentRequest) {


        //creating  student from studentRequest
        Student student= StudentTransformer.StudentRequestToStudent(studentRequest);


        // library card generate as student add
        LibraryCard libraryCard=LibraryCardTransformer.prepareLibraryCard();

        //
        libraryCard.setStudent(student);
        student.setLibraryCard(libraryCard);


        //add student
        Student saveStudent=studentRepository.save(student);

        //creating StudentResponse from student
        return StudentTransformer.StudentToStudentResponse(saveStudent);
    }

    @Override
    public StudentResponse getStudent(int regNo) {

        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent())
        {
            System.out.println(optionalStudent.get());
            return StudentTransformer.StudentToStudentResponse(optionalStudent.get());
        }
        return null;

    }

    @Override
    public void deleteStudent(int regNo) {
        studentRepository.deleteById(regNo);
    }

    @Override
    public void updateStudentAge(int regNo, int age) {
        Optional<Student> optionalStudent=studentRepository.findById(regNo);
        if (optionalStudent.isPresent())
        {
            Student student=optionalStudent.get();
            student.setAge(age);
            studentRepository.save(student);
        }


    }

    @Override
    public List<String> getAllStudents() {
        List<Student> studentList= studentRepository.findAll();

        List<String> studentNameList=new ArrayList<>();
        for(Student s:studentList)
        {
            studentNameList.add(s.getName());
        }

        return studentNameList;


    }

    @Override
    public List<String> getAllBoys() {

        List<Student> boysList= studentRepository.findByGender(Gender.MALE);

        List<String> boysNameList=new ArrayList<>();
        for(Student b:boysList)
        {
            boysNameList.add(b.getName());
        }
        return boysNameList;
    }
}
