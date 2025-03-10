package com.example.service;

import com.example.model.Employee;
import java.util.List;

public interface EmployeeService {
    Long addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    boolean isEmailUnique(String email, Long id);
}