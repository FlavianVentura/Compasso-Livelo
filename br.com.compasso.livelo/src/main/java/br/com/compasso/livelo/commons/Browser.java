package br.com.compasso.livelo.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	protected static WebDriver driver = null;
	private static String browserName = null;
	private static String firefoxDriver_path = "src/main/resources/browser/geckodriver.exe";
	private static String chromeDriver_path = "src/main/resources/browser/chromedriver.exe";
	
	public static WebDriver startBrowser(){
		
		
		if(driver == null){
			
			browserName = "chrome";
			
			if(browserName.equals("firefox")){
				
				System.setProperty("webdriver.gecko.driver", firefoxDriver_path);
				driver = new FirefoxDriver();
			}else if(browserName.equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", chromeDriver_path);
				driver = new ChromeDriver();
			}
			
		}
		return driver;
		
	}
}
