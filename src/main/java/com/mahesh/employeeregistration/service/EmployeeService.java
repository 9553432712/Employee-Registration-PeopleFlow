package com.mahesh.employeeregistration.service;

import com.mahesh.employeeregistration.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto addEmployee(EmployeeDto employeeDto);

  EmployeeDto updateState(String email, String state);
}
