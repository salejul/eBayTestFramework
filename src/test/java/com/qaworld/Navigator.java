package com.qaworld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigator extends DataProviderTest {
	
	WebDriver driver;

	@Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderTest.class)
	public void test1(String s1, String s2, String s3) {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys(s1);
		driver.findElement(By.id("password")).sendKeys(s3);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		
		driver.quit();
	}
	
}
