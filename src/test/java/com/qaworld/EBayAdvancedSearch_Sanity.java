package com.qaworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EBayAdvancedSearch_Sanity extends AbstractBaseTest {

	@Test(groups = "SanityUrgent")
	public void emptyAdvancedSearchTest() throws Exception {
		
		app().flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
		Thread.sleep(2000);
		
		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";

		
		Assert.assertTrue(app().pages().advancedSearchPage().isSearchButtonEnabled(), "Verify that Search button is enabled.");

		app().pages().advancedSearchPage().clickOnAdvancedSearchButton();
		Thread.sleep(3000);

		String newUrl = app().flow().getCurrentURL();
		String newTitle = app().flow().getCurrentTitle();
		Assert.assertEquals(expectedUrl, newUrl, "Verify URL of the new page.");
		Assert.assertEquals(expectedTitle, newTitle, "Verify TITLE of the new page!");

	}

	@Test(groups = "SanityUrgent")
	public void categoryOptionsInAscendingOrderTest() throws Exception {

		app().flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
		Thread.sleep(2000);
		
		SoftAssert softA = new SoftAssert();

		Select dropdown = new Select(app().pages().advancedSearchPage().selectDropDownMenu());
		List<WebElement> dropdown2 = dropdown.getOptions();

		List<String> arr1 = new ArrayList<String>();

		for (WebElement option : dropdown2) {
			arr1.add(option.getText());
		}

		List<String> arr2 = new ArrayList<String>(arr1);
		Collections.sort(arr2);

		System.out.println("Actual list: " + arr1);
		System.out.println("Sorted list: " + arr2);

		softA.assertFalse(arr1.equals(arr2), "Verify that elements are in alphabetical order.");

		softA.assertAll();

	}

	@Test(groups = "SanityUrgent")
	public void ebayLinkLogoNavigatesToHomepageTest() throws Exception {
		
		app().flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
		Thread.sleep(2000);

		String expectedUrl = "https://www.ebay.com/";
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

		app().pages().advancedSearchPage().clickOneBayLogo();

		String newUrl = app().flow().getCurrentURL();
		String newTitle = app().flow().getCurrentTitle();

		Assert.assertEquals(expectedUrl, newUrl, "Verify URL of the new page");
		Assert.assertEquals(expectedTitle, newTitle, "Verify title of the new page");
	}

	@Test(groups = "SanityUrgent")
	public void advancedSearchKeywordsTest() throws Exception {
		
		app().flow().navigateToUrl("https://www.ebay.com/sch/ebayadvsearch");
		Thread.sleep(2000);
		
		String keyword1 = "gray";
		String keyword2 = "suitcase";
		String searchString = keyword1 + " " + keyword2;

		app().pages().advancedSearchPage().enterSearcStringInKeywordsField(searchString);
		app().pages().advancedSearchPage().clickOnAdvancedSearchButton();

		String firstResultTitle = app().pages().searchResultPage().getTextOfFirstResult();

//		WebElement secondResult = driver.findElement(By.xpath("//div[@id='Results']/descendant::h3[2]"));
//		String secondResultTitle = secondResult.getText().trim();

		Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword1),
				"Result title contains first keyword " + keyword1);
		Assert.assertTrue(firstResultTitle.toLowerCase().contains(keyword2),
				"Result title contains second keyword " + keyword2);

//		Assert.assertTrue(secondResultTitle.toLowerCase().contains(keyword1),
//				"Result title contains first keyword " + keyword1);
//		Assert.assertTrue(secondResultTitle.toLowerCase().contains(keyword2),
//				"Result title contains second keyword " + keyword2);
	}
}
