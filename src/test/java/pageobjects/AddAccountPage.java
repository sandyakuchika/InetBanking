package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddAccountPage extends BasePage {

	public AddAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
		@FindBy(how = How.LINK_TEXT, using = "New Account")
		WebElement linkAddAccount;
		
		@FindBy(how = How.NAME, using ="cusid")
		WebElement cutomerId;
		
		@FindBy(how=How.NAME, using= "selaccount")
		WebElement selectAcc;
		
		@FindBy(how=How.NAME, using= "inideposit")
		WebElement initDeposit;
		
		@FindBy(how=How.NAME, using= "button2")
		WebElement accSubmit;
		
		@FindBy(how=How.NAME, using= "reset")
		WebElement reset;

		public void clickLinkAddAccount() {
			linkAddAccount.click();
		}
		
		public void setCustomerId(String cusId) {
			cutomerId.sendKeys(cusId);
		}
		public void setSelAccount(String type)
		{
			Select sel=new Select(selectAcc);
			sel.selectByVisibleText(type);
		}
		public void setInitDeposit(String initDepo) {
			initDeposit.sendKeys(initDepo);
		}
		public void clickAccSubmit() {
			accSubmit.click();
		}
		public void clickReset() {
			reset.click();
		}
		
}
