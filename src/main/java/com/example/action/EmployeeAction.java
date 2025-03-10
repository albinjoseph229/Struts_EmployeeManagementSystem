package com.example.action;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import java.util.List;
import java.util.regex.Pattern;

public class EmployeeAction extends ActionSupport implements Preparable {

    private Employee employee;
    private List<Employee> employees;
    private Long employeeId;
    private EmployeeService employeeService = new EmployeeServiceImpl();

    // Pattern for email validation
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void prepare() throws Exception {
        if (employeeId != null) {
            employee = employeeService.getEmployeeById(employeeId);
        }
    }

    // Method to validate the form
    @Override
    public void validate() {
        if (employee != null) {
            // Validate name
            if (employee.getName() == null || employee.getName().trim().isEmpty()) {
                addFieldError("employee.name", "Name is required");
            }

            // Validate email
            if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
                addFieldError("employee.email", "Email is required");
            } else if (!Pattern.matches(EMAIL_PATTERN, employee.getEmail())) {
                addFieldError("employee.email", "Invalid email format");
            } else if (!employeeService.isEmailUnique(employee.getEmail(), employee.getId())) {
                addFieldError("employee.email", "Email already exists");
            }

            // Validate salary
            if (employee.getSalary() == null) {
                addFieldError("employee.salary", "Salary is required");
            } else if (employee.getSalary() <= 0) {
                addFieldError("employee.salary", "Salary must be greater than zero");
            }
        }
    }

    // Action method to display the form for adding a new employee
    public String addForm() {
        this.employee = new Employee();
        return SUCCESS;
    }

    // Action method to add a new employee
    public String add() {
        try {
            employeeService.addEmployee(employee);
            addActionMessage("Employee added successfully");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Failed to add employee: " + e.getMessage());
            return INPUT;
        }
    }

    // Action method to display all employees
    public String list() {
        try {
            employees = employeeService.getAllEmployees();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Failed to fetch employees: " + e.getMessage());
            return ERROR;
        }
    }

    // Action method to display the form for editing an employee
    public String editForm() {
        return SUCCESS;
    }

    // Action method to update an employee
    public String update() {
        try {
            employeeService.updateEmployee(employee);
            addActionMessage("Employee updated successfully");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Failed to update employee: " + e.getMessage());
            return INPUT;
        }
    }

    // Action method to delete an employee
    public String delete() {
        try {
            employeeService.deleteEmployee(employeeId);
            addActionMessage("Employee deleted successfully");
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Failed to delete employee: " + e.getMessage());
            return ERROR;
        }
    }

    // Getters and Setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}