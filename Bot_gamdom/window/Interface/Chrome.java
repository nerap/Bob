package Interface;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Chrome {
	
	public static WebDriver driver;
	
	
	public static  void setup() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void end() {
		driver.quit();
	}
	
	public static String method(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') 
	        str = str.substring(0, str.length() - 1);
	    return str;
	}
	
	public static float xPathToFloat(String x_path) {
		float result = Float.valueOf(method(driver.findElement(By.xpath(x_path)).getText()));
		
		return result;
	}
}
