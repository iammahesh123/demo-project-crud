package com.demo.demoprojectcrud.controller;

import com.demo.demoprojectcrud.model.StudentRequestDTO;
import com.demo.demoprojectcrud.model.StudentResponseDTO;
import com.demo.demoprojectcrud.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        StudentResponseDTO response = studentService.updateStudent(id, studentRequestDTO);
        return ResponseEntity.ok(response);
  }
   @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById (@PathVariable Long id) {
       StudentResponseDTO response = studentService.getById(id);
       return ResponseEntity.ok(response);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> deleteById (@PathVariable Long id) {
        StudentResponseDTO response = studentService.deleteById(id);
        return ResponseEntity.ok(response);
   }
}
