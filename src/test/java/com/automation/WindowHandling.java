package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.utils.Base;


public class WindowHandling extends Base{

	@Test
	public void windowhandle() throws InterruptedException {

		
		driver.get("http://automationpractice.com/index.php");

		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(1000);

		String parentHandle = driver.getWindowHandle(); // get the current window handle
		WebElement PrestaShop = driver.findElement(By.xpath("//a[contains(text(),'Ecommerce software by PrestaShop')]")); // open first tab
		Thread.sleep(1000);
		PrestaShop.click();
		driver.getTitle();
		driver.findElement(By.xpath("//section[@id='social_block']//li[1]//a[1]")).click(); // click to open second tab
																							
		Thread.sleep(1000);

//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}

		// driver.close(); // close newly opened window
		driver.switchTo().window(parentHandle); // switch back to the original window
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

}
