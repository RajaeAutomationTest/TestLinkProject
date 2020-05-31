package TestLink.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserManagementPage extends TestBase {
	public UserManagementPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "doCreate")	
	WebElement _createBtn;
	
	@FindBy(xpath = "//frame[@name='mainframe']")	
	WebElement _mainframe;
	
	public void openCreateUser(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(_mainframe);
		wait.until(ExpectedConditions.elementToBeClickable(_createBtn));
		this._createBtn.click();
		
	}

}
