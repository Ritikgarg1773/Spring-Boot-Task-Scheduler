package com.example.demo;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.TestngXMLusingCode;

@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId(1);
		emp.setSalary(3000);
//localhost:8080/employee
		return emp;
//		TestngXMLusingCode tmuc = new TestngXMLusingCode();
//		tmuc.testNgSuite("com.testng.code.SampleProgram1");
	}


	@RequestMapping(value = "/runTestNG", method = RequestMethod.GET)
	public void runTestng() {
		TestngXMLusingCode tmuc = new TestngXMLusingCode();
		tmuc.testNgSuite("com.example.demo.SeleniumExapmle");
		System.out.println("TestExecuted Successfully");
	}
	
	@GetMapping("/sendmail")
	@ResponseBody
	public String home() {
	    try {
	        masterServiceImpl.sendEmail("C:\\Users\\Ritik garg\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\SpringBoot_TestNG\\target\\surefire-reports\\emailable-report.html");
	        return "Email Sent!";
	    } catch (Exception ex) {
	        return "Error in sending email: " + ex;
	    }
	}

	@Autowired
	FetchDataService fetchdata;
	
	
	@GetMapping(path="getdata")
	List<Employee> getUsers(){
//		fetchdata.
		return fetchdata.findAll();
	}
	
//	@GetMapping(path="getsalary")
//	public Employee getCronValue()
//	{
//		System.out.println(fetchdata.getOne(1).getSalary());
//	    return fetchdata.getOne(1);
//	}
	
	@GetMapping(path="userid/{id}")
	int getOneUser(@PathVariable int id){
		int sal = fetchdata.findById(id).get().getSalary(); // working fine
		return sal;
	}
}