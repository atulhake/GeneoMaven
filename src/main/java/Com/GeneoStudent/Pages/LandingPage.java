package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.GeneoStudent.Base.TestBase;

public class LandingPage extends TestBase
{
	WebDriver wd;
	By LockscreenButton = By.xpath("//a[contains(text(),'Lock Screen')]");

	
	
	public LandingPage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	public String verifyHomePageTitle()
	{
		return wd.getTitle();
	}
	
	
	
}
