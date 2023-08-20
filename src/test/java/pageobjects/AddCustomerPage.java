package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage  {
	
	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	WebElement linkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustmerName;

	@FindBy(how = How.NAME, using = "radi")
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtDob;

	@FindBy(how = How.NAME, using = "addr")
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txtTelePhoneNo;

	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtEmailId;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public AddCustomerPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}

	public void setCustmerName(String customerName) {
		txtCustmerName.sendKeys(customerName);
	}

	public void setRdGender(String gender) {
		WebElement element=driver.findElement(By.xpath("//INPUT[@value='"+gender+"']"));
		if(element.isDisplayed() && !element.isSelected()) {
			element.click();
		}
		//rdGender.click();
	}

	public void setTxtDob(String cDob) {
		txtDob.sendKeys(cDob);
	}

	public void setTxtAddress(String cAddress) {
		txtAddress.sendKeys(cAddress);
	}

	public void setTxtCity(String cCity) {
		txtCity.sendKeys(cCity);
	}

	public void setTxtState(String cState) {
		txtState.sendKeys(cState);
	}

	public void setTxtPinNo(String cPinNo) {
		txtPinNo.sendKeys(cPinNo);
	}

	public void setTxtTelePhoneNo(String cTelePhoneNo) {
		txtTelePhoneNo.sendKeys(cTelePhoneNo);
	}

	public void setTxtEmailId(String cEmailId) {
		txtEmailId.sendKeys(cEmailId);
	}

	public void setTxtPassword(String cPassword) {
		txtPassword.sendKeys(cPassword);
	}

	public void setBtnSubmit() {
		btnSubmit.click();
	}

}
