package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.GeneoStudent.Base.TestBase;

public class CoverPage extends TestBase{
	
	WebDriver wd;
	LoginPage loginpage = new LoginPage(wd);

	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	By CoverPgResumebutton = By.xpath("//button[contains(text(),'RESUME')]");
	By SignOutMenuButton = By.xpath("//img[contains(@src,'logout.png')]");
	By SignoutPopUpSignOutButtton = By.xpath("//button[contains(text(),'Sign Out')]");
	By SignoutpopUpCanceButton = By.xpath("//button[contains(text(),'Cancel')][contains(@class,'button_createnote')]");
	By MenuMyProfileButton =  By.xpath("//a[contains(text(),'My Profile')]");
	By MenuButtonn =  By.xpath("//img[@class='landing_user']");
	By LockscreenButton = By.xpath("//a[contains(text(),'Lock Screen')]"); 
	By Changepasswordbutton = By.xpath("//a[contains(text(),'Change Password')]"); //*[@id="user_current_pwd"]
	By user_current_pwd = By.xpath("//*[@id='user_current_pwd']");
	public CoverPage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	public String Validate_Cover_Page_Click()
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
	
	public String Validate_Cover_Page_menu_My_profile_Button()
	{
		wd.findElement(MenuButtonn).click();
		wd.findElement(MenuMyProfileButton).click();
		return wd.getTitle();
	}
	public String ValidateIndexPageTitle()
	{
		wd.findElement(CoverPageClick).click();
		return wd.getTitle();
	}
	public String ValidateCoverPageLockScreenButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(LockscreenButton).click();
		Thread.sleep(2000);
		return wd.getTitle();
	}
	// complete this method later
//	public String ValidateCoverPageLockScreenFunctionality() throws Exception
//	{
//		Thread.sleep(2000);
//		wd.findElement(MenuButtonn).click();
//		System.out.println("menu button got clicked");
//		wd.findElement(LockscreenButton).click();
//		Thread.sleep(2000);
//		loginpage.LoginToGeneo(prop.getProperty("username"), prop.getProperty("password"));
//		return wd.getTitle();
//	}
	
	public boolean ValidateCoverPageChangePasswordButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		Thread.sleep(2000);
		boolean tt = wd.findElement(user_current_pwd).isEnabled();
		return tt;
		
	}
	
	
	
	
}
