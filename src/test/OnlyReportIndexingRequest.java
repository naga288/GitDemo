package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Ops.rmsOpsLogin;
import Ops.searchCase;

public class OnlyReportIndexingRequest {
	public static String firstName = "Autotest ";
	public static String lastName;
	public static String dob = "8/4/1990";
	public static String streetAdd = "Test";
	public static String city = "New York";
	public static String postalCode = "10001";
	public static String SSN = "987456321";
	public static String phnum = "9874563121";
	public static String nbd = "9/15/2021";
	public static String rec_needed_for = "Appointment";
	public static String Auth_Phy = "Dr.AnandKumar";
	public static String pur_req = "New Patient Consultation";
	public static String filetype = "Records";
	public static String notmessage = "Test notification from RMS";
	public static String caseno;
	public static String patientName;
	public static String searchtxt;
	public static String opsurl = "http://rmstest.ehealthcorp.net:8021/";
	public static String username = "ehgt.test4";
	public static String pwd="Kick4Thy";

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagababu.parepalli\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RMSLogin login_rms = new RMSLogin();
		login_rms.loginRMS(driver); // logging into RMS

		ReportsIndexRequest ir = new ReportsIndexRequest();
		String lastName = ir.RIR(driver, firstName, dob, streetAdd, city, postalCode, phnum, SSN);

		patientName = firstName + lastName;
		System.out.println("Patient name : " + patientName);

		ChooseRetrievalOptions cro = new ChooseRetrievalOptions();
		cro.screen2(driver, nbd, rec_needed_for, Auth_Phy, pur_req);

		UploadFiles uf = new UploadFiles();
		uf.screen3(driver, filetype);

		searchRequest sreq = new searchRequest();
		String caseno = sreq.sr(driver, patientName, lastName);
		System.out.println("the caseno  for the request is : " + caseno);
		System.out.println("Patient name : " + patientName);

		PatientSearch ps = new PatientSearch();

		ps.sendnotification(driver, patientName, notmessage);

		WindowsHandle tab = new WindowsHandle();
		tab.tabhandling(driver, opsurl);

		rmsOpsLogin opslogin = new rmsOpsLogin();
		opslogin.loginRMSops(driver);

		searchCase sc = new searchCase();
		sc.opssearch(driver, caseno, notmessage);

		tab.tabhandlingback(driver);
		ps.psch(driver, patientName, lastName);

		// RMSLogout logout_rms=new RMSLogout();
		// logout_rms.logout(driver);
	}

}
