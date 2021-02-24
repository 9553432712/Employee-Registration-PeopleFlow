package com.mahesh.employeeregistration.controller;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRegistrationController {

  @Autowired
  EmployeeService employeeService;

  @PostMapping("/add")
  public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    System.out.printf(employeeDto.toString());
    return employeeService.addEmployee(employeeDto);
  }

  @PostMapping("/state")
  public EmployeeDto employeeStateChange(@RequestParam String email, @RequestParam String state) {
    return employeeService.updateState(email, state);
  }


}
