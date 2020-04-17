package com.automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
		
		String user = driver.findElement(By.xpath("//span[contains(text(),'test Automation')]")).getText();
		System.out.println(user);
		
		String ExpectedTitle = "test Automation";
		Assert.assertEquals(user, ExpectedTitle);
		System.out.println("Authentication Passed");

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
		jse.executeScript("window.scrollBy(0,500)");
		
		
		WebElement act1 = driver.findElement(By.xpath("//div[@id='center_column']//ul//li//div//div//div//a//img"));
		action.moveToElement(act1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Quick view')]")).click();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
		driver.switchTo().frame(element);
		
		
		WebElement hover1 = driver.findElement(By.xpath("//img[@id='thumb_2']"));
		action.moveToElement(hover1).build().perform();
		Thread.sleep(1000);
		WebElement hover2 = driver.findElement(By.xpath("//img[@id='thumb_3']"));
		action.moveToElement(hover2).perform();
		Thread.sleep(1000);
		WebElement hover3 = driver.findElement(By.xpath("//img[@id='thumb_4']"));
		action.moveToElement(hover3).perform();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		

		driver.switchTo().defaultContent();

	}

	@Test(priority = 3)
	public void placingorder() throws InterruptedException {

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

		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
//		Thread.sleep(1000);
//		
//		String order = driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();
//		System.out.println(order);
//		
//		String ExpectedTitle = "Your order on My Store is complete.";
//		Assert.assertEquals(order, ExpectedTitle);
//		System.out.println("Order Placed Successfully");
//		
//		driver.findElement(By.xpath("//i[@class='icon-chevron-left']")).click();
//		jse.executeScript("window.scrollBy(0,500)");
//
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='logout']")).click();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
