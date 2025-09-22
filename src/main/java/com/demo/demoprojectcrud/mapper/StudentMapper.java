package com.demo.demoprojectcrud.mapper;

import com.demo.demoprojectcrud.entity.Student;
import com.demo.demoprojectcrud.model.StudentResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentResponseDTO toDTO(Student student, ModelMapper modelMapper) {
        return modelMapper.map(student, StudentResponseDTO.class);
    }
}
