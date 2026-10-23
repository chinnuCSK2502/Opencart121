package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txt_fname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txt_lname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(name="password")
	WebElement txt_pwd;
	
	@FindBy(css = "input#input-newsletter.form-check-input")
	WebElement check_nletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement check_ppolicy;
	
	@FindBy(css=".btn.btn-primary")
	WebElement btn_continue;
	
	@FindBy(xpath="//div/h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_registration;
	
	public void setFirstName(String fname)
	{
		txt_fname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_lname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	private void selectCheckbox(WebElement checkbox) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});",checkbox);

	    if (!checkbox.isSelected()) 
	    {
	        js.executeScript("arguments[0].click();", checkbox);
	    }

	    Assert.assertTrue(checkbox.isSelected(),"Checkbox was not selected");
	}
	
	public void newsletter()
	{
		selectCheckbox(check_nletter); 
	}
	
	public void privacyPolicy()
	{
		selectCheckbox(check_ppolicy); 
	}
	
	public void continueSubmit()
	{
		btn_continue.click();
	}
	
	public String registrationMsg()
	{
		return msg_registration.getText();
	}
	
	
	
	
	
	
	
	
	
	

}
