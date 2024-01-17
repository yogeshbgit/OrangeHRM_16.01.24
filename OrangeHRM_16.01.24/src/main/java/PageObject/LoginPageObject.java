package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	public WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	WebElement loginText;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	WebElement companyBrandingLogo;
	
	@FindBy(xpath="//img[@alt='orangehrm-logo']")
	WebElement orangehrmLogo;

	
	@FindBy(xpath="(//label[@class='oxd-label'])[1]")
	WebElement usernameLabel;
	 
	@FindBy(xpath="(//label[@class='oxd-label'])[2]")
	WebElement passwordLabel;
	
	
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//p[contains(.,'Username')]")
	WebElement getuserName;
	
	@FindBy(xpath="//p[contains(.,'Password')]")
	WebElement getpassword;

	public String getLoginText()
	{
		return loginText.getText();
		 
	}
	
	public String getCompanyBrandingLogo()
	{
		return companyBrandingLogo.getAttribute("src");
	}
	
	public String getOrangehrmLogo()
	{
	  return orangehrmLogo.getAttribute("src");
	}
	
	public String getusernameLabel()
	{
		return usernameLabel.getText();
	}
	
	public String getpasswordLabel()
	{
		return passwordLabel.getText();
	}
	
	
	
	
	public void enterUserName()
	{
		String sysUserName = getuserName.getText().split(":")[1].trim();
		userName.sendKeys(sysUserName);
	}
	
	public void enterPassword()
	{
		String sysPassword = getpassword.getText().split(":")[1].trim();
		password.sendKeys(sysPassword);
	}

	public void clickOnLogin()
	{
		login.click();
	}
}
