package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.utils.Base;



public class IframeHandling extends Base{

		
	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get(" https://ezcontent.srijan.net/user/login");
		driver.findElement(By.id("edit-name")).sendKeys("editor@example.com");
		driver.findElement(By.id("edit-pass")).sendKeys("editor@123");
		driver.findElement(By.id("edit-submit")).click();

		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void iframe() throws InterruptedException {

//		WebDriverWait wait=new WebDriverWait(driver, 15);
//		WebElement con = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='toolbar-icon toolbar-icon-system-admin-content']")));

		WebElement con = driver.findElement(By.xpath("//a[@class='toolbar-icon toolbar-icon-system-admin-content']"));
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(con).perform();

		Thread.sleep(1000);

		WebElement addcon = driver.findElement(By.xpath("//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']"));
		action.moveToElement(addcon).build().perform();

		driver.findElement(By.xpath("//a[@class='toolbar-icon toolbar-icon-node-add-page']")).click();
		driver.findElement(By.xpath("//input[@id='edit-title-0-value']")).sendKeys("Testing");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");

		WebElement element = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(element); 
		System.out.println("I'n in the frame");
		driver.findElement(By.xpath("//body//p")).sendKeys("Entering text in the iframe body");
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='edit-title-0-value']")).sendKeys(" iframe");

	}

	}
