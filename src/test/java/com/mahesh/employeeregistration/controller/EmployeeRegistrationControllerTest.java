package com.mahesh.employeeregistration.controller;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.service.EmployeeService;
import com.mahesh.employeeregistration.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class EmployeeRegistrationControllerTest {
  private static final String CREATE_URI = "/employee/add/";
  private static final String STATE_URI = "/employee/state?email=mahesh@gmail.com&state=";

  MockMvc mockMvc;
  @Mock
  EmployeeService employeeService;
  @InjectMocks
  EmployeeRegistrationController employeeRegistrationController;


  //  @BeforeEach
//  void setUp() {
//    MockitoAnnotations.initMocks(this);
//  }
  @BeforeEach
  public void setUpMocks() {
    mockMvc =
        standaloneSetup(employeeRegistrationController).setMessageConverters(new MappingJackson2HttpMessageConverter())
            .build();
  }

  @Test
  void testAdd() throws Exception {
    when(employeeService.addEmployee(any(EmployeeDto.class)))
        .thenReturn(TestUtil.mockEmployeeDto());

    mockMvc.perform(post(CREATE_URI).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
        .content(TestUtil.standardEmployeeJson())).andDo(print()).andExpect(status().isOk());
  }

  @Test
  void testStateChange() throws Exception {
    when(employeeService.updateState(anyString(), anyString()))
        .thenReturn(TestUtil.mockEmployeeDto());

    mockMvc.perform(post(STATE_URI + State.APPROVED.toString()).accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(TestUtil.standardEmployeeJson())).andDo(print()).andExpect(status().isOk());
  }
}