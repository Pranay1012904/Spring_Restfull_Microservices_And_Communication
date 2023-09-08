package com.spring.MicroServices.departmentService.repository;

import com.spring.MicroServices.departmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findDepartmentBydepartmentCode(String departmentCode);
}
