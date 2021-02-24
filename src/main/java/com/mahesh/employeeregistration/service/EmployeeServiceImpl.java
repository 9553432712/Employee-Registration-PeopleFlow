package com.mahesh.employeeregistration.service;

import com.mahesh.employeeregistration.dao.EmployeeDao;
import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.entity.EmployeeEntity;
import com.mahesh.employeeregistration.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeDao employeeDao;

  @Override
  public EmployeeDto addEmployee(EmployeeDto employeeDto) {
    EmployeeEntity result = employeeDao.insertORUpdateEmployee(employeeDto.toEntity());
    return result.toDto();
  }

  @Override
  public EmployeeDto updateState(String email, String state) {
    EmployeeEntity result = new EmployeeEntity();
    try {
      State s = State.valueOf(state);
      result = employeeDao.updateState(email, s);
    } catch (IllegalArgumentException l) {
      throw new EmployeeException("Invalid Data", String.format("%s is invalid state", state),
          String.format("please change the state %s", State.toCommaString()));
    }
    return result.toDto();
  }
}
