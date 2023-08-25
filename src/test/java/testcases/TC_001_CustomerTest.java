package testcases;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AddCustomerPage;
import pageobjects.DeleteCustomerPage;
import pageobjects.EditCustomerPage;
import pageobjects.LoginPage;
import utilities.CaptureLogs;

public class TC_001_CustomerTest extends BaseTest {

	@Test(enabled = false, priority = 1)
	public void loginTest() throws InterruptedException {
		CaptureLogs.autoLogs("LoginTest").info("LoginTest Started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		Thread.sleep(3000);
		String homePageTitle = driver.getTitle();
		if (homePageTitle.contains("Guru99 Bank Manager HomePage")) {
			CaptureLogs.autoLogs("LoginTest").info("Login Test Passed");
			Assert.assertTrue(true);
		} else {
			CaptureLogs.autoLogs("LoginTest").info("Login Test failed");
			Assert.fail("Invalid Login Detals");
		}

	}

	@Test(enabled = false, priority = 2)
	public void linksCountTest() throws InterruptedException {
		CaptureLogs.autoLogs("LinkCountTEst").info("LinksCountTest Started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//ul[@class='menusubnav']//li"));

		System.out.println(links.size());
		if (links.size() == 15) {
			CaptureLogs.autoLogs("LinksCountTest").info("Links Count Test Passed");
			Assert.assertTrue(true);
		} else {
			CaptureLogs.autoLogs("LinksCountTest").info("LinksCoun Test failed");
			Assert.fail();
		}
	}

	@Test(enabled = true, priority = 3)
	public void addNewCustomer() throws InterruptedException {
		CaptureLogs.autoLogs("AddNewCustomer").info("AddNewCustomerTest Started");
		AddCustomerPage addNew = new AddCustomerPage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addNew.clickAddNewCustomer();

		addNew.setCustmerName("Radya");
		addNew.setRdGender("f");
		WebElement dob = driver.findElement(By.name("dob"));
		// dob.sendKeys("14");
		// dob.sendKeys(Keys.TAB);
		// dob.sendKeys("Jun");
		// dob.sendKeys(Keys.TAB);
		dob.sendKeys(Keys.CLEAR);
		dob.sendKeys("2002");
		dob.sendKeys(Keys.TAB);
		dob.sendKeys("2023");
		// addNew.setTxtDob("1421983");
		addNew.setTxtAddress("Tenali");
		addNew.setTxtCity("Guntur");
		addNew.setTxtPinNo("999999");
		addNew.setTxtState("AP");
		String randomString = RandomStringUtils.randomAlphanumeric(10);
		addNew.setTxtEmailId(randomString + "@gmail.com");
		addNew.setTxtTelePhoneNo("000000");
		addNew.setTxtPassword("password");

		addNew.setBtnSubmit();

		List<WebElement> errors = driver
				.findElements(By.xpath("//label[contains(@id,'message') and contains(@style, 'visible')]"));
		if (errors.size() > 0) {
			CaptureLogs.autoLogs("Add New customer Fail").info("Add Customer Test Failed " + errors.size());
			for (WebElement e : errors) {
				CaptureLogs.autoLogs("Add New customer Fail").info(e.getAttribute("id") + " " + e.getText());
			}
			Assert.fail();
		} else {
			if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				custId = driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]")).getText();
				CaptureLogs.autoLogs("Added New customer").info(custId);
				Assert.assertTrue(true);
			} else {
				CaptureLogs.autoLogs("Add New customer Fail")
						.info("Add New Cutomer Test Failed Thogh validation errors passed");
				Assert.fail();
			}
		}
	}

	@Test(enabled = true, priority = 4)
	public void editCustomerTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		CaptureLogs.autoLogs("EditNewCustomer").info("EditCustomer Started");
		EditCustomerPage editCust = new EditCustomerPage(driver);

		editCust.clickEditCustomer();
		editCust.setCustId(custId);
		editCust.clickAccSubmit();
		// editCust.setRdGender("m");
		editCust.clickBtnSubmit();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		if (alertText.contains("No Changes")) {
			CaptureLogs.autoLogs("EditCustomer Success").info(custId);
			Assert.assertTrue(true);
		} else {
			CaptureLogs.autoLogs("EditCustomer fail").info(custId);
			Assert.assertTrue(false);
		}

	}

	@Test(enabled = false, priority = 5)
	public void deleteCustomerTest() throws InterruptedException {
		CaptureLogs.autoLogs("Delete").info("Delete Customer Started");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DeleteCustomerPage deletePage = new DeleteCustomerPage(driver);
		deletePage.clickDeleteCustomer();
		deletePage.setCustId(custId);
		deletePage.clickAccSubmit();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();
		CaptureLogs.autoLogs("Delete Customer Success").info(custId);
		Assert.assertTrue(true);
	}

}
