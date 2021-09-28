package Ops;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

public class rmsOpsLogin {
	 String opsusername = "test.rtl";
	 String opspwd="Kick4Thy";
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		 
		 rmsOpsLogin opslogin=new rmsOpsLogin();
	opslogin.loginRMSops(driver);	
		}
	
	public void loginRMSops(WebDriver driver) throws InterruptedException  {
		//driver.get("http://rmstest.ehealthcorp.net:8021/Login.aspx");
		
		loginblock:while(true) {
			String loginscreen="//table[contains(@id,'Login1')]";
			if(driver.findElement(By.xpath(loginscreen)).isDisplayed()) {
	System.out.println("RMSops login screen is displayed");					
						break loginblock;
			}else {
				Thread.sleep(1000);
			}
		}
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@id,'Login1_UserName')]")).sendKeys(opsusername);
		driver.findElement(By.xpath("//input[contains(@id,'Login1_Password')]")).sendKeys(opspwd);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@value='Log In']")).click();


		content: while(true) {
			
					
				if (driver.findElement(By.xpath("//span[contains(@id,'lnUser')]")).isDisplayed()) {
					
					System.out.println("RMSOps Login is succesfull for user: " + driver.findElement(By.xpath("//span[contains(@id,'lnUser')]")).getText());
				break content;
				}else {
				Thread.sleep(1000);
						}		
				}

		    }
}