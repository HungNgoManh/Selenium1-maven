package testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Utilities;
import pages.HomePage;
import pages.RegisterPage;

public class TC07 extends TestBase {
	
	private HomePage homePage;
	private RegisterPage registerPage;

	@BeforeMethod
	// Init Register page webdriver before starting
	public void Initdriver() {

		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
	
	}

	@Test(description = "Check if user can create new account")
	public void TC_07() {
		/*
		 * Step 1: Init Login Page driver and start chrome were done in BeforeMethod.
		 */
		
		// Step 2: Click Register Tab
		homePage.clickTab(Constant.TAB_REGISTER);
		
		// Step 3: Enter valid information into all fields (Email, Pass, Confirm pass,
		// PID) and click Register button
		registerPage.RegisterNewUser(Utilities.EmailGenerator(), Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
		
		// VP: New account is created and message "Thank you for registering your
		// account" appears.
		Assert.assertEquals(registerPage.GetRegisterSuccessMessage(), Constant.MessageRegisterSuccess);
		
		// Print out new Email created.
		System.out.println(Constant.EMAIL_NEWLY_CREATE);
		
		/*
		 *  Post condition:
		 *  Active account
		 */
		 registerPage.ActiveEmail();
	}	
	 
}
