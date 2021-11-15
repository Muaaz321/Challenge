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
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static WebDriver driver = null;
	public static String browsername = "chrome";
	public static Select select = null;	
	public static Properties ObjectRepository=null;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initialize() throws IOException {
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports.html");
	reporter.config().setDocumentTitle("Challenge Accepted");
	reporter.config().setReportName("Challange");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	
	extent.setSystemInfo("Company name", "Roote Code Labs");
		
	test = extent.createTest("Initializing");
		//Singleton pattern
		if(driver == null) {
			
			ObjectRepository= new Properties();
			
		    FileInputStream fn =new FileInputStream(System.getProperty("user.dir")+
		    		"//src//test//java//SingletonFramework//ObjectRepository.properties");
		    ObjectRepository.load(fn);
			
			if(Constant.browsername.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new ChromeDriver();
				 
				 test.info("Chrome Browser opened");
				
			}
			else if(Constant.browsername.equalsIgnoreCase("firefox")) {
				 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new FirefoxDriver();
				 test.info("Fire fox Browser opened");
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
		
		test.info("Test Completed");
		extent.flush();
		
		driver = null;
	}
	
	public static void Close() {
		System.out.println(" = = Closing the browser = = ");
		driver.close();
		driver = null;
	}
	
	
	
	
	
	
}
