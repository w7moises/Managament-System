package com.management.app.service;

import com.management.app.dto.StudentDto;
import com.management.app.entity.Student;
import com.management.app.repository.StudentRepository;
import com.management.app.service.impl.StudentServiceImpl;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private static final Long ID = 1L;
    private static final String FIRST_NAME = "Walter";
    private static final String LAST_NAME = "White";
    private static final String EMAIL = "w7moises@gmail.com";

    public static Student student = new Student();
    public static StudentDto studentDto = new StudentDto();

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

        student.setId(ID);
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);
        student.setEmail(EMAIL);

        studentDto.setId(ID);
        studentDto.setFirstName(FIRST_NAME);
        studentDto.setLastName(LAST_NAME);
        studentDto.setEmail(EMAIL);
    }

    @DisplayName("Test for the creation of the student")
    @Test
    public void createStudentTest(){

        //given
        given(studentRepository.findByEmail(student.getEmail()))
                .willReturn(Optional.empty());
        given(studentRepository.save(student)).willReturn(student);

        //when
        when(studentServiceImpl.createStudent(studentDto)).thenReturn(studentDto);
        StudentDto studentSave = studentServiceImpl.createStudent(studentDto);

        //then
        assertThat(studentSave).isNotNull();
    }

    @DisplayName("Test to list all the students")
    @Test
    public void findAllStudent(){
        //given
        given(studentRepository.findAll()).willReturn(List.of(student));

        //when
        final List<StudentDto> students = studentServiceImpl.getAllStudents();

        //then
        assertThat(students).isNotNull();
        assertThat(students.size()).isGreaterThan(0);
    }

    @DisplayName("Test case for a student list empty")
    @Test
    public void emptyFindAllStudent(){
        //given
        given(studentRepository.findAll()).willReturn(Collections.emptyList());

        //when
        final List<StudentDto> students = studentServiceImpl.getAllStudents();

        //then
        assertThat(students).isEmpty();
        assertThat(students.size()).isEqualTo(0);
    }

    @DisplayName("Test to search student by id")
    @Test
    public void findStudentById(){
        //given
        given(studentRepository.findById(1L)).willReturn(Optional.of(student));

        //when
        when(studentServiceImpl.getStudentById(1L)).thenReturn(studentDto);
        StudentDto studentSave = studentServiceImpl.getStudentById(1L);

        //then
        assertThat(studentSave).isNotNull();
    }

    @DisplayName("Test for the update of the student")
    @Test
    void updateStudent(){
        //given
        given(studentRepository.findById(1L)).willReturn(Optional.of(student));
        given(studentRepository.save(student)).willReturn(student);
        studentDto.setEmail("w77molina@gmail.com");
        studentDto.setFirstName("Javier");

        //when
        when(studentServiceImpl.updateStudent(studentDto, 1L)).thenReturn(studentDto);
        StudentDto studentSave = studentServiceImpl.updateStudent(studentDto, 1L);

        //then
        assertThat(studentSave.getEmail()).isEqualTo("w77molina@gmail.com");
        assertThat(studentSave.getFirstName()).isEqualTo("Javier");
    }

    @DisplayName("Test to delete student by id")
    @Test
    void testEliminarEmpleado(){
        //given
        long empleadoId = 1L;
        given(studentRepository.findById(empleadoId)).willReturn(Optional.of(student));

        willDoNothing().given(studentRepository).deleteById(empleadoId);

        //when
        when(studentServiceImpl.getStudentById(1L)).thenReturn(studentDto);
        studentServiceImpl.deleteStudent(empleadoId);

        //then
        verify(studentRepository,times(1)).deleteById(empleadoId);
    }

}
