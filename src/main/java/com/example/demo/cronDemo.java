package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Component // this is the smallest thing that would be needed to run
public class cronDemo {
//	@Value("${cronExpression}") 	
//	private String cronExpression;
	@Value("${cronExpression}")
	private String cronExp;
	// Fetching the value of expression from the database (Dynamic way)
	@Scheduled(cron="${cronExpression:-}") // Getting the value of expression from application.properties file (Dynamic method)
	public void runTestng() {
		TestngXMLusingCode tmuc = new TestngXMLusingCode();
		tmuc.testNgSuite("com.example.demo.SeleniumExapmle");
		System.out.println("Test1Executed Successfully through cron expression by application.properties");
		
		System.out.println(cronExp +" -> through Application.Properties");
	}
	
	@Autowired
	private ApplicationContext context;
	@Scheduled(cron="*/10 * * * * *") // Static way to provide the cron expression   
	public void runTestng1() {
		System.out.println("Test2Executed Successfully through static method");
		System.out.println(context.getBean("getCronExpressionList"));
		
	}
	
//	@Value("#{@getCronExpressionFromDb}")
//	private String crExp;
//	@Scheduled(cron="#{@getCronExpressionFromDb}") 
//	  public void scheduleTasksCronFromDatabaseExpression() {
////	     logger.info("scheduleTasksCronFromDatabaseExpression executed at {}", LocalDateTime.now());
////		System.out.println(crExp + " cron Expression"); 
//		TestngXMLusingCode tmuc = new TestngXMLusingCode();
//		tmuc.testNgSuite("com.example.demo.SeleniumExapmle");
//		System.out.println("Test1Executed Successfully by fetching the value of cron from database");
//	  }
	
	@Value("#{@getCronExpressionList.get(\"Task3\")}")
	private String crExp;
	@Scheduled(cron="#{@getCronExpressionList.get(\"Task3\")}") 
	  public void scheduleTasksCronFromDatabaseExpression1() {
//	     logger.info("scheduleTasksCronFromDatabaseExpression executed at {}", LocalDateTime.now());
		System.out.println(crExp + " cron Expression fetched from DB"); 
		TestngXMLusingCode tmuc = new TestngXMLusingCode();
		tmuc.testNgSuite("com.example.demo.SeleniumExapmle");
//		System.out.println("Test1Executed Successfully by fetching the value of cron from database");
	  }
	
	
	  
}
