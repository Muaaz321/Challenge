package SingletonFrameworkTest;

import java.io.IOException;

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
import SingletonFrameworkPages.CheckOut;
import SingletonFrameworkPages.Dashboard;
import SingletonFrameworkPages.LoginPage;
import SingletonFrameworkPages.YourInformation;


public class Test {

	
	
	@BeforeClass
	public void setUp() throws IOException {
		TestBase.initialize();
		System.out.println("IN INITIALIZATION");
	}

	
	@org.testng.annotations.Test
	@Parameters({"saucedemousername","saucedemopassword"})
	public void Login(@Optional("")String username,@Optional("")String password) throws InterruptedException {
		LoginPage Login = new LoginPage(TestBase.driver);
		Login.userLogin(username, password);
		
		Dashboard sausedemoDashboad = new Dashboard(TestBase.driver);
		sausedemoDashboad.menuClick();
		sausedemoDashboad.resetClick();
		sausedemoDashboad.HightoLow();
		//sausedemoDashboad.selecttopTwoproducts();
		sausedemoDashboad.selectProduct();
		sausedemoDashboad.selectProduct();
		sausedemoDashboad.clickShoppingCart();
		CheckOut checkoutprocess = new CheckOut(TestBase.driver);
		checkoutprocess.Clickcheckout();
		
		YourInformation information = new YourInformation(TestBase.driver);	
		information.fillInformation("Muaaz", "Mohideen", "003");
		
		Thread.sleep(2000);
		
		//to do assertion , config
		
	}
	

	
	
	@AfterMethod
	public void tearDown() {
		//TestBase.Close();
		TestBase.Quit();
	}
}
