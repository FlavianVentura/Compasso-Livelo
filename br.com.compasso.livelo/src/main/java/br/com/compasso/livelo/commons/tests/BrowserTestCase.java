package br.com.compasso.livelo.commons.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import br.com.compasso.livelo.commons.Browser;

public class BrowserTestCase {
	
	/*
	 * Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
	 */
	protected static WebDriver driver;
	public static String site_adress = "https://www.pontoslivelo.com.br";
	
	static {
		
		driver = Browser.startBrowser();
	}
	
	/*
	 * Método que inicia a página e acessa a URL do site desejado.
	 */
	@Before
	public void beforeClass() throws Exception {	

			driver.navigate().to(site_adress);
			driver.manage().window().maximize();
			Thread.sleep(2000);
	}
	
	/*
	 *  Método que finaliza o teste, fechando a instância do WebDriver
	 */
	@After
	public void afterClass() throws Exception {
	
		driver.quit();
	}
}



