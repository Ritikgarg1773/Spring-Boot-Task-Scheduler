
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Configuration
@ConditionalOnProperty(name="scheduling.enabled",matchIfMissing = true)
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
	
//	@Scheduled(cron="* * * * * *") // Runs every second of hour of the day of the week (Use cron tab guru for better understanding) 
//	public void runTestng() {
//		TestngXMLusingCode tmuc = new TestngXMLusingCode();
//		tmuc.testNgSuite("com.example.demo.SeleniumExapmle");
//		System.out.println("TestExecuted Successfully");
//	}
}