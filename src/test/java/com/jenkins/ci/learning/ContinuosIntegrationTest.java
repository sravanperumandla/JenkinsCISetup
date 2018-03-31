package com.jenkins.ci.learning;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContinuosIntegrationTest {

	@BeforeClass
	public void setup() {
		System.out.println("Setup started");
	}
	
	@Test(dataProviderClass=ContinuosIntegrationDP.class)
	public void test1() {
		System.out.println("Test 1 started");
		Assert.fail();
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 started");
		Assert.assertTrue(true);
	}
	@Test
	public void test3() {
		System.out.println("Test 3 started");
		Assert.assertTrue(true);
	}
	@Test
	public void test4() {
		System.out.println("Test 4 started");
		
	}
}
