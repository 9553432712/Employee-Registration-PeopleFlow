package com.mahesh.employeeregistration.service;

import com.mahesh.employeeregistration.dao.EmployeeDao;
import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
  @Autowired
  EmployeeDao employeeDao;

  @Override
  public Map<String, EmployeeDto> countryWiseEmployee() {
    List<EmployeeEntity> employeeData = employeeDao.getAllEmployeeData();
    List<EmployeeDto> employeeDtoData = EmployeeEntity.getEmployeeList(employeeData);
    Map<String, EmployeeDto>
        countryWiseEmployeeMap = employeeDtoData.stream().collect(Collectors.toMap(EmployeeDto::getEmail, e -> e));
    return countryWiseEmployeeMap;
  }
}
