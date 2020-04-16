package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Implemented types of Assertions

public class TestAsserts {
	
static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void login() throws InterruptedException
	{
		
		
		//driver.get("https://fe-stage.mylmx.com/login");  // VPN is required 
		driver.get("https://www.mylmx.com/login");
		
		
		driver.findElement(By.name("username")).sendKeys("pankaj.singh");
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String Title = driver.getTitle();
		System.out.println(Title);
		
		String ExpectedTitle = "La Mer Learning Experience";
		Assert.assertEquals(Title, ExpectedTitle);
		System.out.println("Assert passed: Matched the title");
		
		
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[@class='decline-button eu-cookie-compliance-default-button']")).click();
		
		 String wValue = "Good Afternoon, Pankaj";
		 Assert.assertEquals("Good Afternoon, Pankaj", wValue);
		 System.out.println(wValue);
		 
		 String qValue = "Afternoon, Pankaj";
		 Assert.assertNotEquals(qValue, "Good Afternoon, Pankaj");
		 System.out.println("Not equal passed");
		 
		 Assert.assertTrue(wValue.contains("Good"));
		 System.out.println("Good found in the string");
		 
		 Assert.assertFalse(wValue.contains("abc"));
		 System.out.println("passed");
		 	 		
	}
	
		@AfterClass
		public void teardown() {
		driver.quit();
		}
		
	}
	
