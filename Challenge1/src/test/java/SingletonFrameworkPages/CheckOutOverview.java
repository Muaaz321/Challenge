package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutOverview {

	WebDriver driver;
	Select select;

	public CheckOutOverview(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id = "finish")
	WebElement Finish;
	
	
	public CheckOutComplete clickFinish() throws InterruptedException {

			try {
				Finish.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return new CheckOutComplete(driver,select);
	    		
	}
	
	

	
	
}
