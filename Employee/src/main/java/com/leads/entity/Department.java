package com.leads.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@Getter
public class Department {

    @Id
    @Column(
            name = "ID",
            unique = true,
            nullable = false
    )
    @GeneratedValue
    private Integer id;

    @Column(name = "DEPART_CODE")
    private String departmentCode;
}
