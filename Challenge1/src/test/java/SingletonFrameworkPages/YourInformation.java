package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation {

	WebDriver driver;

	public YourInformation(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id = "first-name")
	WebElement firstname;
	
	@FindBy(id = "last-name")
	WebElement lastname;
	
	@FindBy(id = "postal-code")
	WebElement postalcoded;	
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public void fillInformation(String fname,String lname,String postalcode) throws InterruptedException {

			try {
				firstname.sendKeys(fname);
				lastname.sendKeys(lname);
				postalcoded.sendKeys(postalcode);
				continueButton.click();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    		
	}
	
	

	
	
}
