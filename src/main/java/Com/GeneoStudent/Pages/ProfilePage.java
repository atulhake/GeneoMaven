package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage
{
	WebDriver wd;
	By LockscreenButton = By.xpath("//a[contains(text(),'Lock Screen')]");
	By LeftNevigationButton = By.xpath("//li[contains(@class,'left_nav')]");
	By RightNevigationButton = By.xpath("//li[contains(@class,'right_nav')]");
	By MenuGeneoButton = By.xpath("//a[contains(text(),'Geneo')]");
	
	public ProfilePage(WebDriver wd)
    {
	    this.wd = wd;
    }
	  public String validateProfilePageTitle()
	     {
			return wd.getTitle();
		 }
	
	
	
}
