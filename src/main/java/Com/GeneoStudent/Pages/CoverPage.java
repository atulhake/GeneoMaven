package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoverPage {
	
	WebDriver wd;
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	By CoverPgResumebutton = By.xpath("//button[contains(text(),'RESUME')]");
	By SignOutMenuButton = By.xpath("//img[contains(@src,'logout.png')]");
	By SignoutPopUpButtton = By.xpath("//button[contains(text(),'Sign Out')]");
	By SignoutpopUpcanceButton = By.xpath("//button[contains(text(),'Cancel')]");
	
	public CoverPage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	
	public String ValidateIndexPageTitle()
	{
		wd.findElement(CoverPageClick).click();
		return wd.getTitle();
	}	
	
	public String ValidateCoverPgResumeButton()
	{
		wd.findElement(CoverPgResumebutton).click();
		return wd.getTitle();
	}	
	public  LoginPage ValidateSignOutButton() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		Thread.sleep(2000);
		wd.findElement(SignoutPopUpButtton).click();
		return new LoginPage(wd);
	}
	public  LoginPage ValidateSignOutPopUpCancelButton() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		Thread.sleep(2000);
		wd.findElement(SignoutPopUpButtton).click();
		return new LoginPage(wd);
	}
}
