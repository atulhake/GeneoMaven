package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoverPage {
	
	WebDriver wd;
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	By CoverPgResumebutton = By.xpath("//button[contains(text(),'RESUME')]");
	By SignOutMenuButton = By.xpath("//img[contains(@src,'logout.png')]");
	By SignoutPopUpSignOutButtton = By.xpath("//button[contains(text(),'Sign Out')]");
	By SignoutpopUpCanceButton = By.xpath("//button[contains(text(),'Cancel')][contains(@class,'button_createnote')]");
	By MenuMyProfileButton =  By.xpath("//a[contains(text(),'My Profile')]");
	By MenuButtonn =  By.xpath("//img[@class='landing_user']");
	//By MenuMyProfileButton =  By.xpath("");
	
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
		wd.findElement(SignoutPopUpSignOutButtton).click();
		return new LoginPage(wd);
	}
	
	public  String ValidateSignOutPopUpCancelButton() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		Thread.sleep(2000);
		wd.findElement(SignoutpopUpCanceButton).click();
		return wd.getTitle();
	}
	
	public String Validate_Cover_Page_SignOut_PopUp_60_sec_AutoSignOut1() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		System.out.println("60 seconds counter time Started");
		Thread.sleep(62000);
		return wd.getTitle();
	}
	
	public boolean Validate_Cover_Page_SignOut_PopUp_60_sec_AutoSignOut2() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		System.out.println("60 seconds counter time Started");
		Thread.sleep(59000);
		return wd.findElement(SignoutPopUpSignOutButtton).isEnabled();
	}
	
	//public String Validate_Cover_Page_menu_My_profile_Button()
	{
		wd.findElement(MenuButtonn).click();
		wd.findElement(MenuMyProfileButton).click();
		
		
		
	}
}
