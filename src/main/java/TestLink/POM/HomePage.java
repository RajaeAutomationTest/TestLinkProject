package TestLink.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "/html/body/div[2]/span[2]/a[2]/img")	
	WebElement _logout;
	
	@FindBy(xpath = "//frame[@name='titlebar']")	
	WebElement titlebar;
	
	@FindBy(xpath = "//frame[@name='mainframe']")	
	WebElement _mainframe;
	
	@FindBy(xpath = "//img[contains(@title, 'User Management') or contains(@title, 'Users/Roles')]")	
	WebElement _linkUsers;
	
	@FindBy(xpath = "//img[@title='Desktop']")	
	WebElement _linkDesktop;
	
	@FindBy(xpath = "//img[contains(@title, 'Requirement Specification') or contains(@title, 'Requirements')]")	
	WebElement _linkRequirements;
	
	@FindBy(xpath = "//img[@title='Test Specification']")	
	WebElement _linkSpecification;
	
	public void logout() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(titlebar);
		this._logout.click();
	}


	public void openUserManagement(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(titlebar);
		this._linkUsers.click();
		
	}

}
