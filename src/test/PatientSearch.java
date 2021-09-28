package test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientSearch {

	public void psch(WebDriver driver,String patientName, String lastName ) throws InterruptedException {
		String dashboard="//div[contains(@id,'RecordsTabPage')]";
		driver.findElement(By.linkText("Dashboard")).click();

		dashboard:while(true) {
				if(driver.findElement(By.xpath(dashboard)).isDisplayed()) {
				System.out.println("Dashboard page is displayed");
				break dashboard;
			}else {
				Thread.sleep(1000);
			}
		}
		
		driver.findElement(By.xpath("//input[contains(@id,'PatientSearch')]")).sendKeys(patientName);
		
		driver.findElement(By.xpath("//a[contains(@id,'PatientSearch')]")).click();
		
		List<WebElement> results=driver.findElements(By.xpath("//tr[contains(@id,'rgResults')]/td/a"));
		System.out.println("No.of patient records : "+ results.size());
		for(WebElement res :results) {
			if(res.getText().contains(lastName)) {
				res.click();
			}
		}


	}
	
	public void sendnotification(WebDriver driver, String firstName,String notmessage) throws InterruptedException {
		driver.findElement(By.xpath("//textarea[contains(@name,'txtMessage')]")).sendKeys(notmessage);
		driver.findElement(By.xpath("//a[contains(@id,'SendMessageButton')]")).click();
		//List<WebElement> message=driver.findElements(By.xpath("//div[contains(@id,'rgMessages')]//tr[contains(@id,'rgMessages')]"));
		
		pageload:while(true) {
		if(driver.findElement(By.xpath("//div[contains(@id,'rgMessages')]//div[contains(text(),'"+notmessage+"')]")).isDisplayed()) {
			System.out.println("Message is successfuly sent from RMS customer portal");
			break pageload;
			}
		else {
			Thread.sleep(1000);
		}
		}
		
		
	}
}
