package com.leads.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@Getter
public class Employee{

    @Id
    @Column(
            name = "ID",
            unique = true,
            nullable = false
    )
    @GeneratedValue
    private Integer id;

    @Column (name = "EMP_CODE")
    private String empCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;


}
