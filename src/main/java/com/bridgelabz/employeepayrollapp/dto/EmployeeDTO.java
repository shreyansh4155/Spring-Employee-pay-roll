package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class EmployeeDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Gender must be either 'male' or 'female'")
    private String gender;

    @NotNull(message = "Department list cannot be null")
    private List<String> department;

    @NotNull(message = "Salary cannot be null")
    private Long salary;

    @NotNull(message = "Start Date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")    @PastOrPresent(message = "Start Date must be past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note should not be blank")
    private String note;

    @NotBlank(message = "You need to provide a profile picture")
    private String profilePic;
}