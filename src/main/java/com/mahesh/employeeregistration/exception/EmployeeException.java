package com.mahesh.employeeregistration.exception;

import lombok.Data;

@Data
public class EmployeeException extends RuntimeException {
  private String message;
  private String details;
  private String hint;

  protected EmployeeException() {
  }

  public EmployeeException(String message, String details, String hint) {
    this.message = message;
    this.details = details;
    this.hint = hint;
  }
}