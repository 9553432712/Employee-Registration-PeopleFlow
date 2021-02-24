package com.mahesh.employeeregistration.exception;

import com.mahesh.employeeregistration.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EmployeeException.class)
  public final ResponseEntity<Object> handleAllExceptions(EmployeeException ex) {
    ErrorMessage exceptionResponse =
        new ErrorMessage(ex.getMessage(), ex.getDetails(), ex.getHint());
    return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
    ErrorMessage exceptionResponse =
        new ErrorMessage(ex.getMessage(), ex.getLocalizedMessage(), "");
    return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}