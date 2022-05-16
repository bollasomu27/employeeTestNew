package com.leads.controller;

import com.leads.dto.EmployeeDetails;
import com.leads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all-employees")
    public List<EmployeeDetails> getAllEmployees() {
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/all-employees/{projectCode}")
    public List<EmployeeDetails> getAllEmployees(@PathVariable String projectCode) {
        return employeeService.getAllEmployeeDetailsByProjectCode(projectCode);
    }

    @DeleteMapping("/dissociateEmployee/{employeeCode}/projectCode/{projectCode}")
    public ResponseEntity dissociateEmployeeFromProject(@PathVariable String employeeCode,
                                                        @PathVariable String projectCode) {
        return employeeService.dissociateAnEmployeeFromProject(employeeCode, projectCode);
    }
}

