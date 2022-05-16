package com.leads.repository;

import com.leads.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByProjectId(Integer projectId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Employee em WHERE em.EMP_CODE=?1 and em.PROJECT_ID=?2",
            nativeQuery = true)
    int deleteEmployeeByEmpCodeAndProjectCode(String empCode,
                                               Integer projectId);

}
