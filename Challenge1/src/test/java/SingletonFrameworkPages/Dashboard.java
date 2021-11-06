package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id ="react-burger-menu-btn")
	WebElement menu;

	@FindBy(id="reset_sidebar_link")
	WebElement reset;

	@FindBy(xpath = "//button[@id='react-burger-cross-btn']")
	WebElement closeMenu;
	
	
	@FindBy(className = "product_sort_container")
	WebElement sort;

	public void menuClick() throws InterruptedException {

			try {
				menu.click();
				Thread.sleep(5000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    		
	}
	
	
	
	public void resetClick( ) {
		
		try {
			reset.click();
			Thread.sleep(5000);
			closeMenu.click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void HightoLow() {
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@class='product_sort_container']"));
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
            
            if(allOptions.get(i).getText().contains("Price (high to low)")) {
                 
                allOptions.get(i).click();
                System.out.println("Success");
                break;
                 
            }
        }
		
	}
	
	
}
