package org.seleniumdemo.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	private void esperarElemento(WebElement elemento) {
		fluentWait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	@FindBy(id= "userInput")
	private WebElement ingresarNombreUsuario;
	
	@FindBy(id= "passwordInput")
	private WebElement ingresarContraseña;
	
	@FindBy(id= "btnIngresar")
	private WebElement botonIngresar;
	
	@FindBy(id= "errorMessageLogin")
	private WebElement mensaje;
	
	@FindBy (id="lblTitleConsultAfiliado")
	protected WebElement getTitulo;
	
	public void ingresar(String nombreUsuario,String contraseña){
		ingresarNombreUsuario.sendKeys(nombreUsuario);
		ingresarContraseña.sendKeys(contraseña);
		botonIngresar.click();
	}
	
	public void ingresarUsuario(String nombreUsuario){
		ingresarNombreUsuario.sendKeys(nombreUsuario);
	}
	
	public void ingresarContrasena(String contrasena){
		ingresarContraseña.sendKeys(contrasena);
	}
	
	public void obtenerMensajeErrorLogin(){
		botonIngresar.click();
	}
	
	public String obtenerMensaje(){
		return mensaje.getText();
	}

	public String obtenerTituloHome() {
		return getTitulo.getText();
	}

}
