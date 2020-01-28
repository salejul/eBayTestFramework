package com.qaworld;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qaworld.lib.AppLib;

public class AbstractBaseTest {
	
	WebDriver driver;
	private AppLib app;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("Chrome") String browser) throws Exception {
		switch (browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Provide valid driver name!");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		app = new AppLib(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public AppLib app() {
		return app;
	}
	
	

}
