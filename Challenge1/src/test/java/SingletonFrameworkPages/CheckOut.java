package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

	WebDriver driver;

	public CheckOut(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button']")
	WebElement Checkout;
	
	
	public void Clickcheckout() throws InterruptedException {

			try {
				Checkout.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    		
	}
	
	

	
	
}
