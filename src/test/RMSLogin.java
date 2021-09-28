package test;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RMSLogin {
	
	
	@Test
	public void browser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*RMSLogin login_rms=new RMSLogin();
		login_rms.loginRMS(driver); // logging into RMS
		*/
	}
	@Parameters({"URL"})
	@Test
	public void loginRMS(WebDriver driver, String URL) throws InterruptedException {
		driver.get(URL);
		String username = "ehgt.test4";
		String pwd="Kick4Thy";
		loginblock:while(true) {
			String loginpage="//div[@class='login-graphic']";
			if(driver.findElement(By.cssSelector("div[class='login-graphic']")).isDisplayed()) {
				driver.findElement(By.id("MainContent_Login1_UserName")).sendKeys(username);
				driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
				driver.findElement(By.id("MainContent_Login1_LoginButton")).click();
				
					try {		
				if (driver.findElement(By.id("MainContent_lnName")).isDisplayed()) {
					
					System.out.println("RMS customer portal Login is succesfull for user: " + driver.findElement(By.id("MainContent_lnName")).getText());
				}else if(driver.findElement(By.xpath("//div[contains(text(),'Your login was unsuccessful. Please try again')]")).isDisplayed()) {
					System.out.println(driver.findElement(By.cssSelector("div[class='required']")).getText());
				}
				}
					catch(NoSuchElementException e){
						System.out.println(e);
				}
				
				break loginblock;
			}else {
				waits.WaitForElement(driver, loginpage);
			}
		}
		
	}
	
	@Test
	public void wrongUsername() {
		
	}
	@Test
	public void wrongpwd() {
		
	}
@DataProvider
public Object[][] getData() {
	Object[][] data=new Object[3][2];
	data[0][0]="ehgt.test4";
	data[0][1]="Kick4Thy";
	data[1][0]="test4";
	data[1][1]="Kick4Thy";
	data[2][0]="ehgt.test4";
	data[2][1]="Kick4";
	
	return data;
}
}
