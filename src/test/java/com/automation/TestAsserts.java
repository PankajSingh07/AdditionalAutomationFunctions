package com.automation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Base;



//Implemented types of Assertions

public class TestAsserts extends Base{
	

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
	
	}
	
