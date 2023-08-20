package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	// Login Screen Page Objects

	@FindBy(how = How.NAME, using = "uid")
	WebElement txtUserName;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "btnLogin")
	WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLoginBtn() {
		btnLogin.click();
	}

}
