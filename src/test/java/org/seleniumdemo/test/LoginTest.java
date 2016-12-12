package org.seleniumdemo.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.seleniumdemo.po.LoginPO;
import org.seleniumdemo.po.WindowsManagerPO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	public WebDriver driver;
	LoginPO login;
	Boolean b_esperado;
	Boolean b_actual;
	String esperado;
	String actual;
	
	
	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeMethod(String browser,String url) {
		driver=WindowsManagerPO.launchApp(browser, url);
		login = PageFactory.initElements(driver,
				LoginPO.class);
	}

	@AfterMethod
	public void afterMethod() {
		WindowsManagerPO.closeWindow();
	}

	@Test(priority=1)
	public void Login() {
		String usuario="jruiz";
		String contraseña="jruiz";
		esperado = "Consultar Afiliado";
		login.ingresar(usuario,contraseña);
		actual=login.obtenerTituloHome();
		assertEquals(actual, esperado);
	}

}
