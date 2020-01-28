package com.qaworld.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EBayAdvancedSearchElements {
	
	WebDriver driver;

	@FindBy(xpath="//div[@id='CenterPanel']/descendant::button[1]") public WebElement advancedSearchBtn;
	
	@FindBy(id="gh-la") public WebElement eBayLogo;
	
	@FindBy(xpath="//input[@id='_nkw']") public WebElement keywordSearchField;
	
	@FindBy(xpath="//select[@id='e1-1']") public WebElement dropDownList;
	
	
	public EBayAdvancedSearchElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
