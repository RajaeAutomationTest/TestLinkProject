package TestLink.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lostPasswordPage extends TestBase {

	public lostPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='user__feedback']")	
	WebElement _user__feedback;
	
}
