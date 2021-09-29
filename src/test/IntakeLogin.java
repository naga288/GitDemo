package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IntakeLogin {
	
	public static void loginIntake(WebDriver driver) {
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("https://intake.eht-qa-01.ehealth-development.com/home/new-requests​")).sendKeys(selectLinkOpeninNewTab);
		
//		driver.get("https://intake.eht-qa-01.ehealth-development.com/home/new-requests​");
		
	}

	/*testing git commits
	 new commnetss
	 develop nbrancj*/

}

