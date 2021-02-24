package com.mahesh.employeeregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
  private String message;
  private String details;
  private String hint;
}
