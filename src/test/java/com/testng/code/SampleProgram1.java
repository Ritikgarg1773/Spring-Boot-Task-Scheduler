package com.testng.code;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.demo.SpringBootTestNgApplication;

@SpringBootTest(classes = SpringBootTestNgApplication.class)
public class SampleProgram1 extends AbstractTestNGSpringContextTests{
	@Autowired
	private WebApplicationContext WebApplicationContext;
	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(WebApplicationContext).build();
	}
	@Test
	public void Test1() throws Exception {
		System.out.println("Inside Test1");
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
////		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"));
//		.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));

		System.out.println("Test1 passed");
	}
	
	@Test
	public void Test2() throws Exception {
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
		.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));
		System.out.println("Test2 passed");
	}
	
}
