package SingletonFrameworkPages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {

	WebDriver driver;
	Select select;

	public Dashboard(WebDriver driver,Select select) {

		this.driver = driver;
		this.select = select;
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
	
	
	public void HightoLow() throws InterruptedException {
		
		try {
			select = new 
					Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

			select.selectByValue("hilo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public void selectProduct() {
		
		try {
			addCartselect.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public CheckOut clickShoppingCart() {
		
		try {
			Shoppicart.click();
			System.out.println("clicked shopping cart");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
