package com.mahesh.employeeregistration.repository;

import com.mahesh.employeeregistration.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  EmployeeEntity findByEmail(String email);
}
