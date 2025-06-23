package com.aicha.test;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.test.pages.LandingPage;

public class WebStaurantTest extends CommonMethods {

	public static void main(String[] args) { 
		
/*
 *   Go to https://www.webstaurantstore.com/
    Search for 'stainless work table'.
    Go to the next page, until the last one.
    Add the last of found items to the Cart.
    Empty the Cart.
 */
		setUp();
		LandingPage page = new LandingPage();
		String item = "stainless work table";
		sendText(page.searchval, item);
		click(page.searchBtn);
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		 int pageNum = 2;
		 while (true) {
             try {
                 WebElement nextPage = page.getPageLink(pageNum);
                 js.executeScript("arguments[0].scrollIntoView(true);", nextPage);
                 nextPage.click();
                 pageNum++;
                 wait(1);
             } catch (Exception e) {
                 System.out.println("Last page reached.");
                 break;
             }
         }

         // click last Product
		
		 js.executeScript("arguments[0].scrollIntoView(true);", page.lastProduct);
		 waitForVisibility(page.lastProduct);
		wait(1);
		 page.lastProduct.click();
		 System.out.println("last item clicked");

		 wait(1);
		 waitForVisibility(page.addToCartBtn);
		 js.executeScript("arguments[0].scrollIntoView(true);", page.addToCartBtn);
		 page.addToCartBtn.click();
		 System.out.println("item added to cart");

		 wait(1);
		 waitForVisibility(page.viewCart);
		 click(page.viewCart);
		 wait(2);
		 
		 waitForVisibility(page.delete);
		 click(page.delete);
		 System.out.println("item deleted");
		 wait(2);
		 
// Take ScreenShot
		 File dir = new File(System.getProperty("user.dir") + "/screenshots");
			File location = new File(dir, "Cart Status");
			takeScreenShot(dir, location);


		
		tearDown();
	}
}
	


