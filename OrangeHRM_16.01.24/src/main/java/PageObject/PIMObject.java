package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMObject {

	public WebDriver driver;
	
	public PIMObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='PIM']")
	WebElement pim;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[2]")
	WebElement supervisorName;
	
	@FindBy(xpath="//div[@role='listbox']/div/span")
	List<WebElement> supervisorList;
	
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][3]")
	List<WebElement> availableSupervisorList;

	public void clickOnPIM()
	{
		pim.click();
	}
	
	public void enterSupervisorName(String supervisorname)
	{
		supervisorName.sendKeys(supervisorname);
	}
	
	
	public List<String> getAvailableSupervisorList()
	{
		List<String> list = new ArrayList();
		for(WebElement l:availableSupervisorList)
		{
			list.add(l.getText());
		}
		
		return list;
		
	}
	
	public List<WebElement> getSupervisorList()
	{
		return supervisorList;
	}
}
