package br.com.compasso.livelo.commons.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.compasso.livelo.commons.Browser;
import br.com.compasso.livelo.commons.utils.Util;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class HomePageAddCart {

	private static WebDriver driver;

	/*
	 * Cria uma intância da página e inicia o navegado para acessar o site da Livelo
	 */
	static {

		driver = Browser.startBrowser();
	}

	/*
	 * Inputs, buttons, selects e etc presentes na página
	 */
	static By selectVoltage = By.xpath("//select[@id='option-0']");
	static By addCartButton = By.xpath("//input[@id='btn-add-to-cart']");
	static By cart = By.xpath("//div[@id='headerCartDesk']/article/a/img");
	static By messageError = By.xpath("//section[@id='div-feedbackError']/div/div/div/p");

	/*
	 * Seleciona a voltagem de produtos eletro eletrônicos
	 */
	public static void shouldSelectProductVoltage() throws InterruptedException {

		// Campo select da opção voltagem
		By voltage = By.xpath("//div[@id='select-container']/div/div[2]/select");

		driver.findElement(selectVoltage).click();
		driver.findElement(selectVoltage).sendKeys("110V");
		driver.findElement(voltage).click();
		Util.waitForElementPresent();
	}

	/*
	 * Clica no botão para adicionar o produto ao carrinho.
	 */
	public static void shouldClickAddCartButton() {

		driver.findElement(addCartButton).click();
	}

	public static void shouldValidateVoltage() {

		String textoElement = driver.findElement(messageError).getText();
		Assert.assertEquals(textoElement, "Selecione a Voltagem");
	}

	/*
	 * Cria um evento "Mouse hover" para exibir o produto adicionado ao
	 * carrinho.
	 */
	public static void showShoppingCartIcon() {

		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(cart);
		builder.moveToElement(element).build().perform();
	}

	/*
	 * Captura a imagem(sreenshort) do carrinho com o prduto adicionado.
	 * Adiciona a imagem na pasta screenshort dentro do projeto.
	 */
	public static void shouldCaptureImgProductOnCart(String filaName) {

		try {
			Util.waitForElementPresent();
			Util.screenShort(driver, "src/main/resources/screenshorts/", filaName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
