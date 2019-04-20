package br.com.compasso.livelo.commons.tests;

import org.junit.Test;

import br.com.compasso.livelo.commons.pages.HomePageAddCart;
import br.com.compasso.livelo.commons.pages.HomePageLivelo;


public class AddProductOnCartSuccessTestValidation extends BrowserTestCase{

	/*
	 * Realiza um teste para a inclus�o de um produto no carrinho com sucesso,
	 * preenchendo todos os campos obrigat�rios.
	 */
	@Test
	public void shouldAddPrductOnCart() throws InterruptedException{
		
		/*
		 * Acessa a P�gina principal e pesquisa por um determinado produto.
		 */
		HomePageLivelo.cancelPopupHomePage();
		HomePageLivelo.shouldSearchProductOnSite("Fritadeira sem �leo Mondial");
		HomePageLivelo.shouldSelectProduct();
		
		/*
		 * Acessa a p�gina do produto, preenche os campos e adiciona no carrinho.
		 */
		HomePageAddCart.shouldSelectProductVoltage();
		HomePageAddCart.shouldClickAddCartButton();
		HomePageAddCart.showShoppingCartIcon();
		HomePageAddCart.shouldCaptureImgProductOnCart("Produto_adicionado_com_sucesso!");
	}
}
