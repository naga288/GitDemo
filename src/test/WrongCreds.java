package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrongCreds {

	public void wrongUsername(WebDriver driver) {
		driver.findElement(By.id("MainContent_Login1_UserName")).sendKeys("ehgttest4");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Kick4Thy");
		driver.findElement(By.linkText("Sign-in ")).click();
		WebElement LoginMsg= driver.findElement(By.cssSelector("div[class='required']"));
		if(LoginMsg.isDisplayed()) {
			System.out.println("Test case is passed and Incorrect login meesage is displayed as " + LoginMsg.getText());
		}else {
			System.out.println("Login successfull");
		}
		
	}
	public void wrongPassword(WebDriver driver) {
		driver.findElement(By.id("MainContent_Login1_UserName")).sendKeys("ehgt.test4");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("KickThy");
		driver.findElement(By.linkText("Sign-in ")).click();
		WebElement LoginMsg= driver.findElement(By.cssSelector("div[class='required']"));
		if(LoginMsg.isDisplayed()) {
			System.out.println("Test case is passed and Incorrect login meesage is displayed as " + LoginMsg.getText());
		}else {
			System.out.println("Login successfull");
		}
		
	}
}	
