package SingletonFrameworkPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id ="user-name")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login-button")
	WebElement submit;

	public void userLogin(String uname,String pword) throws InterruptedException {

			try {
				username.sendKeys(uname);
				password.sendKeys(pword);
				submit.click();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    		
	}
	
}
