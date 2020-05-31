package TestLink.TestCases.userManagement;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestLink.POM.TestBase;


public class TS_TL_003_AddUser extends TestBase {

	
	@Test(priority = 1, enabled = true, dataProvider = "addUserValidCase")
	public void CreateUserValidCase(String login, String fname, String lname, String pass, String mail, String role, String locale, String  auth, String active, String dExp) throws InterruptedException {
		
		homePage.openUserManagement();
		userManagementPage.openCreateUser();
		createUserPage.CreateUser(login, fname, lname, pass, mail, role, locale, auth, active, dExp);
		NewUserLogin = login;
		NewUserpassword = pass;
		
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
