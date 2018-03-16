package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage
{
	WebDriver wd;
	By LockscreenButton = By.xpath("//a[contains(text(),'Lock Screen')]");
	
	public ProfilePage(WebDriver wd)
    {
	    this.wd = wd;
    }
	  public String validateProfilePageTitle()
	     {
			return wd.getTitle();
		 }
	
	
	
}
