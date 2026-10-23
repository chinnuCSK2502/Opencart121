package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement link_MyAcount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement dropd_Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement dropd_Login;
	
	
	public void clickMyAccount()
	{
		WebDriverWait wait =
		        new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(
		        ExpectedConditions.elementToBeClickable(link_MyAcount)
		    ).click();
	}
	
	public void clickOnRegister()
	{
		dropd_Register.click();
	}
	public void clickOnLogin()
	{
		 WebDriverWait wait =
			        new WebDriverWait(driver, Duration.ofSeconds(10));

			    wait.until(
			        ExpectedConditions.visibilityOf(dropd_Login)
			    ).click();
	}
	
	

}
