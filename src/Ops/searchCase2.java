package Ops;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void opssearch(WebDriver driver, String caseno, String notmessage, String senttime) throws InterruptedException {
		System.out.println("Searching for Case no : " + caseno);
		driver.findElement(By.xpath("//input[contains(@id,'txtSearch')]")).sendKeys(caseno);
		driver.findElement(By.cssSelector("input[value='Go']")).click();
		driver.findElement(By.xpath("//div[contains(@id,'gvSSPackages_pPackageItem')]/a[contains(text(),'Case #')]"))
				.click();

		casedetails: while (true) {
			if (driver.findElement(By.xpath("//div[contains(@id,'Messages')]")).isDisplayed()) {
				System.out.println("case # " + caseno + " deatils are opened");
				break casedetails;
			} else {
				Thread.sleep(1000);
			}
		}

		List<WebElement> msgs = driver
				.findElements(By.xpath("//div[contains(@id,'gvMessages')]//span[contains(@id,'MsgBody')]"));
		for (WebElement msg : msgs) {

			String msgtxt = msg.getText();
			if (msgtxt.equals(notmessage)  ) {

				System.out.println(" Message from RMS v2 : " + notmessage
						+ "  is recevied and displayed on rmsOps case deatils page");
				/*
				 * if(opstimestamp.equals(rmstimestamp)){
				 * System.out.println(" Message from RMS v2 : "
				 * +notmessage+"  is recevied and displayed on rmsOps case deatils page"); }
				 * 
				 */
			}
		}

	}
}
