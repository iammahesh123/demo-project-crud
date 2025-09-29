package com.demo.demoprojectcrud.service;

import com.demo.demoprojectcrud.entity.Student;
import com.demo.demoprojectcrud.mapper.StudentMapper;
import com.demo.demoprojectcrud.model.StudentRequestDTO;
import com.demo.demoprojectcrud.model.StudentResponseDTO;
import com.demo.demoprojectcrud.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ModelMapper modelMapper;
//    private final StudentRequestDTO studentRequestDTO;


    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.modelMapper = modelMapper;
//        this.studentRequestDTO = studentRequestDTO;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDTO, student);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO studentRequestDTO){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
        BeanUtils.copyProperties(studentRequestDTO, student);
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDTO(updatedStudent);
    }

    public StudentResponseDTO getById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
        return studentMapper.toDTO(student);
    }

    public StudentResponseDTO deleteById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
        studentRepository.delete(student);
        return studentMapper.toDTO(student);
    }
}
