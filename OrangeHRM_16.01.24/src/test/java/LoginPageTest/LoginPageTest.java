package LoginPageTest;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import Resources.BaseRepo;
import junit.framework.Assert;

public class LoginPageTest extends BaseRepo{
	public  WebDriver driver;
	LoginPageObject lpo;
	
	
	@BeforeTest()
	public void setup() throws IOException
	{
		driver= initialize();
		
	}
	
	
	@Test(priority=0)
	public void validateCompanyLogo()
	{
		lpo = new LoginPageObject(driver);
		String expectedsrc = "https://opensource-demo.orangehrmlive.com/web/images/ohrm_branding.png?v=1689053487449";
		String actualsrc = lpo.getCompanyBrandingLogo();
		//System.out.println("expected: "+expectedsrc);
		//System.out.println("actual: "+actualsrc);
		Assert.assertEquals(expectedsrc, actualsrc);
	}
	
	@Test(priority=1) 
	public void validateLoginTittle()
	{
		String expectedLoginText = "Login";
		String actualLoginText = lpo.getLoginText();
		Assert.assertEquals(expectedLoginText, actualLoginText );
	}
	
	@Test(priority=2)
	public  void validateOrangeHRMLogo()
	{
		String expectedLogo = "https://opensource-demo.orangehrmlive.com/web/images/ohrm_logo.png";
		String actualLogo = lpo.getOrangehrmLogo();
		Assert.assertEquals(expectedLogo, actualLogo);
	}
	
	@Test(priority=3)
	public void validateUsernameLabelAndPasswordLabel()
	{
		Assert.assertEquals("Username", lpo.getusernameLabel());
		Assert.assertEquals("Password", lpo.getpasswordLabel());
	}
	
	

	@Test(priority=4)
	public void validateLogin() throws InterruptedException
	{
		lpo = new LoginPageObject(driver);
		lpo.enterUserName();
		lpo.enterPassword();
		lpo.clickOnLogin();
		HomePageObject hpo = new HomePageObject(driver);
		Assert.assertTrue(hpo.getProfilePicture());
	}
	
	@AfterTest()
	public void browserCloser()
	{
		driver.close();
	}

}
