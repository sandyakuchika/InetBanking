package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCustomerPage extends BasePage  {

	// AddCustomer Screen Page Objects
		@FindBy(how = How.LINK_TEXT, using = "Edit Customer")
		WebElement linkEditCustomer;

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

		@FindBy(how = How.NAME, using = "AccSubmit")
		private WebElement btnAccSubmit;

		@FindBy(how = How.NAME, using = "cusid")
		private WebElement custid;

		@FindBy(how = How.NAME, using = "res")
		private WebElement btnAccReset; 

		public EditCustomerPage(WebDriver driver) {
			super(driver);
		}

		public void clickEditCustomer() {
			linkEditCustomer.click();
		}
		
		public void setCustId(String cid) {
			custid.sendKeys(cid);
		}
		
		public void clickAccSubmit() {
			btnAccSubmit.click();
		}
		public void clickAccReset() {
			btnAccReset.click();
		}

		public void setCustmerName(String customerName) {
			txtCustmerName.clear();
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
			txtDob.clear();
			txtDob.sendKeys(cDob);
		}

		public void setTxtAddress(String cAddress) {
			txtAddress.clear();
			txtAddress.sendKeys(cAddress);
		}

		public void setTxtCity(String cCity) {
			txtCity.clear();
			txtCity.sendKeys(cCity);
		}

		public void setTxtState(String cState) {
			txtState.clear();
			txtState.sendKeys(cState);
		}

		public void setTxtPinNo(String cPinNo) {
			txtPinNo.clear();
			txtPinNo.sendKeys(cPinNo);
		}

		public void setTxtTelePhoneNo(String cTelePhoneNo) {
			txtTelePhoneNo.clear();
			txtTelePhoneNo.sendKeys(cTelePhoneNo);
		}

		public void setTxtEmailId(String cEmailId) {
			txtEmailId.clear();
			txtEmailId.sendKeys(cEmailId);
		}

		public void setTxtPassword(String cPassword) {
			txtPassword.clear();
			txtPassword.sendKeys(cPassword);
		}

		public void clickBtnSubmit() {
			btnSubmit.click();
		}

}
