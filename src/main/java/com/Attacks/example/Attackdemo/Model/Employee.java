package com.Attacks.example.Attackdemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="emptab")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeContactNumber;
    private String employeeGender;
    private String employeeDepartment;


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                '}';
    }

    public Employee(String employeeName, String employeeContactNumber,
                    String employeeGender, String employeeDepartment) {

        this.employeeName = employeeName;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeGender = employeeGender;
        this.employeeDepartment = employeeDepartment;

    }


    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}



