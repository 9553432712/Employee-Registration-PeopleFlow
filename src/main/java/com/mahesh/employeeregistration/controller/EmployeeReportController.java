package com.mahesh.employeeregistration.controller;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeReportController {
  @Autowired
  ReportService reportService;

  @GetMapping("/report/country")
  public Map<String, EmployeeDto> countryWiseEmployeeReport() {
    return reportService.countryWiseEmployee();
  }
}
