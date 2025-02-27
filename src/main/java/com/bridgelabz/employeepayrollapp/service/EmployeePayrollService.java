package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<Employee> employeeList = new ArrayList<>();
    private int counter = 1;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(counter++, employeeDTO);
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = this.getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }
}