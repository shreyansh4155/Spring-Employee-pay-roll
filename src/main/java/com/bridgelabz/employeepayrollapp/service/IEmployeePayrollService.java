package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(EmployeeDTO employeeDTO);
    Employee updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
}