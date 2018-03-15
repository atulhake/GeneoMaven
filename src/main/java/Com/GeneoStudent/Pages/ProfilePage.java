package Com.GeneoStudent.Pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage
{
	WebDriver wd;
	public ProfilePage(WebDriver wd)
    {
	    this.wd = wd;
    }
	  public String validateProfilePageTitle()
	     {
			return wd.getTitle();
		 }
	
	
	
}
