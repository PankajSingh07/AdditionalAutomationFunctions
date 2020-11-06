package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.utils.Base;

//Implemented waits and drop down menu selection

public class LMX extends Base {

	
	@Test(priority = 1)
	public void login() throws InterruptedException {
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// VPN is required
		// driver.get("https://fe-stage.mylmx.com/login");
		driver.get("https://www.mylmx.com/login");
		driver.findElement(By.name("username")).sendKeys("pankaj.singh");
		driver.findElement(By.name("password")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@class='decline-button eu-cookie-compliance-default-button']")).click();

		// driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
	}

	@Test(priority = 2)
	public static void products() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// WebElement element =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Products')]")));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Products')]")));
		element.click();
//		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();	
//		
		Thread.sleep(4000);
	}

	@Test(priority = 3)
	public void experiences() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Experiences')]")));
		element.click();

//		driver.findElement(By.xpath("//a[contains(text(),'Experiences')]")).click();	
		Thread.sleep(4000);
	}

	@Test(priority = 4)
	public void videos() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Videos')]")));
		element.click();

//		driver.findElement(By.xpath("//a[contains(text(),'Videos')]")).click();	
		Thread.sleep(4000);
	}

	@Test(priority = 5)
	public void tools() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Tools')]")));
		element.click();

//		driver.findElement(By.xpath("//a[contains(text(),'Tools')]")).click();	
		Thread.sleep(4000);
	}

	@Test(priority = 6)
	public void search() throws InterruptedException {

		WebElement w = driver.findElement(By.xpath("//input[@title='Search']"));
		w.sendKeys("THE PERFECTING PRIMER");
		w.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='type']")));
		element.click();

		Thread.sleep(1000);

		Select content = new Select(driver.findElement(By.xpath("//select[@name='type']")));
		content.selectByVisibleText("Product Pages");

		driver.findElement(By.xpath("//input[@name='Refine Search']")).click();
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='product-link__name']"))).click();
		// driver.findElement(By.xpath("(//span[@class='product-link__name']")).click();

		Thread.sleep(2000);

//		int i=2;
//		while(i<=5)
//		{
//			driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[i]/button")).click();
//			Thread.sleep(2000);
//			i++;
//		}
//		
//		int i=0;
//		
//		for(i=2; i<=5; i++) {
//			
//			driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[i]/button")).click();
//			Thread.sleep(2000);
//						
//		}

		driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[2]/button")).click();
		// driver.findElement(By.xpath("//ul[@class='slick-dots']/li[2]/button")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//ul[@class='slick-dots']/li[3]/button")).click();
		driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[3]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[4]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='learning-wrapper']/div/ul/li[5]/button")).click();
		Thread.sleep(1000);
		
	
	}

}
