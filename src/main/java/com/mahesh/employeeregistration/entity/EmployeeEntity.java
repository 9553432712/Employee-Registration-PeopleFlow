package com.mahesh.employeeregistration.entity;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

  String employeeName;
  String phoneNumber;
  @Id
  String email;
  int age;
  String country;
  State state;

  public static List<EmployeeDto> getEmployeeList(List<EmployeeEntity> employeeData) {
    List<EmployeeDto> result = employeeData.stream().map(e -> e.toDto()).collect(Collectors.toList());
    return result;
  }

  public EmployeeDto toDto() {
    EmployeeDto employeeDto = new EmployeeDto(employeeName, phoneNumber, email, age, country);
    return employeeDto;
  }
}
