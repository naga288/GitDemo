package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RMSLogout {

	public void logout(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		try {	
			logoutloop:while(true) {
			if (driver.findElement(By.id("MainContent_lnName")).isDisplayed()) {
				
				System.out.println("User looged in: " + driver.findElement(By.id("MainContent_lnName")).getText());
				driver.findElement(By.cssSelector("div[class='UserIcon']")).click();
				driver.findElement(By.linkText("Logout")).click();
				if(driver.findElement(By.cssSelector("div[class='login-graphic']")).isDisplayed()) {
					System.out.println("Logout is successful");
					break logoutloop;
				}
			}else {
Thread.sleep(1000);
}
			}
			}
				catch(NoSuchElementException e){
					System.out.println(driver.findElement(By.cssSelector("div[class='required']")).getText());
			}
}
			
		}
/*	
		// Login function
			public  void login(WebDriver driver,String username,String pwd) {
		driver.findElement(By.id("MainContent_Login1_UserName")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		driver.findElement(By.id("MainContent_Login1_LoginButton")).click();
		
			try {		
		if (driver.findElement(By.id("MainContent_lnName")).isDisplayed()) {
			
			System.out.println("Test case is passed and Login is succesfull for user: " + driver.findElement(By.id("MainContent_lnName")).getText());
		//	logout(driver); // Calling logout function
		}else {
			System.out.println(driver.findElement(By.cssSelector("div[class='required']")).getText());
		}
		}
			catch(NoSuchElementException e){
				System.out.println(driver.findElement(By.cssSelector("div[class='required']")).getText());
		}
		}
	*/		
			// Logout Function
		/*public void logout(WebDriver driver) {	
		driver.findElement(By.cssSelector("div[class='UserIcon']")).click();
		driver.findElement(By.linkText("Logout")).click();
		if(driver.findElement(By.cssSelector("div[class='login-graphic']")).isDisplayed()) {
			System.out.println("Logout is successful");
		}
	}*/


