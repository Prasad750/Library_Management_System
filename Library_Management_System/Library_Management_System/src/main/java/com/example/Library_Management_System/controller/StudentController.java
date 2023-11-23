package com.example.Library_Management_System.controller;

import com.example.Library_Management_System.dto.requestDTO.StudentRequest;
import com.example.Library_Management_System.dto.responseDTO.StudentResponse;
import com.example.Library_Management_System.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest)
    {
        StudentResponse resp= studentServiceImpl.addStudent(studentRequest);
         return new ResponseEntity(resp, HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("regNo") int regNo)
    {
        StudentResponse resp= studentServiceImpl.getStudent(regNo);
        return new ResponseEntity(resp,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("regNo") int regNo)
    {
        studentServiceImpl.deleteStudent(regNo);
        return new ResponseEntity("Success",HttpStatus.OK);
    }

    @PutMapping("/update-age/{age}")
    public ResponseEntity updateStudentAge(@RequestParam("regNo") int regNo,@PathVariable("age") int age)
    {
        studentServiceImpl.updateStudentAge(regNo,age);
        return  new ResponseEntity("success",HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllStudents()
    {
        List<String> studentList= studentServiceImpl.getAllStudents();
        return new ResponseEntity(studentList,HttpStatus.FOUND);
    }


    @GetMapping("/getBoys")
    public ResponseEntity getAllBoys()
    {
        List<String> studentList= studentServiceImpl.getAllBoys();
        return new ResponseEntity(studentList,HttpStatus.FOUND);
    }
}
