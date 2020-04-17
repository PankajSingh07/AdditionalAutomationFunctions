package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.utils.Base;


public class SearchFeature extends Base {

	@Test
	public void search1() throws InterruptedException {
		
	

		LMX lm = new LMX();
		lm.login();

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
