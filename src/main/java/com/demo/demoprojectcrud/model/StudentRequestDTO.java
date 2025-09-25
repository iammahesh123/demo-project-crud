package com.demo.demoprojectcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private String studentAddress;
    private String studentCourse;
    private String studentRollNumber;
    private int studentAge;

}
