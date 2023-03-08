package com.management.app.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.management.app.entity.Auditable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "firstName", "lastName", "email"})
public class StudentDto extends Auditable<String> {
    private Long id;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
}