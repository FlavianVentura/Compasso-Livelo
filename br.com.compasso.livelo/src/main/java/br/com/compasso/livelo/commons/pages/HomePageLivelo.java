package br.com.compasso.livelo.commons.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.compasso.livelo.commons.Browser;
import br.com.compasso.livelo.commons.utils.Util;

public class HomePageLivelo {

	private static WebDriver driver;

	/*
	 * Cria uma intância da página e inicia o navegadoe acessa o site da Livelo
	 */
	static {

		driver = Browser.startBrowser();
	}

	/*
	 * Pega todos os elementos (Buttons, inputs, Text, etc) da página.
	 */
	static By popup = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Uma empresa'])[1]/following::div[9]");
	static By popupButtonNo = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/preceding::button[2]");
	static By description = By.id("search");
	static By product = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mais vistos'])[1]/following::h5[1]");
	static By submitFiledSearch = By.id("formsearch");

	/*
	 * Método que cancela o popup da página principal da Livelo
	 */
	public static void cancelPopupHomePage() {

		boolean isElementPresent = driver.findElement(popup).isDisplayed();

		if (isElementPresent) {
			Util.waitForElementPresent();
			driver.findElement(popupButtonNo).click();
		}else{
			driver.findElement(popupButtonNo).click();
		}
	}

	/*
	 * Método que limpa, preenche e submete o campo de busca de um produtos
	 * específico.
	 */
	public static void shouldSearchProductOnSite(String product) throws InterruptedException {

		driver.findElement(description).click();
		driver.findElement(description).clear();
		driver.findElement(description).sendKeys(product);
		driver.findElement(submitFiledSearch).submit();
	}

	/*
	 * Seleciona e clica no prduto pesquisado para que possa ser adicionado ao
	 * carrinho.
	 */
	public static void shouldSelectProduct() throws InterruptedException {

		boolean isElementPresent = driver.findElement(product).isDisplayed();

		if (isElementPresent) {

			driver.findElement(product).click();
			Thread.sleep(9000);
		}
	}

}
