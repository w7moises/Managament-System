package com.management.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "password is required")
    private String password;
}
