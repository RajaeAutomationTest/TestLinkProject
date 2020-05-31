package TestLink.TestCases.login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestLink.POM.lostPasswordPage;
import TestLink.POM.LogInPage;
import TestLink.POM.TestBase;

public class TS_TL_002_ForgetPass extends TestBase {

	lostPasswordPage lostPasswordPage;
	LogInPage loginPage;

	@BeforeClass
	public void setup() {
		initialisation();
		loginPage = new LogInPage();
		lostPasswordPage = new lostPasswordPage();

	}

	@Test(priority = 1, enabled = true, dataProvider = "emailValid")
	public void ForgetPassValidCase(String email) {

		driver.findElement(By.xpath("//a[contains(@href,'lostPassword.php?viewer=new')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("editUser"))));
		driver.findElement(By.id("login")).sendKeys(email);
		driver.findElement(By.name("editUser")).click();
		Boolean isPresente = driver.findElement(By.xpath("//b[contains(text(),'Fatal error')]")).isDisplayed();
		Assert.assertTrue(isPresente);

		// lostPasswordPage.loginIn(login, password);

	}

	@Test(priority = 2, enabled = true, dataProvider = "emailInvalid")
	public void ForgetPassInvalidCase(String email) {
		driver.get(URL);
		driver.findElement(By.xpath("//a[contains(@href,'lostPassword.php?viewer=new')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("editUser"))));
		driver.findElement(By.id("login")).sendKeys(email);
		driver.findElement(By.name("editUser")).click();
		Boolean isPresente1 = driver.findElement(By.xpath("//div[@class='user__feedback']")).isDisplayed();
		Assert.assertTrue(isPresente1);
		
		Boolean isPresente2;
		if(!email.isBlank()) {
			isPresente2 = driver
				.findElement(By.xpath("//div[contains(text(),'Utilisateur inexistant')]")).isDisplayed();
			Assert.assertTrue(isPresente2);
			}


		// lostPasswordPage.loginIn(login, password);

	}

	@AfterClass
	public void teardown() {
		finish();
	}

	@DataProvider
	public Object[][] emailValid() throws Exception {
		Object[][] data = TestBase.getData("emailValid");
		return data;
	}

	@DataProvider
	public Object[][] emailInvalid() throws Exception {
		Object[][] data = TestBase.getData("emailInvalid");
		return data;
	}

}
