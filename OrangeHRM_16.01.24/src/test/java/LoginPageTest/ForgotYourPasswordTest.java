package LoginPageTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObject.ForgotYourPasswordObject;
import Resources.BaseRepo;

public class ForgotYourPasswordTest extends BaseRepo{

	public WebDriver driver;
	ForgotYourPasswordObject fpo;
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver=initialize();
	}
	
	@Test(priority=0)
	public void validateForgotPasswordLink()
	{
		fpo =new  ForgotYourPasswordObject(driver);
		fpo.clickOnForgotPasswordLink();
		
		
	}
	

}


