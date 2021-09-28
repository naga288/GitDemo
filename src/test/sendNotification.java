package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Ops.rmsOpsLogin;
import Ops.searchCase;
import Ops.searchCase2;
import test.OnlyReportIndexingRequest;

public class sendNotification {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String pname="Autotest 27-08-2021 16-07-57";
		String notifmessage = "test50";
		String lname="27-08-2021 16-07-57";
		String usname = "ehgt.test4";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		OnlyReportIndexingRequest dt=new OnlyReportIndexingRequest();
		
		RMSLogin login_rms = new RMSLogin();
		login_rms.loginRMS(driver); // logging into RMS
		
		searchRequest sreq = new searchRequest();
		String caseno = sreq.sr(driver, pname, lname);
		

		PatientSearch ps = new PatientSearch();

ps.sendnotification(driver, pname, notifmessage);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String senttime= dateFormat.format(date);
		 
		 WindowsHandle tab = new WindowsHandle();
			tab.tabhandling(driver, dt.opsurl);

			rmsOpsLogin opslogin = new rmsOpsLogin();
			opslogin.loginRMSops(driver);

			searchCase2 sc = new searchCase2();
		sc.opssearch(driver, caseno, notifmessage, senttime);
			tab.tabhandlingback(driver);
			ps.psch(driver, pname, lname);

		

		
	}

}
