package com.leads.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDetails {

    private String empCode;
    private String name;
    private String city;
    private String departmentCode;
    private String projectCode;
}
