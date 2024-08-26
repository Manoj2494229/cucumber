package com.cucumber.test;

import io.cucumber.java.en.When;

public class mapping   {
	 
	@When("Test one")
	public void test_one() {
		System.out.println("test_one");
	}
	@When("Test two")
	public void test_two() {
		System.out.println("test_two");
	}
	@When("Test three")
	public void test_three() {
		System.out.println("test_three");
	}

}
