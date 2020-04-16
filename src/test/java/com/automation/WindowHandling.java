package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	static WebDriver driver;

	@BeforeClass
	public void driverSetup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void windowhandle() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(1000);

		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("//a[contains(text(),'Ecommerce software by PrestaShop')]")).click(); // open first tab
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[@id='social_block']//li[1]//a[1]")).click(); // click to open second tab
																							
		Thread.sleep(1000);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// driver.close(); // close newly opened window
		driver.switchTo().window(parentHandle); // switch back to the original window
		
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
