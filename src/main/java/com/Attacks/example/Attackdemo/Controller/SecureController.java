package com.Attacks.example.Attackdemo.Controller;

import com.Attacks.example.Attackdemo.Model.Employee;
import com.Attacks.example.Attackdemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecureController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // This endpoint prevents SQL injection by using streams and the query used for sql injection is treated as a string so no records are retrieved
    @GetMapping("/secure-sql")
    public List<Employee> secureSql(@RequestParam String name) {
        return employeeRepository.findAll()
                .stream()
                .filter(Employee -> Employee.getEmployeeName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // The below is used by JPA which reduces the usage of JDBC prepared statement instead defining a method in repository interface
    @GetMapping("/secure-jpa")
    public List<Employee> secureJpa(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }

    // This endpoint is used to prevent from XSS attack
    @GetMapping("/secure-xss")
    public String secureXss(@RequestParam String input) {
        String sanitizedInput = input.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        return "<html><body>Hello " + sanitizedInput + "</body></html>";
    }
}
