package Common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmailTests {
	
	  private static EmailUtils emailUtils;
	  WebDriver driver;

	@BeforeTest
	  public static void connectToEmail() {
	    try {
	      emailUtils = new EmailUtils("hung.ngo.test@gmail.com", "Matkhau~1", "smtp.gmail.com", EmailUtils.EmailFolder.INBOX);
	    } catch (Exception e) {
	      e.printStackTrace();
	      Assert.fail(e.getMessage());
	    }
	  }
	  
	@Test
	  public void testVerificationCode() {
	    try {
	      //TODO: Execute actions to send verification code to email

	      String verificationCode = emailUtils.getAuthorizationCode();

	      //TODO: Enter verification code on screen and submit
	      //String CurrentString = "Fruit = they taste good";
	      String[] separated = verificationCode.split(". ");
	      
	      String finalcode = separated[0].trim();
	      // this will contain "Fruit"
	      //this will contain "they teste good"
	      System.out.println(finalcode);
    

	      //TODO: add assertions

	    } catch (Exception e) {
	      e.printStackTrace();
	      Assert.fail(e.getMessage());
	    }
	  }
	  
	
}
