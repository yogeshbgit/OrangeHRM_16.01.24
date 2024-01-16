package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	By userName =  By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginbutton = By.xpath("//button[@type='submit']");
	
	
/*	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	*/

	public void enterUserName()
	{
		driver.findElement(userName).sendKeys("Admin");
	}
	
	public void enterPassword()
	{
		driver.findElement(password).sendKeys("admin123");
	}

	public void clickOnLogin()
	{
		driver.findElement(loginbutton).click();
	}
}
