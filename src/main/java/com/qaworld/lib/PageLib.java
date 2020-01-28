package com.qaworld.lib;

import org.openqa.selenium.WebDriver;

import com.qaworld.pages.EBayAdvancedSearchPage;
import com.qaworld.pages.EBayHomePage;
import com.qaworld.pages.EBaySearchResultsPage;

public class PageLib {

	
	private WebDriver driver;
	
	private EBayAdvancedSearchPage advSearchPage;
	private EBaySearchResultsPage searchResultPage;
	private EBayHomePage homePage;
	
	public PageLib(WebDriver driver) {
		this.driver = driver;
		advSearchPage = new EBayAdvancedSearchPage(this.driver);
		searchResultPage = new EBaySearchResultsPage(this.driver);
		homePage = new EBayHomePage(this.driver);
	}

	public EBayHomePage homePage() {
		return homePage;
	}

	public EBayAdvancedSearchPage advancedSearchPage() {
		return advSearchPage;
	}

	public EBaySearchResultsPage searchResultPage() {
		return searchResultPage;
	}
}
