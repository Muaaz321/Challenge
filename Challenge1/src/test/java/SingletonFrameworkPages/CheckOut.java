package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOut {

	WebDriver driver;
	Select select;

	public CheckOut(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button']")
	WebElement Checkout;
	
	
	public YourInformation Clickcheckout() throws InterruptedException {

			try {
				Checkout.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    		
			return new YourInformation(driver, select);
	}
	
	

	
	
}
