package TestLink.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LogInPage extends TestBase {
	
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(name = "tl_login")
	WebElement _login;
	
	@FindBy(name = "tl_password")
	WebElement _password;
	
	@FindBy(xpath = "//*[@id='login']/div[3]/input")
	WebElement _connexion;
	
	@FindBy(xpath = "//frame[@name='mainframe']")	
	WebElement _mainframe;
	
	@FindBy(xpath = "/html/body/div[2]/span[2]/a[2]/img")	
	WebElement _logout;
	
	@FindBy(xpath = "//div[@class='user__feedback']")	
	WebElement _msgUserPassIncorrecte;
	
	@FindBy(xpath = "//a[contains(@href,'logout.php')")	
	WebElement _lostPassword;
	
	

	
	public void WaitLoadLoginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(_login));	
		
	}
	
	// se connecter avec un login et mot de passe correct
	public void loginIn(String login,String password)  {
		Boolean isPresent = driver.findElements(By.name("mainframe")).size() > 0;
		if(isPresent) {
			this.logout();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(_login));
		this._login.clear();
		this._login.sendKeys(login);
		this._password.clear();
		this._password.sendKeys(password);
		this._connexion.click();

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("titlebar"))));
		driver.switchTo().frame("titlebar");
		Boolean isPresent2 = this._logout.isDisplayed();
		
		Assert.assertTrue(isPresent2);
	}
	
	// se connecter avec un login ou mot de passe incorrect
	public void loginInInvalidCase(String login,String password)  {
		Boolean isPresent = driver.findElements(By.name("mainframe")).size() > 0;
		if(isPresent) {
			this.logout();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(_login));
		this._login.clear();
		this._login.sendKeys(login);
		this._password.clear();
		this._password.sendKeys(password);
		this._connexion.click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Nom d'utilisateur");
		if(login.isEmpty() || password.isEmpty()) {
		Boolean isPresent2 = this._msgUserPassIncorrecte != null;
		Assert.assertTrue(isPresent2);
		}
	}
	
	public void logout() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("titlebar");
		this._logout.click();
	}
	
	
}
