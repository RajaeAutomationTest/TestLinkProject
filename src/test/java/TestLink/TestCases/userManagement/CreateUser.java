package TestLink.TestCases.userManagement;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestLink.POM.TestBase;
import TestLinkIntegration.testlinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;


public class CreateUser extends TestBase {

	
	@Test(priority = 1, enabled = true, dataProvider = "addUserValidCase")
	public void CreateUserValidCase(String login, String fname, String lname, String pass, String mail, String role, String locale, String  auth, String active, String dExp) throws TestLinkAPIException {
		String testlinkCase="CreateUserValidCase";
		String notes=null;
		String result=null;
		
		try {		
		homePage.openUserManagement();
		userManagementPage.openCreateUser();
		createUserPage.CreateUser(login, fname, lname, pass, mail, role, locale, auth, active, dExp);
		NewUserLogin = login;
		NewUserpassword = pass;
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

	@Test(priority = 2, enabled = true)
	public void LoginUserCreated() throws InterruptedException {
		loginPage.logout();
		loginPage.loginIn(NewUserLogin, NewUserpassword);
	}
	
	@DataProvider
	public Object[][] addUserValidCase() throws Exception {
		Object[][] data = TestBase.getDataCSV("addUserValidCase");
		return data;
	}
	
}
