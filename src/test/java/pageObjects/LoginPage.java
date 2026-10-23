package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-password")
	WebElement txtpwd;
	
	@FindBy(xpath="//div//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	public void setEmailAddress(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String passwd)
	{
		txtpwd.sendKeys(passwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

}
