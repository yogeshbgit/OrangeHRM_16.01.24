package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPasswordObject {

	public WebDriver driver;
	
	public ForgotYourPasswordObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".orangehrm-login-forgot-header")
	WebElement forgotPasswordLink;
	



	public void clickOnForgotPasswordLink()
	{
		forgotPasswordLink.click();
	}

	
}
