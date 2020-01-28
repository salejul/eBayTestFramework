package com.qaworld.lib;

import org.openqa.selenium.WebDriver;

public class FlowLib {

	private WebDriver driver;
	
	public FlowLib(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToUrl(String URL) {
		this.driver.get(URL);
	}
	
	public String getCurrentURL() {
		return this.driver.getCurrentUrl();
	}
	
	
	public String getCurrentTitle() {
		return this.driver.getTitle();
	}
}
