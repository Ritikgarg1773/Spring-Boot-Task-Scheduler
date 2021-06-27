package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class TestngXMLusingCode {
	public void testNgSuite(String classTest) {
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		List<XmlClass> classes = new ArrayList<XmlClass>();
		
		// create XML suites
		XmlSuite suite = new XmlSuite();
		suite.setName("ProgramSuite");
		// Create XML Tests
		XmlTest test = new XmlTest(suite);
		test.setName("ProgramTest");
		
		// Create XML classes
		XmlClass class1 = new XmlClass(classTest);
		classes.add(class1);
		System.out.println(class1.getName());  // It is correct, it is going to the class
		test.setXmlClasses(classes);
		
		suites.add(suite);
		
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		System.out.println("Executing Test" + suites.getClass());
		tng.run();
		
	}
	
//	public static void main(String[] args) {
//		TestngXMLusingCode tmuc = new TestngXMLusingCode();
//		tmuc.testNgSuite("com.example.demo.SeleniumExample");
//	}
}
