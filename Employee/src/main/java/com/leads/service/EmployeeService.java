package com.leads.service;

import com.leads.dto.EmployeeDetails;
import com.leads.entity.Employee;
import com.leads.entity.Project;
import com.leads.repository.EmployeeRepository;
import com.leads.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<EmployeeDetails> getAllEmployeeDetails() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(employee -> getEmployeeDetails(employee))
                .collect(Collectors.toList());
    }

    public List<EmployeeDetails> getAllEmployeeDetailsByProjectCode(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        if (Objects.isNull(project)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Project present for the given project code"
            );
        }
        List<Employee> employees = employeeRepository.findAllByProjectId(project.getId());
        if (Objects.isNull(employees) || employees.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Employee found for the given project code"
            );
        }
        return employees
                .stream()
                .map(employee -> getEmployeeDetails(employee))
                .collect(Collectors.toList());
    }

    public ResponseEntity dissociateAnEmployeeFromProject(String empCode, String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        if (Objects.isNull(project)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Project present for the given project code"
            );
        }
        int resultCount = employeeRepository.deleteEmployeeByEmpCodeAndProjectCode(empCode, project.getId());
        if (resultCount < 1) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No employee found for the given employee code"
            );
        }
        return ResponseEntity.ok().body("Successfully dissociate employee : " + empCode + " from a project : " + projectCode);
    }

    private static EmployeeDetails getEmployeeDetails(Employee employee) {
        return EmployeeDetails.builder()
                .empCode(employee.getEmpCode())
                .name(employee.getName())
                .city(employee.getCity())
                .departmentCode(employee.getDepartment().getDepartmentCode())
                .projectCode(employee.getProject().getProjectCode())
                .build();
    }
}
