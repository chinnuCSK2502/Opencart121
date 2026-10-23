package pageObjects;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div//h1[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//aside[@id='column-right']//a[normalize-space()='Logout']")
	WebElement logOut;
	
	public boolean isMyAccountPageexist()
	{
		try 
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogOut()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement logout = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//aside[@id='column-right']//a[normalize-space()='Logout']")
	        )
	    );

	    ((org.openqa.selenium.JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView({block:'center'});", logout);

	    ((org.openqa.selenium.JavascriptExecutor) driver)
	    .executeScript("arguments[0].click();", logout);
	}

}
