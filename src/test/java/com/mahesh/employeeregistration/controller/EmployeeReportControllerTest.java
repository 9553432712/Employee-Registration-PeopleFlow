package com.mahesh.employeeregistration.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.mahesh.employeeregistration.dto.EmployeeDto;
import com.mahesh.employeeregistration.dto.State;
import com.mahesh.employeeregistration.service.EmployeeService;
import com.mahesh.employeeregistration.service.ReportService;
import com.mahesh.employeeregistration.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
class EmployeeReportControllerTest {
  private static final String REPORT_URI = "/employee/report/country";

  MockMvc mockMvc;
  @Mock
  ReportService reportService;
  @InjectMocks
  EmployeeReportController employeeReportController;


  @BeforeEach
  public void setUpMocks() {
    mockMvc =
        standaloneSetup(employeeReportController).setMessageConverters(new MappingJackson2HttpMessageConverter())
            .build();
  }

  @Test
  void testCountryWiseEmployeeReport() throws Exception {
    when(reportService.countryWiseEmployee())
        .thenReturn(TestUtil.mockCountryWiseEmployeeDto());

    mockMvc.perform(get(REPORT_URI).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print()).andExpect(status().isOk());
  }
}