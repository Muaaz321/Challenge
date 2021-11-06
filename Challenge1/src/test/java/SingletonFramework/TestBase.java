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

public class TestBase {

	public static WebDriver driver = null;
	public static String browsername = "chrome";
	
	
	public static Properties prop = new Properties();
	
	public static void initialize() throws IOException {
		
		InputStream input = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//SingletonFramework//config.properties");
		prop.load(input);
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(prop.getProperty(browsername));
		
		
		//Singleton pattern
		if(driver == null) {
			if(Constant.browsername.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new ChromeDriver();
				 System.out.println("DRIVER TRIGGERED");
				  
			}
			else if(Constant.browsername.equalsIgnoreCase("firefox")) {
				 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//Drivers//chromedriver.exe");
				 driver = new FirefoxDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(Constant.url);
		System.out.println("AFTER URL");
	}
	
	
	public static void Quit() {
		System.out.println(" = = Quitting the browser = = ");
		driver.quit();
		driver = null;
	}
	
	public static void Close() {
		System.out.println(" = = Closing the browser = = ");
		driver.close();
		driver = null;
	}
	
	
}
