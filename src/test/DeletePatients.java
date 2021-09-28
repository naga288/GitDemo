package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeletePatients {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 	
		RMSLogin logrms=new RMSLogin();
		logrms.loginRMS(driver); // logging into RMS
		

		
			dashboard:while(true) {
				if(driver.findElement(By.xpath("//div[contains(@id,'RecordsTabPage')]")).isDisplayed()) {
					System.out.println("Dashboard page is displayed");
					break dashboard;
				}else {
					Thread.sleep(1000);
				}
			}
			
			driver.findElement(By.xpath("//input[contains(@id,'PatientSearch')]")).sendKeys("one test");
			
//			driver.findElement(By.linkText(" Search")).click();
		
			driver.findElement(By.xpath("//a[contains(@id,'PatientSearch')]")).click();
			
			List<WebElement> results=driver.findElements(By.xpath("//tr[contains(@id,'rgResults')]/td/a"));
			System.out.println("No.of patient records : "+ results.size());
			/*
			for(WebElement rec:results) {
			rec.click();
			
			details:while(true){
				if(driver.findElement(By.xpath("//span[contains(@id,'demographicsChangedValidator')]/..")).isDisplayed()) {
			System.out.println("Details tab is opened");
			break details;
				}
				else {
					Thread.sleep(1000);
				}
			}
			driver.findElement(By.cssSelector("button[value='Delete']")).click();
			driver.findElement(By.xpath("//div[@class='rwDialogButtons']/button[@type='button'][contains(text(),'Yes')]")).click();
			dashboard:while(true) {
				if(driver.findElement(By.xpath("//div[contains(@id,'RecordsTabPage')]")).isDisplayed()) {
					System.out.println("Dashboard page is displayed");
					break dashboard;
				}else {
					Thread.sleep(1000);
				}
			}
			}*/
			driver.findElement(By.xpath("//input[contains(@id,'PatientSearch')]")).sendKeys("one test");
			
			driver.findElement(By.xpath("//a[contains(@id,'PatientSearch')]")).click();
			
			List<WebElement> reslts=driver.findElements(By.xpath("//tr[contains(@id,'rgResults')]/td/a"));
			System.out.println("No.of patient records : "+ reslts.size());

	}

}
