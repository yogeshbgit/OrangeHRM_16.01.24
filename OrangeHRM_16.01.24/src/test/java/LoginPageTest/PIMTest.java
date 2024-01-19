package LoginPageTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import PageObject.PIMObject;
import Resources.BaseRepo;
import junit.framework.Assert;

public class PIMTest extends BaseRepo {
	
	public WebDriver driver;
	PIMObject pim;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		driver = initialize();
		login();
	}
	 
	@Test(priority=0)
	public void validateSupervisorSearch() throws InterruptedException
	{
		pim = new PIMObject(driver);
		pim.clickOnPIM();
		List<String>availableSupervisorList = pim.getAvailableSupervisorList();
		int supervisorIndex = availableSupervisorList.size()-3;
		System.out.println("available list size:"+availableSupervisorList.size());
		String serachedSupervisor = "";
		if(availableSupervisorList.size()>0)
		{
			for(int i=0;i<availableSupervisorList.size();i++)
			{
				i=supervisorIndex; 
				pim.enterSupervisorName(availableSupervisorList.get(i));
				Thread.sleep(2000);
				serachedSupervisor=availableSupervisorList.get(i);
				System.out.println("serached Supervisor:"+serachedSupervisor);
				List<WebElement> list = pim.getSupervisorList();
				boolean result = false;
				for(int j=0;j<list.size();j++)
				{
					if(list.get(j).getText().contains(availableSupervisorList.get(i)))
					{
						System.out.println("Selected Supervisor:"+list.get(j).getText());
						list.get(j).click();
						result = true;
						break;
					}	
				}
				if(result==true)
				{
					break;
				}
			}
		}
		else
		{
			System.out.println("No Record Found");
			Assert.assertTrue(false);
		}
		
		pim.clickOnSearchButton();
		List<String> afterSearchList  = pim.getAvailableSupervisorList();
		if(afterSearchList.size()>0)
		{
			for(String n:afterSearchList)
			{
			
				if(n.equals(serachedSupervisor))
				{
					System.out.println("After Search List Supervisor:"+n);
					
				}
				else
				{
					System.out.println("No Record Found");
					Assert.assertTrue(false);
				}
			
			}
		}
		else
		{
			System.out.println("After Search : No Record Found");
		
		}
			
		
		
		
		
		
	}
	
	//for login only
	public void login() throws InterruptedException
	{
		LoginPageTest lpt = new LoginPageTest();
		lpt.driver=driver;
		lpt.validateLogin();
		
	}
	
}
