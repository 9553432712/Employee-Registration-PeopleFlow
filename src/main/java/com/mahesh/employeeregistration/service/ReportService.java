package com.mahesh.employeeregistration.service;

import com.mahesh.employeeregistration.dto.EmployeeDto;

import java.util.Map;

public interface ReportService {
  Map<String, EmployeeDto> countryWiseEmployee();
}
