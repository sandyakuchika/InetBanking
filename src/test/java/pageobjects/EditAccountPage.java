package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditAccountPage extends BasePage {

	public EditAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Edit Account")
	WebElement linkEditAccount;
	
	@FindBy(how = How.NAME, using ="accountno")
	WebElement accountNo;
	
	@FindBy(how=How.NAME, using= "AccSubmit")
	WebElement accSubmit;
	
	@FindBy(how=How.NAME, using= "reset")
	WebElement reset;

	public void clickLinkEditAccount() {
		linkEditAccount.click();
	}
	
	public void setAccountNo(String accNo) {
		accountNo.sendKeys(accNo);
	}
	
	public void clickAccSubmit() {
		accSubmit.click();
	}
	public void clickReset() {
		reset.click();
	}
}
