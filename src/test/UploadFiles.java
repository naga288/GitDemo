package test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFiles {
public void screen3(WebDriver driver,String filetype) throws InterruptedException, IOException {
	/*screen3:while(true) {
		if(driver.findElement(By.xpath("//div[contains(text(), 'Select file type to upload')]")).isDisplayed()) {
			System.out.println(" Retreical options re set and user can upload the files in Screen3 ");
			break screen3;	
		}else {
			Thread.sleep(1000);
	}
	}*/
	driver.findElement(By.xpath("//input[@value='Select']/parent::span")).click();
	List<WebElement> options = driver.findElement(By.xpath("//div[contains(@id,'FileType_DropDown')]//ul")).findElements(By.tagName("li"));
	for (WebElement option : options)
	{
		//System.out.println(option.getText());
	    if (option.getText().equals(filetype))
	    {
	        option.click(); // click the desired option
	        String loc=option.toString();
	        break;
	    }else {
	    	Thread.sleep(1000);
	    	//waits.WaitForElement(driver, loc);
	    	//WebDriverWait wait = new WebDriverWait(driver,2);
	    	//wait.until(ExpectedConditions.visibilityOfElementLocated(option));
	    }
	}
	
	Thread.sleep(3000);
	
	
	System.out.println("The 'Request Indexing' chcekbox should not be displayed and the check should be false :  "+driver.findElement(By.xpath("//button[contains(@name,'chkIndexing')]")).isSelected());
	
	
driver.findElement(By.xpath("//input[contains(@id,'Upload1file0')]/..")).click();
Thread.sleep(5000);


Runtime.getRuntime().exec("C:\\Users\\nagababu.parepalli\\Documents\\Autoit\\fileuploadscript.exe");


//driver.findElement(By.xpath("//table[@id='dataTable']//tr")).getSize();

//Thread.sleep(10000);


Fileupload:while(true) {
	if(driver.findElement(By.xpath("//button[contains(@name,'chkIndexing')]/span[contains(@class,'ToggleCheckboxChecked')]")).isDisplayed()) {
		
		List<WebElement> rprts=driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr/td/a"));
		
		System.out.println("No.of reports uploaded : " +rprts.size());
		break Fileupload;
	}else {
		Thread.sleep(1000);
	}
}

driver.findElement(By.xpath("//a[contains(@id,'btnNext')]")).click();

providerscreen:while(true) {
	if(driver.findElement(By.cssSelector("input[value='Recent Providers List']")).isDisplayed()) {
		System.out.println("Provider screen is displayed");
		break providerscreen;
	}else {
		Thread.sleep(1000);
	}
}

System.out.println("Request indexing toggle is off? : "+driver.findElement(By.xpath("//button[contains(@class,'k-switch-off')]")).isDisplayed());

driver.findElement(By.xpath("//button[contains(@name,'IndexOnlySwitch')]")).click();



switchloop:while(true) {
	
if(driver.findElement(By.xpath("//button[contains(@class,'k-switch-on')]")).isDisplayed()) {
	
	System.out.println(driver.findElement(By.xpath("//button[contains(@name,'IndexOnlySwitch')]/following-sibling::label")).getText()+" toggle is enabled");
	break switchloop;
}else {
Thread.sleep(1000);	
}
}

driver.findElement(By.xpath("//a[contains(@id,'btnSubmit')]")).click();

Thread.sleep(5000);

JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement Element = driver.findElement(By.className("footer"));

js.executeScript("arguments[0].scrollIntoView();", Element);



subreq:while(true) {
	if(driver.findElement(By.xpath("//a[contains(text(),'Submit Request ')]")).isDisplayed()) {
		
		driver.findElement(By.xpath("//a[contains(text(),'Submit Request ')]")).click();
		System.out.println("Reports For Indexing request is submitted");
		break subreq;
	}else {
		Thread.sleep(1000);
	}
}





submitrequest:while(true) {
	if(driver.findElement(By.linkText("Done")).isDisplayed()) {
		driver.findElement(By.linkText("Done")).click();
		break submitrequest;
	}else {
		Thread.sleep(1000);
	}
}

}
}
