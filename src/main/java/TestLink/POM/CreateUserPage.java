package TestLink.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateUserPage extends TestBase {

	public CreateUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//frame[@name='mainframe']")
	WebElement _mainframe;

	@FindBy(name = "login")
	WebElement _input_login;

	@FindBy(name = "firstName")
	WebElement _input_firstName;

	@FindBy(name = "lastName")
	WebElement _input_lastName;

	@FindBy(name = "password")
	WebElement _input_password;

	@FindBy(name = "emailAddress")
	WebElement _input_emailAddress;

	@FindBy(name = "rights_id")
	WebElement _select_rights_id;

	@FindBy(name = "locale")
	WebElement _select_locale;

	@FindBy(name = "authentication")
	WebElement _select_auth;
	
	@FindBy(name = "user_is_active")
	WebElement _check_user_is_active;

	@FindBy(name = "expiration_date")
	WebElement _input_expiration_date;

	@FindBy(name = "do_update")
	WebElement _btn_do_update;

	public void CreateUser(String login, String fname, String lname, String pass, String mail, String role,
			String locale, String auth, String active, String dExp) throws InterruptedException {
		
		// wait loading page
		wait.until(ExpectedConditions.elementToBeClickable(this._btn_do_update));
		// set login
		this._input_login.clear();
		this._input_login.sendKeys(login);

		// set first Name
		this._input_firstName.clear();
		this._input_firstName.sendKeys(fname);

		// set las tName
		this._input_lastName.clear();
		this._input_lastName.sendKeys(lname);

		// set password
		this._input_password.clear();
		this._input_password.sendKeys(pass);

		// set email
		this._input_emailAddress.clear();
		this._input_emailAddress.sendKeys(mail);

		// select role
		 Select _role = new Select(this._select_rights_id);
		 _role.selectByVisibleText(role);

		// select  locale
		 Select _locale = new Select(this._select_locale);
		 _locale.selectByValue(locale);
	
		// select Authentication method
		 Select _auth = new Select(this._select_auth);
		 _auth.selectByVisibleText(auth);
		 
		 // check active 
		 if(active.equals("yes") && !this._check_user_is_active.isSelected() ) {
			 this._check_user_is_active.click(); 
		 }
		 if(active.equals("no") && this._check_user_is_active.isSelected() ) {
			 this._check_user_is_active.click(); 
		 }
		 
		
		 // get day month and year from date
		 String day = dExp.substring(0,2);
		 if(day.substring(0,1).equals("0")) { day = day.substring(1,2);}
		 String menth = dExp.substring(3,6) ;
		 String year = dExp.substring(7,11)  ;


		 
		 // click on calendar and select date
		 WebElement Showcalendar = driver.findElement(By.xpath("//img[contains(@title, 'Show Calender')]"));
		 Showcalendar.click();
		 
		 List<WebElement> allbtn =  driver.findElements(By.xpath("//button[@class=' x-btn-text']"));	 
		 WebElement ShowYearMenth = allbtn.get(0);
		 ShowYearMenth.click();
		 Thread.sleep(2000);
		 WebElement yearElm = driver.findElement(By.xpath("//a[contains(text(), '"+ year +"')]"));
		 yearElm.click();
		 
		 WebElement menthElm = driver.findElement(By.xpath("//a[contains(text(), '"+ menth +"')]"));
		 menthElm.click();
		 
		 WebElement btnYearMenth_OK = driver.findElement(By.xpath("//button[contains(@class,'x-date-mp-ok')]"));
		 btnYearMenth_OK.click();
		 
		 WebElement dayElm = driver.findElement(By.xpath("//span[contains(text(),'"+ day +"')]"));
		 action.doubleClick(dayElm).build().perform();
		 
		 // click on save
		 this._btn_do_update.click();
	}
}
