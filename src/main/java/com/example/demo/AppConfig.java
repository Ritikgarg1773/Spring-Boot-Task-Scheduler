/* Source: https://technicalsand.com/spring-task-scheduler-examples/#:~:text=Spring%20scheduler%20load%20cron%20expression%20from%20database,-Spring%20tasks%20scheduling&text=Lets%20create%20a%20domain%20entity,you%20can%20use%20any%20name).&text=Now%20lets%20create%20its%20repository,method%20to%20find%20by%20name.*/

package com.example.demo;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
	//This is just the backend part, We will implement the GUI part in Spring MVC
	@Bean(name = "javaMailSender")
	public JavaMailSender jmsi() {
		JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
		jmsi.setHost("smtp.gmail.com");
		jmsi.setPort(587);
		jmsi.setUsername("ritikgarg.1773@gmail.com");
		jmsi.setPassword("eduwvekyjhpserqx");
		jmsi.setJavaMailProperties(prop());
		return jmsi;
	}
	@Bean
	public Properties prop() {
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		return p;
	}
	
	@Autowired
	  private ConfigurationRepository configurationRepository;
	@Bean
	  public String getCronExpressionFromDb() {
	     // read here from database and return
	     Configuration configuration = configurationRepository.findByName("scheduleTaskcronxpression");
	     System.out.println(configuration.getExpression());
	     return configuration.getExpression();
	  }
	
	@Bean
	@Scheduled(cron = "*/5 * * * * *")
//	@RefreshScope
	public Map<String,String> getCronExpressionList(){
//		 =  new ArrayList<>();
		Map<String,String> cronExpMap = new HashMap<>();
		List<Configuration> list = configurationRepository.findAll();
		for (Configuration c : list) {
			cronExpMap.put(c.getName(),c.getExpression());
		}
		System.out.println(cronExpMap);
		return cronExpMap;
		
	}
	
//	@Autowired
//	private FetchDataService cronRepo;
//
//	@Bean
//	public Integer getSal(){
//	    System.out.println(cronRepo.findBysalId(1));
//	    int sal = cronRepo.findById(1).get().getSalary();
//		return cronRepo.findBysalId(1);
//	}
//	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    System.out.println("Got the Bean");
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	    
//	    mailSender.setUsername("ritikgarg.1773@gmail.com");
//	    mailSender.setPassword("Admin@2000");
//	    
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	    
//	    return mailSender;
//	}

}