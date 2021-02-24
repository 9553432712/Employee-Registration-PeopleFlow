package com.mahesh.employeeregistration.dao;

import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {
  EmployeeEntity insertORUpdateEmployee(EmployeeEntity toEntity);

  EmployeeEntity updateState(String email, State state);

  List<EmployeeEntity> getAllEmployeeData();
}
