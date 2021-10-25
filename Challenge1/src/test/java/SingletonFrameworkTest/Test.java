package SingletonFrameworkTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import SingletonFramework.Constant;
import SingletonFramework.TestBase;
import SingletonFrameworkPages.LoginPage;


public class Test {

	
	
	@BeforeClass
	public void setUp() {
		TestBase.initialize();
		System.out.println("IN INITIALIZATION");
	}
	
	
	@org.testng.annotations.Test(priority = 1)
	public void verifyOrangeHrmTitleTest() {
		String title = TestBase.driver.getTitle();
		System.out.println("Title is " + title);
		
	}
	
	
	@org.testng.annotations.Test(priority = 1)
	public void logoTest() {
		Assert.assertEquals(TestBase.driver.findElement(By.id("divLogo")).isDisplayed(), true);
		
	}
	
	
	@org.testng.annotations.Test
	@Parameters({"orangeusername","orangepassword"})
	public void Login(@Optional("Admin") String username,@Optional("admin123") String password) throws InterruptedException {
		LoginPage Login = new LoginPage(TestBase.driver);
		Login.userLogin(username, password);
	}
	
	
	@org.testng.annotations.Test(priority = 1)
	@Parameters({"orangeusername","orangepassword"})
	public void ApplyLeave(@Optional("Admin") String username,@Optional("admin123") String password) throws InterruptedException {
		
		LoginPage Login = new LoginPage(TestBase.driver);
		Login.userLogin(username, password);
		
		String ApplyLeave = TestBase.driver.findElement(By.xpath("//*[text()='Apply Leave']")).getText().toString();
		Assert.assertEquals(ApplyLeave, "Apply Leave");
		
		
		}
	
	
	
	@AfterMethod
	public void tearDown() {
		//TestBase.Close();
		TestBase.Quit();
	}
}
