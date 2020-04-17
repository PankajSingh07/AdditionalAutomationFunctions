package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static WebDriver driver;
	
	@BeforeTest
	public static void driverSetup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium drivers\\chromedriver.exe");
//	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
