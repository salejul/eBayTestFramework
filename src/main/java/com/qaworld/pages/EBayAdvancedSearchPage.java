package com.qaworld.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qaworld.elements.EBayAdvancedSearchElements;
import com.qaworld.elements.EBaySearchResultsElements;

public class EBayAdvancedSearchPage {
	
	WebDriver driver;
	EBayAdvancedSearchElements advSearchElements;
	EBaySearchResultsElements searchResultElements;
	
	//constructor
	public EBayAdvancedSearchPage(WebDriver driver) {
		this.driver = driver;
		advSearchElements = new EBayAdvancedSearchElements(driver);
		searchResultElements = new EBaySearchResultsElements(driver);
		
	}
	
	//action
	//is search button enabled?
	public boolean isSearchButtonEnabled() {
		return advSearchElements.advancedSearchBtn.isEnabled();
	}
	
	
	//action
	//select dropdown menu
	public WebElement selectDropDownMenu() {
		return advSearchElements.dropDownList;
	}
	
	//action
	//click on eBay logo
	public void clickOneBayLogo() {
		advSearchElements.eBayLogo.click();
	}
	
	//action
	//enter search string in keywords field
	public void enterSearcStringInKeywordsField(String sourceString) {
		advSearchElements.keywordSearchField.sendKeys(sourceString);
	}
	
	//action
	//click on advanced search button
	public void clickOnAdvancedSearchButton() {
		advSearchElements.advancedSearchBtn.click();
	}
	
	
	

}
