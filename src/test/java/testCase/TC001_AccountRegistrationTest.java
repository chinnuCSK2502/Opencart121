package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("***************  Starting TC001_AccountRegistrationTest  **********************");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info(" Clicked on My Account link");
		
		hp.clickOnRegister();
		logger.info(" Clicked on Register link");
		
		AccountRegistrationPage regis=new AccountRegistrationPage(driver);
		
		logger.info(" Providing customer details for  registration ");
		regis.setFirstName(randomString().toUpperCase());
		regis.setLastName(randomString().toUpperCase());
		regis.setEmail(randomString()+"@gmail.com");
		
		String password=randomAlpanaNumeric();
		
		regis.setPassword(password);
		regis.newsletter();
		regis.privacyPolicy();
		regis.continueSubmit();
		logger.info(" Validating expected message ");
		String confmsg=regis.registrationMsg();	
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
		    logger.error("Test Failed");
		    logger.debug("Debug logs");
			Assert.assertTrue(false);	
		}
		}
		catch(Exception e)
		{
			logger.error("Exception occurred: ", e);
		    Assert.fail("Test failed due to an exception", e);
		}
		
		logger.info("***************  Finished TC001_AccountRegistrationTest  **********************");
	}
	
}
