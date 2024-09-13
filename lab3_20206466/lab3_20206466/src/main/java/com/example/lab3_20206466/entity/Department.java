package com.example.lab3_20206466.entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer departmentId;

    @Column(name="department_name", nullable=false)
    private String departmentName;

    // se debe mecionar la relacion 1:N con employeees
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
    /*
    // Relación con la tabla de locations
    @ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;*/


}
