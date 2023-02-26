package com.management.app.service;

import com.management.app.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createUser(StudentDto user);

    StudentDto getUserById(Long userId);

    List<StudentDto> getAllUsers();

    StudentDto updateUser(StudentDto user, Long userId);

    void deleteUser(Long userId);
}
