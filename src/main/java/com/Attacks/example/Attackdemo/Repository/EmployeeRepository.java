package com.Attacks.example.Attackdemo.Repository;

import com.Attacks.example.Attackdemo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.employeeName = :name")
    List<Employee> findByName(@Param("name") String name);
    // this is other way to prevent sql injection which uses JPQL. This query uses the name of the table used in model class
}
