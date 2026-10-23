package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verfyLogin()
	{
		logger.info("************* Starting TC002_LoginTest ********************");
		
		try
		{
		//Homepage
		HomePage hp1=new HomePage(driver);
		hp1.clickMyAccount();
		hp1.clickOnLogin();
		logger.info("Clicked on Login ");
		
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login datas.. ");
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount Page
		MyAccountPage mc = new MyAccountPage(driver);
		boolean targetPage = mc.isMyAccountPageexist();
		
		Assert.assertEquals(targetPage, true, "Login Failed");
		//Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************* Finished TC002_LoginTest ********************");
		
		
	}
	

}
