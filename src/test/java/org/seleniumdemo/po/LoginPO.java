package org.seleniumdemo.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPO {
	
	protected WebDriver driver;
	private Wait<WebDriver> fluentWait;
	
	public LoginPO(WebDriver driver) {
		this.driver = driver;
		this.fluentWait = new FluentWait<WebDriver>(driver)
			    .withTimeout(60, TimeUnit.SECONDS)
			    .pollingEvery(100, TimeUnit.MILLISECONDS);
	}

}
