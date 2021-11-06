package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import SingletonFramework.TestBase;

public class CheckOutComplete {

	WebDriver driver;
	Select select;

	public CheckOutComplete(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
		PageFactory.initElements(driver, this);
	}

	
	
	public void checkThankyouMessage() {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='complete-header']")).
				getText(), "THANK YOU FOR YOUR ORDER");
	}
	
	
	
	
}
