package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
/*Data is valid-login success-test passed-logout
             -login unsucessful-test failed
Data is invalid-login success-test failed-logout
             -login unsucessful-test passed*/
          
public class TC003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		//logger.info("*********************** Started TC003_LoginDDT *****************************");
		
		
		try
		{
		//Homepage
		HomePage hp1=new HomePage(driver);
		hp1.clickMyAccount();
		Thread.sleep(3000);
		hp1.clickOnLogin();
		logger.info("Clicked on Login ");
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login datas.. ");
		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount Page
		MyAccountPage mc = new MyAccountPage(driver);
		boolean targetPage = mc.isMyAccountPageexist();
		
		
		/*Data is valid-login success-test passed-logout
                       -login unsucessful-test failed
        Data is invalid-login success-test failed-logout
                       -login unsucessful-test passed*/
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
                mc.clickLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				mc.clickLogOut();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
		
		//logger.info("*********************** Finished TC003_LoginDDT *****************************");
	}
	
	
	
	

}
