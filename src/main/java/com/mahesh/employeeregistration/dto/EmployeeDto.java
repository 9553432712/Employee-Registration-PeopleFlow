package com.mahesh.employeeregistration.dto;

import com.mahesh.employeeregistration.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

  @NotNull(
      message = "The employeeName not null and '${validatedValue}' must be between {min} and {max} characters long")
  @Size(max = 50, min = 3,
      message = "The employeeName not null and '${validatedValue}' must be between {min} and {max} characters long")
  String employeeName;

  @NotNull(message = "The phoneNumber not null and '${validatedValue}' must be between {min} and {max} characters long")
  @Size(min = 6, max = 12,
      message = "The employeeName not null and '${validatedValue}' must be between {min} and {max} characters long")
  String phoneNumber;

  @Email
  @NotNull(message = "The email not null and '${validatedValue}' must be between {min} and {max} characters long")
  String email;

  @NotNull(message = "The age not null and '${validatedValue}' must be between {min} and {max} characters long")
  @Min(value = 18, message = "Age should not be less than 18")
  int age;

  @NotNull
  String country;

  public EmployeeEntity toEntity() {
    EmployeeEntity entity = new EmployeeEntity(employeeName, phoneNumber, email, age, country, State.ADDED);
    return entity;
  }
}
