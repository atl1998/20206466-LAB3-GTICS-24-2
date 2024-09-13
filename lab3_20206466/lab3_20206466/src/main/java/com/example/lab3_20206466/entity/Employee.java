package com.example.lab3_20206466.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id", nullable=false)
    private Integer employeeId;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="phone_number", nullable=false)
    private String phone_number;

    @Column(name="salary", nullable=false)
    private float salary;


    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    //relación con la tabla jobs
    @ManyToOne
    @JoinColumn(name="job_id", nullable=false)
    private Job job;

}

