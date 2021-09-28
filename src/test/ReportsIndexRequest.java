package test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportsIndexRequest {

	public String element= "//div[@class='topblue']/span[contains(text(),'PATIENT DEMOGRAPHICS')]";
	public String RIR(WebDriver driver,String firstName, String dob,String streetAdd,String city,String postalCode, String phnum,String SSN  ) throws InterruptedException {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 String lName=date1;
		
		driver.findElement(By.xpath("//a[text()=' Add New Patient']")).click();
		newrequestblock:while(true){
			if(driver.findElement(By.xpath(element)).isDisplayed()) {
		System.out.println("New patient request tab is opened");
		break newrequestblock;
			}
			else {
waits.WaitForElement(driver, element);
}
		}
			
			System.out.println("Checking for existing  Patient profiles");
			driver.findElement(By.xpath("//div[contains(text(),'First Name')]/following::input")).sendKeys(firstName);
			driver.findElement(By.xpath("//div[contains(text(),'Last Name')]/following::input")).sendKeys(date1);
			driver.findElement(By.id("MainContent_cphAuth_btnPatientNext")).click();
			
					newPatientblock:while(true){
						String Reconciliation="//div/h3[contains(text(),'Patient Reconciliation')]";
						if(driver.findElement(By.xpath(Reconciliation)).isDisplayed()) {
					System.out.println("patient profiles tab is opened");
					break newPatientblock;
						}
						else {
	waits.WaitForElement(driver, Reconciliation);
						}
					}
						
					driver.findElement(By.xpath("//a[contains(@id, 'PatientReconciliation1_btnCreate')]")).click();
					requestblock:while(true){
						if(driver.findElement(By.cssSelector("div[class='topblue']")).isDisplayed()) {
					System.out.println("Creating a new patient profile");
					break requestblock;
						}
						else {
							Thread.sleep(1000);
						}
					}
						
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[contains(@id,'SSN')]")).click();
					driver.findElement(By.xpath("//input[contains(@id,'SSN')]")).sendKeys(SSN);
					driver.findElement(By.xpath("//input[contains(@id,'rdpDOB_dateInput')]")).sendKeys(dob);
					driver.findElement(By.xpath("//input[@id[substring(.,string-length(.) - string-length('txtAdd1') + 1) = 'txtAdd1']]")).sendKeys(streetAdd);
					driver.findElement(By.xpath("//span[contains(@id,'txtCity_wrapper')]/input[@type='text']")).sendKeys(city);
					Select patcity=new Select(driver.findElement(By.xpath("//select[contains(@id,'ddlState')]")));
					patcity.selectByVisibleText(city);
					driver.findElement(By.xpath("//input[contains(@id,'txtPostal')]")).sendKeys(postalCode);
					
					driver.findElement(By.xpath("//input[contains(@id,'txtPhone')]")).click();
					driver.findElement(By.xpath("//input[contains(@id,'txtPhone')]")).sendKeys(phnum);
					
					Select dept=new Select(driver.findElement(By.xpath("//select[contains(@id,'ddlDepartment')]")));
					dept.selectByVisibleText("Dept A");
					driver.findElement(By.cssSelector("button[value='Next']")).click();
					List<WebElement> errelements=driver.findElements(By.xpath("//div[contains(@id,'Panel1')]//span[@style='display: inline;']"));
					
					
					for(int i=0;i<errelements.size();i++) {
						if(errelements.get(i).isDisplayed()) {
							System.out.println(errelements.get(i).getText());
						}
					}
					
					if(errelements.isEmpty()) {
					screen2:while(true) {
						String retrievalOptions="//*[@id='retrievalOptions']";
						if(driver.findElement(By.id("retrievalOptions")).isDisplayed()) {
							System.out.println(driver.findElement(By.xpath("//div[contains(text(),'CHOOSE RETRIEVAL OPTIONS')]")).getText()+" Screen is displayed");
							break screen2;	
						}else {
waits.WaitForElement(driver, retrievalOptions);
					}
					}
	}

					return lName;
		
	}
	
	@DataProvider
	public void getData() {
		
	}
	
	
}

