package test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SalesforceLogin {
	public static String sfusername = "itsupport@ehgt.com.ehgtsndbx";
	public static String sfpwd="bIgblu3!680135!!!boyscouT";
	
	public static void main(String[] args) throws InterruptedException, IOException{

		searchRequest cno=new searchRequest();	
		
	}
	public void loginsf(WebDriver driver) throws InterruptedException {
		driver.get("https://ehealthtechnologies--ehgtsndbx.my.salesforce.com/");
		sfloginblock:while(true) {
			if(driver.findElement(By.id("theloginform")).isDisplayed()) {
				driver.findElement(By.id("username")).sendKeys(sfusername);
				driver.findElement(By.id("password")).sendKeys(sfpwd);
				driver.findElement(By.cssSelector("input[value='Log In to Sandbox']")).click();

		break sfloginblock;
			}else {
				Thread.sleep(1000);
			}
		}
	
	dashboard:while(true) {
		if(driver.findElement(By.cssSelector("div[data-component-id='home_newsPanel']")).isDisplayed()) {
			System.out.println("doashbaord is loaded : ");
			driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys();
			
		}
	}
	
	}

	
}
