package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AddAccountPage;
import pageobjects.EditAccountPage;
import pageobjects.LoginPage;
import utilities.CaptureLogs;

public class TC_002_AccountTest extends BaseTest {

	@Test
	public void testAddAccount() {
		CaptureLogs.autoLogs("Add Account").info("Account add started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AddAccountPage aap = new AddAccountPage(driver);
		aap.clickLinkAddAccount();
		if (!driver.getPageSource().contains("Add new account form")) {
			CaptureLogs.autoLogs(custId + "Add Account").info("Add Accout link not found");
			Assert.fail();
		}
		aap.setCustomerId(custId);
		aap.setSelAccount("Savings");
		aap.setInitDeposit("10000");
		aap.clickAccSubmit();

		if (driver.getPageSource().contains("Account Generated Successfully!!!")) {
			accountId = driver.findElement(By.xpath("//*[@id='account']/tbody/tr[4]/td[2]")).getText();
			CaptureLogs.autoLogs("Added New new Account for the customer").info(custId + ":" + accountId);
			Assert.assertTrue(true);
		} else {
			CaptureLogs.autoLogs("Add New Account for the customer Failed")
					.info("Add New Cutomer Test Failed Thogh validation errors passed");
			Assert.fail();
		}
	}

	@Test
	public void testEditAccount() {
		CaptureLogs.autoLogs("Edit Account").info("Edit account started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		EditAccountPage eap = new EditAccountPage(driver);
		eap.clickLinkEditAccount();
//		if (!driver.getPageSource().contains("Edit Account form")) {
//			CaptureLogs.autoLogs(custId + "Edit Account").info("Edit Account link not found");
//			Assert.fail();
//		}
		eap.setAccountNo(accountId);
		eap.clickAccSubmit();
	}

}
