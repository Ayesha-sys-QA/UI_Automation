package com.test12;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HRMtest extends CommonMethods {

	public static void main(String[] args) {
		
//https://hrm.neotechacademy.com/
		
		setUp();
		
		//Login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type= 'submit']")));
		
		// PIM menu
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		// Add an Employee
		click(driver.findElement(By.id("menu_pim_addEmployee")));
				
		sendText(driver.findElement(By.id("first-name-box")), "Alma");
		sendText(driver.findElement(By.id("last-name-box")), "Montana");
		selectDropdown(driver.findElement(By.id("location")), "France Regional HQ");
		wait(5);
		// Save
		click(driver.findElement(By.id("modal-save-button")));

        waitForVisibility(By.xpath("//*[@id=\"top-menu\"]/li[1]/a"));
		
		//List of Employees
		click(driver.findElement(By.id("menu_pim_viewEmployeeList")));
		wait(5);
					
			    List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
			    
			    for (int i = 1; i <= rows.size(); i++) {
			        WebElement namecell = driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[" + i + "]/td[3]"));
			        if (namecell.getText().contains("Alma Montana")) {
			        	click(namecell);
			        	wait(5);
			        	TakesScreenshot ssDriver = (TakesScreenshot) driver; 
			        	File screenShot = ssDriver.getScreenshotAs(OutputType.FILE);

						try {
							File screenShotDir = new File("screenshots/HRM1");

							// check if the directory exists
							if (!screenShotDir.exists()) {
								// create the folders
								screenShotDir.mkdirs();
							}

							File screenshotLocation = new File("screenshots/HRM1/employee.png");
							Files.copy(screenShot, screenshotLocation);
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Unable to take the screenshot!");
						}
			        }
       
			    }
			     

		wait(5);
				
		tearDown();
		
	}

}
