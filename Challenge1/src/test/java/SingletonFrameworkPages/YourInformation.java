package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YourInformation {

	WebDriver driver;
	Select select;

	public YourInformation(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
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
	
	public CheckOutOverview fillInformation(String fname,String lname,String postalcode) throws InterruptedException {

			try {
				firstname.sendKeys(fname);
				lastname.sendKeys(lname);
				postalcoded.sendKeys(postalcode);
				continueButton.click();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return new CheckOutOverview(driver, select);
	    		
	}
	
	

	
	
}
