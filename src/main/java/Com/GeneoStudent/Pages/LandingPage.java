package Com.GeneoStudent.Pages;

import org.openqa.selenium.WebDriver;

import Com.GeneoStudent.Base.TestBase;

public class LandingPage extends TestBase
{
	WebDriver wd;
	
	
	public LandingPage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	public String verifyHomePageTitle()
	{
		return wd.getTitle();
	}
	
	
	
}
