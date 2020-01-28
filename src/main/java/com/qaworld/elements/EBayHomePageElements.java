package com.qaworld.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBayHomePageElements {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='gh-btn']") public WebElement searchBtn;
	
	public EBayHomePageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
