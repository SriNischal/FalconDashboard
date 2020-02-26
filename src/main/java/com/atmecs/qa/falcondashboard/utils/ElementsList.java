package com.atmecs.qa.falcondashboard.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class ElementsList {
	Browser browser=null;
	LogReport log=new LogReport();
	public ElementsList(Browser browser) {
		this.browser=browser;
	}
	@SuppressWarnings("deprecation")
	public String listofElements(String product) {
		System.out.println("product ->" +product);
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(product);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
		System.out.println("product ->" +product);
		return product;
	}
	
	@SuppressWarnings("deprecation")
	public String separatingElements(String product) {
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(product);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
		String separate = ",";
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (index < texts.size() - 1) {
			sb.append(texts.get(index));
			sb.append(separate);
			index++;
		}
		sb.append(texts.get(index));
		String result = sb.toString();
		System.out.println(result);
		return result;
	}

}
