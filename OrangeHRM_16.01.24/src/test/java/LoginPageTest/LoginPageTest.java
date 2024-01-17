package LoginPageTest;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObject.LoginPageObject;
import Resources.BaseRepo;

public class LoginPageTest extends BaseRepo{
	public  WebDriver driver;
	LoginPageObject lpo;
	
	
	@BeforeTest()
	public void setup() throws IOException
	{
		driver= initialize();
		
	}
	
	@Test(priority=0)
	public void validateLogin() throws InterruptedException
	{
		lpo = new LoginPageObject(driver);
		lpo.enterUserName();
		lpo.enterPassword();
		lpo.clickOnLogin();
	}
	
	@AfterTest()
	public void browserCloser()
	{
		driver.close();
	}

}
