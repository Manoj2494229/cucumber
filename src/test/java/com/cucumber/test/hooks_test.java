//package com.cucumber.test;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.*;
//import io.cucumber.java.BeforeStep;
//
//public class hooks_test {
//	@BeforeAll
//	public static void beforeAll() {
//		System.out.println("@BeforeAll-----------------Start of Scenario-----------------order = 1");
//	}
//	@Before
//    public void beforeScenario(){
//       System.out.println("This will run before the every Scenario");
//
//    }	
//	@Before(order = 1)
//    public void beforeScenarioStart(){
//        System.out.println("@Before-----------------Start of Scenario-----------------order = 1");
//    }	
//	
//	@BeforeStep
//	public void doSomethingBeforeStep(Scenario scenario){
//		 System.out.println("@BeforeStep-----------------Start of Scenario-----------------order = 1");
//	}
//	
//	@AfterStep
//	public void doSomethingAfterStep(Scenario scenario){
//		 System.out.println("@AfterStep-----------------Start of Scenario-----------------order = 1");
//	}
//	
//	
//	@After(order = 1)
//    public void afterScenarioFinish(){
//		//driver.close();
//        System.out.println("@After-----------------End of Scenario-----------------order = 1");
//    }	
//	@After
//    public void afterScenario(){
//		//driver.close();
//        System.out.println("This will run after the every Scenario");
//    }	
//	@AfterAll
//	public static void afterAll() {
//		  System.out.println("@AfterAll-----------------End of Scenario-----------------order = 1");
//	}
//}
