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

public class OrderPlacedE2E {

	static WebDriver driver;

	@BeforeClass
	public void browserInvoke() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.xpath("//a[@class='login']")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("testautomation789@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("zxcvbnm123");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void purchase() throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

		WebElement act = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(act).perform();

		driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//ul//a[contains(text(),'T-shirts')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")).click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,500)");

	}

	@Test(priority = 3)
	public void placingorder() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();

//		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//i[@class='icon-chevron-left']")).click();
//		jse.executeScript("window.scrollBy(0,750)");
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='logout']")).click();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
