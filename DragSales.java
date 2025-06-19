package com.test12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class DragSales extends CommonMethods  {

	public static void main(String[] args) {
		
//demo.guru99.com/test/drag_drop.html

		
			
		setUp();
		
		WebElement bank = driver.findElement(By.id("credit2"));
		WebElement debit = driver.findElement(By.xpath("//ol[@id='bank']"));
		
		WebElement sales = driver.findElement(By.id("credit1"));
		WebElement credit = driver.findElement(By.id("loan"));
		
		WebElement debitamount = driver.findElement(By.id("fourth"));
		WebElement debitside = driver.findElement(By.id("amt7"));
		
		WebElement creditamount = driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
		WebElement creditside = driver.findElement(By.id("amt8"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(bank, debit).perform();
		action.dragAndDrop(sales, credit).perform();
		action.dragAndDrop(debitamount, debitside).perform();
		action.dragAndDrop(creditamount, creditside).perform();

		wait(5);

		
		tearDown();
		
	}

}
