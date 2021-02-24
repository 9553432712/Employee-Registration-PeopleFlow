package com.mahesh.employeeregistration.util;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.entity.EmployeeEntity;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {


  public static String standardEmployeeJson() {
    // CHECKSTYLE:OFF
    return "{\n" +
        "    \"employeeName\": \"employeeName\",\n" +
        "    \"phoneNumber\": \"dsdsds\",\n" +
        "    \"age\": 20,\n" +
        "    \"country\": \"INDIA\",\n" +
        "    \"email\": \"mahesh@gmail.com\"\n" +
        "}";
  }


  public static EmployeeEntity mockEmployeeEntity() {
    return new EmployeeEntity("employeeName", "phoneNumber", "email", 25, "INDIA", State.ADDED);
  }

  public static EmployeeDto mockEmployeeDto() {
    return new EmployeeDto("employeeName", "phoneNumber", "email", 25, "INDIA");
  }

  public static Map<String, EmployeeDto> mockCountryWiseEmployeeDto() {
    Map<String, EmployeeDto> result = new HashMap<>();
    result.put("email", new EmployeeDto("employeeName", "phoneNumber", "email", 25, "INDIA"));
    return result;
  }
}
