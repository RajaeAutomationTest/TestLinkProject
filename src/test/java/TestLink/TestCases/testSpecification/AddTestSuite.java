package TestLink.TestCases.testSpecification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestLink.POM.TestBase;

public class AddTestSuite {
	
	@Test(priority = 1, enabled = true, dataProvider = "dataTestSuiteValidCase")
	public void AddTestSuiteValidCase()
	{
		
	}
	
	
	@DataProvider
	public Object[][] dataTestSuiteValidCase() throws Exception {
		Object[][] data = TestBase.getDataCSV("AddTestSuiteValidCase");
		return data;
	}
}
