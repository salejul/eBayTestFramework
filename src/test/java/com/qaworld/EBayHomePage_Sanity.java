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
	
	
	@Test
	public void emptySearchTest() throws Exception {


		driver.get("https://www.ebay.com");
		
		SoftAssert softAs = new SoftAssert();
		
		//These are soft asserts over hard assertions
		
		softAs.assertTrue(homePage.isSearchButtonEnabled(), "Verify that search button is enabled.");
		homePage.clickOnSearchButton();
		String expectedURL = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();

		softAs.assertEquals(expectedURL, actualURL, "Verify that actual url maches expected!");
		
		softAs.assertTrue(expectedTitle.contains(actualTitle), "Verify that actual title maches expected!");

		Thread.sleep(2000);
		
		softAs.assertAll();
	}
	
	
	
	

}
