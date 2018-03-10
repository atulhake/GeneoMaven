package Com.GeneoStudent.Pages;

import org.openqa.selenium.WebDriver;

import Com.GeneoStudent.Base.TestBase;

public class HomePage extends TestBase
{
	WebDriver wd;
	
	
	public HomePage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	public String verifyHomePageTitle()
	{
		return wd.getTitle();
	}
	
	
	
}
