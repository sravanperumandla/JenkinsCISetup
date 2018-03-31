package com.jenkins.ci.learning;

import org.testng.annotations.DataProvider;

public class ContinuosIntegrationDP {

	@DataProvider(name = "test1")
	public Object[][] test1() {
		Object[] arr1 = { "Cedric", new Integer(36) };
		Object[] arr2 = { "Anne", new Integer(37) };

		return new Object[][] { arr1, arr2 };
	}

}
