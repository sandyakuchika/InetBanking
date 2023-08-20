package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteCustomerPage extends BasePage  {
	// Edit Customer Screen Page Objects
		
			@FindBy(how = How.LINK_TEXT, using = "Delete Customer")
			WebElement linkDeleteCustomer;
			
			@FindBy(how = How.NAME, using = "AccSubmit")
			private WebElement btnAccSubmit;

			@FindBy(how = How.NAME, using = "cusid")
			private WebElement custid;

			@FindBy(how = How.NAME, using = "res")
			private WebElement btnAccReset;

			public DeleteCustomerPage(WebDriver driver) {
				super(driver);
			}
			
			public void clickDeleteCustomer() {
				linkDeleteCustomer.click();
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
}
