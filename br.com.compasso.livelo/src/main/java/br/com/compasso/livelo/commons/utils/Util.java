package br.com.compasso.livelo.commons.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {

	/*
	 * Realiza a captura de imagens na página.
	 */
	public static void screenShort(WebDriver driver, String path, String fileName) throws Exception{

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(path + fileName + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pega o atributo pela classe EXEMPLO - css=a[title="Branco"] > span
	 * 
	 * @param color
	 * @return
	 */
	public static By getXpathByClass(String color) {

		StringBuilder sb = new StringBuilder();
		sb.append("a[title=");

		if (color != null) {
			sb.append("\"");
			sb.append(color);
			sb.append("\"] > span");
			System.out.println(sb.toString());
		}
		return By.cssSelector(sb.toString());
	}

	/*
	 * Adiciona uma espera até que um determinado elemento esteja presente na página.
	 */
	public static void waitForElementPresent(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
