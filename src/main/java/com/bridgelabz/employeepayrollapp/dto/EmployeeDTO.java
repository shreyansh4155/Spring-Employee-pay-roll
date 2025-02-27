package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 3000, message = "Salary should be at least 3000")
    private double salary;
}