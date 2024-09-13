package com.example.lab3_20206466.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private String jobId;

    @Column(name="job_title", nullable=false)
    private String jobTitle;

    //realcion con 1:N con employees
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
