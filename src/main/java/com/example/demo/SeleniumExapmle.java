package com.example.demo;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertNotNull;
//import static org.testng.Assert.assertTrue;
//
//import org.springframework.stereotype.Service;
//import org.testng.annotations.Test;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class SeleniumExapmle {
	
	@Test
    public void whenAboutBaeldungIsLoaded_thenAboutEugenIsMentionedOnPage() {    	
    	System.setProperty("webdriver.chrome.driver","D:\\Recover\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("http://demo.guru99.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Page Title Chrome: " +title);
		driver.quit();
    }
}