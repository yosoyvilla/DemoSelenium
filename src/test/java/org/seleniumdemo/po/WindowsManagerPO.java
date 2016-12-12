package org.seleniumdemo.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WindowsManagerPO {
	private static WebDriver driver;
	String browser;
	String url;
	
	public static WebDriver launchApp(String browser, String url) {
		switch (browser){
		case "firefox":
			driver = new FirefoxDriver(); 
			break;
		case "chrome":
			ChromeOptions options = new	ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "//drivers/chromedriver-windows-32bit.exe"));
			driver = new ChromeDriver(options);
			break;
		case "ie":
		 	DesiredCapabilities capabilities =DesiredCapabilities.internetExplorer();
		 	System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir")+ "//drivers/internetexplorerdriver-windows-32bit.exe"));
		    capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
		    capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		    InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
		    InternetExplorerDriverService service = builder.build();
		    driver = new InternetExplorerDriver(service,capabilities);
		    break;
		}
		getURL(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		}

	public static void getURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void closeWindow() {
		driver.close();
	}
	
}
