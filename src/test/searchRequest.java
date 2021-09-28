package test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchRequest {
/*	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		//ReportsIndexRequest rr=new ReportsIndexRequest();
		RMSLogin login_rms=new RMSLogin();
		login_rms.loginRMS(driver); // logging into RMS	
		String lname="17-08-2021 17-30-48";
	*/
	
	public String sr(WebDriver driver, String patientName, String lastName) throws InterruptedException {
		dashboard:while(true) {
			String dashboard="//div[contains(@id,'RecordsTabPage')]";
			driver.findElement(By.xpath(dashboard)).click();
			if(driver.findElement(By.xpath(dashboard)).isDisplayed()) {
				System.out.println("Dashboard page is displayed");
				break dashboard;
			}else {
waits.WaitForElement(driver, dashboard);
}
		}
		
		driver.findElement(By.xpath("//input[contains(@id,'PatientSearch')]")).sendKeys(patientName);
		
//		driver.findElement(By.linkText(" Search")).click();
	
		driver.findElement(By.xpath("//a[contains(@id,'PatientSearch')]")).click();
		
		List<WebElement> results=driver.findElements(By.xpath("//tr[contains(@id,'rgResults')]/td/a"));
		System.out.println("Seacrh completed. No.of patient records found: "+ results.size());
		
		for(WebElement res :results) {
			if(res.getText().contains(lastName)) {
				res.click();
			}
		}
		
		patdigest:while(true) {
			String digest="//div[contains(@id,'IntakeGrid_rgRecords')]";
			if(driver.findElement(By.xpath(digest)).isDisplayed()) {
				System.out.println("patient digest page is displayed");
				
				break patdigest;
			}else {
waits.WaitForElement(driver, digest);
			}
		}
		String casetxt=driver.findElement(By.xpath("//div[contains(@id,'IntakeGrid_rgRecords')]//h5/small")).getText();
		
//		System.out.println(casetxt);
		caseno:while(true) {
			if(casetxt.contains("Submitting")) {
				driver.navigate().refresh();
				Thread.sleep(5000);
			}else
			{
				break caseno;
			}
		}
		String[] arrSplit = casetxt.split("\\s");
	/*	for(int i=0;i<arrSplit.length;i++) {
			System.out.println(arrSplit[i]);
		}*/
		
		////tr[@class='rgNoRecords']//div[contains(text(),'No records to display')]
		String casetxt3=arrSplit[2];
		StringBuffer cno= new StringBuffer(casetxt3);  
		//invoking the method  
		cno.deleteCharAt(cno.length()-1);  
		//prints the string after deleting the character   
		//System.out.println("The case no.of the request is : "+cno);
		String caseno = cno.toString();
		return caseno;  	     
	}

}
