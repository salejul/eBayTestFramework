package com.qaworld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qaworld.pages.EBayAdvancedSearchPage;
import com.qaworld.pages.EBayHomePage;
import com.qaworld.pages.EBaySearchResultsPage;

public class AbstractBaseTest {
	
	WebDriver driver;
	
	EBayAdvancedSearchPage advSearchPage;
	EBaySearchResultsPage searchResultPage;
	EBayHomePage homePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		advSearchPage = new EBayAdvancedSearchPage(driver);
		searchResultPage = new EBaySearchResultsPage(driver);
		homePage = new EBayHomePage(driver);
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
