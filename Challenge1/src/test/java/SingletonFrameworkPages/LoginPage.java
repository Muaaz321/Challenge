package SingletonFrameworkPages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage {

	WebDriver driver;
	Select select;
	ExtentTest test;
	
	public LoginPage(WebDriver driver,Select select,ExtentTest test) {

		this.driver = driver;
		this.select = select;
		this.test = test;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id ="user-name")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login-button")
	WebElement submit;

	public Dashboard userLogin(String uname,String pword) throws InterruptedException {

			try {
				username.sendKeys(uname);
				password.sendKeys(pword);
				submit.click();
				
				test.log(Status.PASS, "Logged In");
				
			} catch (Exception e) {				
				e.printStackTrace();
				test.log(Status.FAIL, "Couldnt Log In");
			}
			
	    	return new Dashboard(driver, select,test);
	}
	
}
