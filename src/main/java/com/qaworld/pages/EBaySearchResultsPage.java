package com.qaworld.pages;

import org.openqa.selenium.WebDriver;


import com.qaworld.elements.EBaySearchResultsElements;

public class EBaySearchResultsPage {

	WebDriver driver;
	

	EBaySearchResultsElements searchResultElements;
	
	public EBaySearchResultsPage(WebDriver driver) {
		this.driver = driver;
		searchResultElements = new EBaySearchResultsElements(driver);
	}
	
	//action
	//get the text of first result
	public String getTextOfFirstResult() {
		return searchResultElements.firstSearchResult.getText().trim();
	}
}
