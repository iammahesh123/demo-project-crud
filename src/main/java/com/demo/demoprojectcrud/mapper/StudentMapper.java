package com.demo.demoprojectcrud.mapper;

import com.demo.demoprojectcrud.entity.Student;
import com.demo.demoprojectcrud.model.StudentResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentResponseDTO toDTO(Student student) {
        return modelMapper.map(student, StudentResponseDTO.class);
    }
}
