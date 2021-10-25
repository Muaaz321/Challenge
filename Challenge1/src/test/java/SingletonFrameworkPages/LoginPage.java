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



	@FindBy(id ="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;

	@FindBy(id="btnLogin")
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
