package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.BrowserSetup;
import org.openqa.selenium.By;
public class LandingPage extends BrowserSetup  {
	
	
	@FindBy(id = "searchval")
	public WebElement searchval;
	
	@FindBy(xpath = "//button[@value='Search']")
	public WebElement searchBtn;
	
	@FindBy(id = "paging")
	public WebElement paging;
	
	
	
	 public WebElement getPageNumber(int pageNum) {
	        return driver.findElement(By.xpath("//a[@aria-label='go to page " + pageNum + "']"));
	    }

	
	public WebElement getPageLink(int pageNumber) {
	    String xpath = "//a[@aria-label='go to page " + pageNumber + "']";
	    return driver.findElement(By.xpath(xpath));
	}
	@FindBy(xpath = "(//img[@data-testid='productBoxImage'])[last()]/ancestor::a")
	public WebElement lastProduct;
	
	
	@FindBy(id = "buyButton")
		public WebElement addToCartBtn;

	@FindBy(xpath = "//a[@href='/viewcart.cfm' and contains(text(),'View Cart')]")
	public WebElement viewCart;

	@FindBy(xpath = "//button[contains(@class, 'deleteCartItemButton')]")
	public WebElement delete;
	
	

	
	
	
	public LandingPage(){
		PageFactory.initElements(BrowserSetup.driver,this);
		
		
		
	}

}
