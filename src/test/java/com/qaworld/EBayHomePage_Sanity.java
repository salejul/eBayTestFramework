package com.qaworld;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class EBayHomePage_Sanity extends AbstractBaseTest {
	
	
	@BeforeClass
	public void start() {
		System.out.println("Starting the project...");
	}
	
	@AfterClass
	public void end() {
		System.out.println("Ending the project...");
	}
	
	
	@Test(groups = "SanityUrgent")
	public void emptySearchTest() throws Exception {


		app().flow().navigateToUrl(app().pages().homePage().getPageUrl());
		
		SoftAssert softAs = new SoftAssert();
		
		//These are soft asserts over hard assertions
		
		softAs.assertTrue(app().pages().homePage().isSearchButtonEnabled(), "Verify that search button is enabled.");
		app().pages().homePage().clickOnSearchButton();
		String expectedURL = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";
		String actualURL = app().flow().getCurrentURL();
		String actualTitle = app().flow().getCurrentTitle();

		softAs.assertEquals(expectedURL, actualURL, "Verify that actual url maches expected!");
		
		softAs.assertTrue(expectedTitle.contains(actualTitle), "Verify that actual title maches expected!");

		
		softAs.assertAll();
	}
	
	
	
	

}
