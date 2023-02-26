package com.management.app.service;

import com.management.app.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto user);

    StudentDto getStudentById(Long userId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(StudentDto user, Long userId);

    void deleteStudent(Long userId);
}
