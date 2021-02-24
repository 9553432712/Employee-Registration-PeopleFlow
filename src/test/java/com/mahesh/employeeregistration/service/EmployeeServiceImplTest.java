package com.mahesh.employeeregistration.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.mahesh.employeeregistration.dao.EmployeeDao;
import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.entity.EmployeeEntity;
import com.mahesh.employeeregistration.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EmployeeServiceImplTest {
  @Mock
  EmployeeDao employeeDao;
  @InjectMocks
  EmployeeServiceImpl employeeServiceImpl;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testAddEmployee_withValidData_thenCheck() {
    Mockito.when(employeeDao.insertORUpdateEmployee(any(EmployeeEntity.class)))
        .thenReturn(TestUtil.mockEmployeeEntity());
    EmployeeDto employeeDto = TestUtil.mockEmployeeDto();
    EmployeeDto result = employeeServiceImpl.addEmployee(employeeDto);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(employeeDto.getEmployeeName(), result.getEmployeeName());
    Assertions.assertEquals(employeeDto.getAge(), result.getAge());
    Assertions.assertEquals(employeeDto.getPhoneNumber(), result.getPhoneNumber());
    Assertions.assertEquals(employeeDto.getCountry(), result.getCountry());
  }

  @Test
  void testUpdateState() {
    when(employeeDao.updateState(anyString(), any()))
        .thenReturn(TestUtil.mockEmployeeEntity());

    EmployeeDto result = employeeServiceImpl.updateState("email", State.APPROVED.toString());
    Assertions.assertEquals(TestUtil.mockEmployeeDto(), result);
  }
}