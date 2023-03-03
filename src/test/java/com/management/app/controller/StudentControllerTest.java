package com.management.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.app.dto.StudentDto;
import com.management.app.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;
    private StudentDto student;

    @BeforeEach
    void init(){
        student = new StudentDto(1l,
                "Walter",
                "White",
                "w7molina@gmail.com");
    }

    @Test
    @DisplayName("Test for the creation of student")
    void createStudent() throws Exception {

        given(studentService.createStudent(ArgumentMatchers.any(StudentDto.class))).willAnswer(invocation -> invocation.getArgument(0));

        this.mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Walter")))
                .andExpect(jsonPath("$.lastName", is("White")))
                .andExpect(jsonPath("$.email", is("w7molina@gmail.com")));

    }

    @Test
    @DisplayName("Test for fetch all students")
    @WithMockUser(roles = {"ADMIN"})
    void shouldFetchAllStudents() throws Exception {
        given(studentService.getAllStudents()).willReturn(List.of(student));

        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)));
    }

    @Test
    @DisplayName("Test for fetch a student by Id")
    @WithMockUser(roles = {"USER"})
    void shouldFetchOneStudentById() throws Exception {
        final Long studentId = 1L;

        given(studentService.getStudentById(studentId)).willReturn(student);

        this.mockMvc.perform(get("/students/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Walter")))
                .andExpect(jsonPath("$.lastName", is("White")))
                .andExpect(jsonPath("$.email", is("w7molina@gmail.com")));
    }

    @Test
    @DisplayName("Test for the update of the student")
    void shouldUpdateStudent() throws Exception {
        final Long studentId = 1L;

        given(studentService.getStudentById(studentId)).willReturn(student);
        given(studentService.updateStudent(ArgumentMatchers.any(StudentDto.class),ArgumentMatchers.eq(student.getId())))
                .willAnswer((invocation) -> invocation.getArgument(0));

        this.mockMvc.perform(put("/students/{id}", student.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(student.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(student.getLastName())))
                .andExpect(jsonPath("$.email", is(student.getEmail())));

    }

    @Test
    @DisplayName("Test to delete student by id")
    void shouldDeleteStudent() throws Exception {
        Long studentId = 1L;
        given(studentService.getStudentById(studentId)).willReturn(student);
        doNothing().when(studentService).deleteStudent(studentId);

        this.mockMvc.perform(delete("/students/{id}", student.getId()))
                .andExpect(status().isOk());

    }
}
