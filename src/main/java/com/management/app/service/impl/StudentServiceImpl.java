package com.management.app.service.impl;

import com.management.app.dto.StudentDto;
import com.management.app.entity.Student;
import com.management.app.exception.EmailExistsException;
import com.management.app.exception.ResourceNotFoundException;
import com.management.app.repository.StudentRepository;
import com.management.app.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Optional<Student> optionalUser = studentRepository.findByEmail(studentDto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailExistsException("Email Already Exists for User");
        }
        Student student = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long userId) {
        Student optionalStudent = studentRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        return modelMapper.map(optionalStudent, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student ->modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto user, Long userId) {
        Student existingStudent = studentRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        existingStudent.setFirstName(user.getFirstName());
        existingStudent.setLastName(user.getLastName());
        existingStudent.setEmail(user.getEmail());
        return modelMapper.map(studentRepository.save(existingStudent), StudentDto.class);
    }

    @Override
    public void deleteStudent(Long userId) {
        Student optionalStudent = studentRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        studentRepository.deleteById(optionalStudent.getId());
    }
}
