package com.example.lab3_20206466.repository;
import com.example.lab3_20206466.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByFirstName(String nombre);

}