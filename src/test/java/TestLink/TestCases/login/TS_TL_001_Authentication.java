package TestLink.TestCases.login;


import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestLink.POM.TestBase;
import TestLinkIntegration.testlinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TS_TL_001_Authentication extends TestBase {
//	LogInPage loginPage;
//	HomePage homePage;
//	UserManagementPage userManagementPage;
//	CreateUserPage createUserPage;

	@BeforeSuite
	public void setup() {
		initialisation();
//		loginPage = new LogInPage();
//		homePage = new HomePage();
//		userManagementPage = new UserManagementPage();
//		createUserPage = new CreateUserPage();
		//loginPage.loginIn(username, password);

	}
	
	@Test(priority = 1, enabled = true, dataProvider = "LoginDataValidCase")
	public void authenticationValidCase(String login, String password) throws TestLinkAPIException  {
		String testlinkCase="001authenticationValidCase";
		String notes=null;
		String result=null;
		
		try {
			
			loginPage.loginIn(login, password);
			result= TestLinkAPIResults.TEST_PASSED;
			notes="Executed successfully";		
		}
		catch(Exception e) {
			result=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed :\n" +e.getStackTrace().toString();	
			e.printStackTrace();
			MarkFaildTest();
		}
		catch(AssertionError e) {
			result=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed :\n" +e.getStackTrace().toString();	
			e.printStackTrace();
			MarkFaildTest();
		}
		finally{
				testlinkIntegration.reportResult(testlinkCase, notes, result);
		}

	}
	
	@Test(priority = 2, enabled = false, dataProvider = "LoginDataInvalidCase")
	public void authenticationInvalidCase(String login, String password) throws TestLinkAPIException  {
	
		String testlinkCase="002authenticationInvalidCase";
		String notes=null;
		String result=null;
		
		try {
			
			loginPage.loginInInvalidCase(login, password);
			result= TestLinkAPIResults.TEST_PASSED;
			notes="Executed successfully";		
		}
		catch(Exception e) {
			result=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed :\n" +e.getStackTrace().toString();	
			e.printStackTrace();
			MarkFaildTest();
		}
		catch(AssertionError e) {
			result=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed :\n" +e.getStackTrace().toString();	
			e.printStackTrace();
			MarkFaildTest();
		}
		finally{
				testlinkIntegration.reportResult(testlinkCase, notes, result);
		}
	}
	

	@DataProvider
	public Object[][] LoginDataValidCase() throws Exception {
		Object[][] data = TestBase.getData("LoginDataValidCase");
		return data;
	}

	
	@DataProvider
	public Object[][] LoginDataInvalidCase() throws Exception {
		Object[][] data = TestBase.getData("LoginDataInvalidCase");
		return data;
	}
	
	@AfterSuite
	public void teardown() {
		 loginPage.logout();
		 finish();
	}

}
