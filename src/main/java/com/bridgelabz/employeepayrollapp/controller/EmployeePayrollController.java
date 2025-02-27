package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // Get All Employees
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeePayrollService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Get Employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeePayrollService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create New Employee
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = employeePayrollService.createEmployee(employeeDTO);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // Update Employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeePayrollService.updateEmployee(id, employeeDTO);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeePayrollService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
    }
}