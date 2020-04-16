package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandling {

//Implementing Action class and iframe method.

	static WebDriver driver;

	@BeforeClass
	public void driverSetup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.manage().window().maximize();

		driver.get(" https://ezcontent.srijan.net/user/login");
		driver.findElement(By.id("edit-name")).sendKeys("editor@srijan.net");
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

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(element);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//body")).sendKeys("Entering text in the iframe body");
		driver.switchTo().defaultContent();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='edit-title-0-value']")).sendKeys(" iframe");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
