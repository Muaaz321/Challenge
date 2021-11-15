package SingletonFrameworkTest;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import SingletonFramework.Constant;
import SingletonFramework.TestBase;
import SingletonFrameworkPages.CheckOut;
import SingletonFrameworkPages.CheckOutComplete;
import SingletonFrameworkPages.CheckOutOverview;
import SingletonFrameworkPages.Dashboard;
import SingletonFrameworkPages.LoginPage;
import SingletonFrameworkPages.YourInformation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test {

	int Twice = 2;
	
	@BeforeClass
	public void setUp() throws IOException {
		TestBase.initialize();
		System.out.println("*** Initializing RootecodeLabs Test Starts **** ");
	}

	
	@org.testng.annotations.Test
	@Parameters({"saucedemousername","saucedemopassword","saucedemofname","saucedemolname","saucedemozipcode"})
	public void Login(@Optional("")String username,@Optional("")String password,
			@Optional("")String firstname,@Optional("")String lastname,@Optional("")String zipcode) throws InterruptedException {
		
		try {
			LoginPage Login = new LoginPage(TestBase.driver,TestBase.select);
			
			Dashboard sausedemoDashboad = Login.userLogin(username, password);
			
			sausedemoDashboad.menuClick();
			sausedemoDashboad.resetClick();
			sausedemoDashboad.HightoLow();
			
			//sausedemoDashboad.selecttopTwoproducts();

			for (int i = 0; i <= 2; i++) {
				sausedemoDashboad.selectProduct();
			}
			
					
			CheckOut checkoutprocess =  sausedemoDashboad.clickShoppingCart();

			YourInformation information = checkoutprocess.Clickcheckout();

			CheckOutOverview overview = information.fillInformation(firstname, lastname, zipcode);
			
			CheckOutComplete complete =  overview.clickFinish();
			
			complete.checkThankyouMessage();
			
			Assert.assertTrue(true,"Test Case Passed");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Assert.assertTrue(false,"Test Case False");
			e.printStackTrace();
			e.getMessage();
			e.getCause();
			e.getStackTrace();
		}
        
	
		
	}
	

	
	
	@AfterMethod
	public void tearDown() {
		//TestBase.Close();
		TestBase.Quit();
	}
	
	
	
	
}
