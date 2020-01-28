package com.qaworld.pages;

import org.openqa.selenium.WebDriver;

import com.qaworld.elements.EBayHomePageElements;

public class EBayHomePage {
	
	WebDriver driver;
	EBayHomePageElements homePageElements;
	
	//creating constructor for web elements of EBayHomePage
	public EBayHomePage (WebDriver driver) {
		this.driver = driver;
		homePageElements = new EBayHomePageElements(driver);
	}
	
	//action
	//click on search button
	public void clickOnSearchButton() {
		homePageElements.searchBtn.click();
	}
	
	//action
	//is search button enabled?
	
	public boolean isSearchButtonEnabled() {
		return homePageElements.searchBtn.isEnabled();
	}

}
