package com.mahesh.employeeregistration.dao;

import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.entity.EmployeeEntity;
import com.mahesh.employeeregistration.exception.EmployeeException;
import com.mahesh.employeeregistration.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public EmployeeEntity insertORUpdateEmployee(EmployeeEntity toEntity) {
    if (checkEmployeeExists(toEntity.getEmail())) {
      throw new EmployeeException("Invalid Data", String.format("%s is already exist", toEntity.getEmail()),
          "please change the email");
    }
    return employeeRepository.save(toEntity);
  }

  @Override
  public EmployeeEntity updateState(String email, State state) {
    EmployeeEntity employeeEntity = employeeRepository.findByEmail(email);
    if (employeeEntity != null) {
      employeeEntity.setState(state);
    } else {
      throw new EmployeeException("Invalid Data", String.format("%s is not exist", email), "please change the email");
    }
    return employeeRepository.save(employeeEntity);
  }

  @Override
  public List<EmployeeEntity> getAllEmployeeData() {
    return employeeRepository.findAll();
  }

  private boolean checkEmployeeExists(String email) {
    EmployeeEntity employeeEntity = employeeRepository.findByEmail(email);
    return employeeEntity != null;
  }
}
