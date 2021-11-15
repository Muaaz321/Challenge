package SingletonFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

	public static WebDriver driver = null;
	public static String browsername = "chrome";
	public static Select select = null;	
	public static ExtentReports extent;
	public static ExtentTest Test;
	public static ExtentSparkReporter reporter;
	
	
	public static void initialize() throws IOException {
		
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport.html");
		reporter.config().setDocumentTitle("Challenge 01 Report");
		reporter.config().setReportName("Challenge 01");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Company Name", "The Challenge");
		extent.setSystemInfo("Project Name", "Project Challenge");
		extent.setSystemInfo("Test Resource", "Muaaz Mohideen");
		
		Test = extent.createTest("Initializing");
		
		
		//Singleton pattern
		if(driver == null) {
			if(Constant.browsername.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new ChromeDriver();
				 Test.info("Chrome Stared");
			}
			else if(Constant.browsername.equalsIgnoreCase("firefox")) {
				 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new FirefoxDriver();
				 Test.info("Firefox Stared");
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constant.Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constant.Wait, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
		
		driver.get(Constant.url);
		System.out.println("AFTER URL");
	}
	
	
	public static void Quit() {
		System.out.println(" **** Quitting the browser **** ");
		driver.quit();
		Test.info("Test Completed");
		extent.flush();
		driver = null;
	}
	
	public static void Close() {
		System.out.println(" = = Closing the browser = = ");
		driver.close();
		driver = null;
	}
	
	
}
