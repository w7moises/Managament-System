package com.management.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
}