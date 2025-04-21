package com.Attacks.example.Attackdemo.Controller;

import com.Attacks.example.Attackdemo.Model.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttackController
{

        @Autowired
        private EntityManager entityManager;


        // We do have a native query and once it is executed the rows that are returned will be mapped to Employee object.
        // The execution is taken care by EntityManager(interface provided by JPA)
        @GetMapping("/vulnerable-sql")
        public List<Employee> vulnerableSql(@RequestParam String name) {
            String query = "SELECT * FROM emptab WHERE employee_name = '" + name + "'";
            return entityManager.createNativeQuery(query, Employee.class).getResultList();
        }
        // Test the above endpoint using http://localhost:8080/vulnerable-sql?name=' OR '1'='1
        // Here the 'name or '1'='1 is treated as query which always returns true so it lists all the rows.


        // this performs XSS attack use http://localhost:8080/vulnerable-sql?input =<script>alert('XSS attack')</script>
        @GetMapping("/vulnerable-xss")
        public String vulnerableXss(@RequestParam String input) {
            return "<html><body>Hello " + input + "</body></html>";
        }
}
