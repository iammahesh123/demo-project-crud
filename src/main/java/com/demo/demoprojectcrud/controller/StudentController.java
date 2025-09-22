package com.demo.demoprojectcrud.controller;

import com.demo.demoprojectcrud.model.StudentRequestDTO;
import com.demo.demoprojectcrud.model.StudentResponseDTO;
import com.demo.demoprojectcrud.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentRequestDTO));
    }
}
