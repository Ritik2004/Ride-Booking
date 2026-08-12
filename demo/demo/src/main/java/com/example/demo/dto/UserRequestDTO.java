package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message="Email is Required")
    @Email(message="Invalid Email")
    private String email;

    @NotNull(message="Age is required")
    @Min(value = 18,message="AGE MUST BE ATLEAST 18")
    private int age;
}
