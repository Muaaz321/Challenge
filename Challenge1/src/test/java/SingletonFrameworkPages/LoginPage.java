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

import SingletonFramework.TestBase;

public class LoginPage {

	WebDriver driver;
	Select select;

	
	public LoginPage(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
		PageFactory.initElements(driver, this);
	}

	//static final String ORusername = ObjectRepository.getProperty("username");
	

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
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
	    	return new Dashboard(driver, select);
	}
	
}
