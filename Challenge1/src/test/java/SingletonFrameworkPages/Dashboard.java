package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Dashboard {

	WebDriver driver;
	Select select;
	ExtentTest test;
	public Dashboard(WebDriver driver,Select select,ExtentTest test) {

		this.driver = driver;
		this.select = select;
		this.test = test;
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

	@FindBy(xpath = "btn btn_primary btn_small btn_inventory")
	WebElement AddCart;
	
	@FindBy(xpath = "//button[contains(text(),'Add to cart')][1]")
	WebElement addCartselect;
	
	
	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	WebElement Shoppicart;
	
	
	public void menuClick() throws InterruptedException {

			try {
				menu.click();
				test.log(Status.PASS, "Clicked Menu Link");
				Thread.sleep(5000);
			} catch (Exception e) {
				test.log(Status.FAIL, "Couldnt Click Menu Link");
				e.printStackTrace();
			}
	    		
	}
	
	
	
	public void resetClick( ) {
		
		try {
			reset.click();
			test.log(Status.PASS, "Clicked Reset Link");
			Thread.sleep(5000);
			closeMenu.click();
			test.log(Status.PASS, "Clicked Close Link");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "Couldnt Click Reset or Close Link");
			e.printStackTrace();
		}
		
	}
	
	
	public void HightoLow() throws InterruptedException {
		
		try {
			select = new 
					Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

			select.selectByValue("hilo");
			test.log(Status.PASS, "Filter by High to Low");
		} catch (Exception e) {
			test.log(Status.FAIL, "Couldnt Filter by High to Low");
			e.printStackTrace();
		}
			
	}
	
	
	public void selectProduct() {
		
		try {
			addCartselect.click();
			test.log(Status.PASS, "Select the product");
			Thread.sleep(500);
		} catch (Exception e) {
			test.log(Status.FAIL, "Couldnt Select the product");
			e.printStackTrace();
		}
		
	}
	
	
	public CheckOut clickShoppingCart() {
		
		try {
			Shoppicart.click();
			test.log(Status.PASS, "Clicked the Shopping Cart");
		} catch (Exception e) {
			test.log(Status.FAIL, "Couldnt Click the Shopping Cart");
			e.printStackTrace();
		}
		
		return new CheckOut(driver, select);
	}
	
	
	public void selecttopTwoproducts() throws InterruptedException {
		List<WebElement> allProducts = driver.findElements
				(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        
		
		String AddCart = "//button[@class='btn btn_primary btn_small btn_inventory'][1]";
		
		String beforeXpath = "//button[@class='btn btn_primary btn_small btn_inventory'][";
		String afterXpath = "]";
		
		int count = allProducts.size();
		
		System.out.println("All produt add cart object " + allProducts.size());
		
		for(int i=1;i<=count;i++) {
			String ActualXpath = beforeXpath+i+afterXpath;
			WebElement element = driver.findElement(By.xpath(ActualXpath));
			System.out.println(element.getText());
			element.click();
			
		}
		
	}
	
	
	
}
