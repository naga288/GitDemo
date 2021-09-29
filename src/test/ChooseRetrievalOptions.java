package test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ChooseRetrievalOptions {
	
	
	public void screen2(WebDriver driver,String nbd,String rec_needed_for,String Auth_Phy,String pur_req) throws InterruptedException {
		/*screen2:while(true) {
			String retrievalOptions="//*[@id='retrievalOptions']";
			if(driver.findElement(By.id("retrievalOptions")).isDisplayed()) {
				System.out.println(driver.findElement(By.xpath("//div[contains(text(),'CHOOSE RETRIEVAL OPTIONS')]")).getText()+" Screen is displayed and USer is on Screen2");
				break screen2;	
			}else {
waits.WaitForElement(driver, retrievalOptions);
		}					
	}*/
		driver.findElement(By.xpath("//input[contains(@id,'ReqNeedByDate_dateInput')][@type='text']")).sendKeys(nbd);
		
		Select rnf=new Select(driver.findElement(By.xpath("//select[contains(@id,'NeededFor')]")));
		rnf.selectByVisibleText(rec_needed_for);
		
		driver.findElement(By.xpath("//input[contains(@id,'txtAuth')]")).sendKeys(Auth_Phy);
		
		Select por=new Select(driver.findElement(By.xpath("//select[contains(@id,'PurposeofRequest')]")));
		por.selectByVisibleText(pur_req);
		
		
		driver.findElement(By.xpath("//a[contains(@id,'btnNext')]")).click();
		List<WebElement> errelements=driver.findElements(By.cssSelector("div[id='retrievalOptions'] div[class='required'] span"));
		
		for(int i=0;i<errelements.size();i++) {
			if(errelements.get(i).isDisplayed()) {
				System.out.println(errelements.get(i).getText());
			}
		}

		
		if(errelements.isEmpty()) {
		screen3:while(true) {
			String upload="//div[contains(text(), 'Select file type to upload')]";
			if(driver.findElement(By.xpath(upload)).isDisplayed()) {
				System.out.println(" Retreival options are set and user can upload the files in next screen ");
				break screen3;	
			}else {
waits.WaitForElement(driver, upload);
		}
		}

		
	}
}
	
	/*testing git commits
	 */
	 */
}
