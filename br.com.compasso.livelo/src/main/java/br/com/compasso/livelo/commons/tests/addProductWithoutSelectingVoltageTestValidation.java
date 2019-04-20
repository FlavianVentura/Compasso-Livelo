package br.com.compasso.livelo.commons.tests;

import org.junit.Test;

import br.com.compasso.livelo.commons.pages.HomePageAddCart;
import br.com.compasso.livelo.commons.pages.HomePageLivelo;

public class addProductWithoutSelectingVoltageTestValidation extends BrowserTestCase {

	/*
	 * Realiza um Teste de Validação se a voltagem de um produto eltrônico foi
	 * selecionada.
	 */
	@Test
	public void shouldValidateSelectingVoltageProduct() throws InterruptedException {

		/*
		 * Acessa a Página principal e pesquisa por um determinado produto.
		 */
		HomePageLivelo.cancelPopupHomePage();
		HomePageLivelo.shouldSearchProductOnSite("Fritadeira sem óleo Mondial");
		HomePageLivelo.shouldSelectProduct();

		/*
		 * Acessa a página do produto e adiciona no carrinho validando a
		 * mensagem de erro.
		 */
		HomePageAddCart.shouldClickAddCartButton();
		HomePageAddCart.shouldValidateVoltage();
		HomePageAddCart.shouldCaptureImgProductOnCart("Selecione_a_voltagem");
	}
}
