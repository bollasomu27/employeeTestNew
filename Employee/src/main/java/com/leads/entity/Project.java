package com.leads.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
@NoArgsConstructor
@Getter
public class Project{

    @Id
    @Column(
            name = "Id",
            unique = true,
            nullable = false
    )
    @GeneratedValue
    private Integer id;

    @Column(name = "PROJECT_CODE")
    private String projectCode;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartId")
    private Department DEPART_ID;
}
