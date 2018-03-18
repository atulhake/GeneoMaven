package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;

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
	By Changepasswordbutton = By.xpath("//a[contains(text(),'Change Password')]"); 
	//By user_current_pwd = By.xpath("//*[@id='user_current_pwd']");
	By MenuGeneoButton = By.xpath("//a[contains(text(),'Geneo')]");
	By LeftNevigationButton = By.xpath("//img[contains(@src,'previous.png')]");
	By RightNevigationButton = By.xpath("//img[contains(@src,'next.png')]"); 
	By HelpButton = By.xpath("//img[contains(@src,'Help_btn.png')]");
	By HelpWindowCloseButton = By.xpath("//button[contains(@class,'close_corosal')]");
	By HelpWindowLeftClickButton = By.xpath("//span[contains(@class,'glyphicon-chevron-left')]");	
	By HelpWindowRightClickButton = By.xpath("//span[contains(@class,'glyphicon-chevron-right')]");
	By ChangePasswordWSaveButton  =  By.xpath("//button[contains(@class,'Change_password_save')]");
	By ChangePasswordWCancelButton = By.xpath("//button[contains(@class,'Change_password_cancel')]");
	By UserCurrentPassword =  By.id("user_current_pwd");
	By UserNewPassword =  By.id("user_new_pwd");
	By UserConfirmPassword =  By.id("user_confirm_password");
	By Alertmsg =  By.xpath("//*[@id='alertmsg']");
	By AlertmsgOkButton = By.xpath("//*[@id='myModal_alertmessage']/div/div/div[3]/center/button");
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	
	
	
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
		boolean tt = wd.findElement(UserCurrentPassword).isDisplayed();
		return tt;
	}
	public String ValidateCoverPageMenuGeneoButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(MenuGeneoButton).click();
		Thread.sleep(2000);
		return wd.getTitle();
	}
	public String ValidateCoverPagePreviousPageButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(LeftNevigationButton).click();
		return wd.getTitle();
	}
	public String ValidateCoverPageNextPageButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(RightNevigationButton).click();
		return wd.getTitle();
	}
	public Boolean ValidateCoverPageHelpButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(HelpButton).click();
		System.out.println("Help button got clicked");
		return wd.findElement(HelpWindowCloseButton).isDisplayed();
	}
	public Boolean ValidateCoverPageWCloseButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(HelpButton).click();
		System.out.println("Help button got clicked");
		Thread.sleep(2000);
		wd.findElement(HelpWindowCloseButton).click();
		//Thread.sleep(500);
		return wd.findElement(HelpWindowCloseButton).isDisplayed();

	}
//	implement this two method by storing which image will come after click on this button use src tag 
//	//public Boolean ValidateCoverPageWLeftClickButton() throws Exception
//	{
//		Thread.sleep(2000);
//		wd.findElement(HelpButton).click();
//		System.out.println("Help button got clicked");
//		wd.findElement(HelpWindowLeftClickButton).click();
//		
//	}
//	//public Boolean ValidateCoverPageWRightClickButton() throws Exception
//	{
//		Thread.sleep(2000);
//		wd.findElement(HelpButton).click();
//		System.out.println("Help button got clicked");
//		wd.findElement(HelpWindowRightClickButton).click();
//		
//	}
	
	public String ValidateCpCpSaveButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserCurrentPassword).sendKeys("");
		wd.findElement(UserNewPassword).sendKeys("");
		wd.findElement(UserConfirmPassword).sendKeys("");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		return wd.findElement(Alertmsg).getText();
	}
	public boolean ValidateCpCpCancelButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		Thread.sleep(2000);
		wd.findElement(ChangePasswordWCancelButton).click();
		Thread.sleep(2000);
		return wd.findElement(ChangePasswordWCancelButton).isDisplayed();
	}
	public boolean ValidateCpCpAlertOKButton() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserCurrentPassword).sendKeys("");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		wd.findElement(AlertmsgOkButton).click();
		Thread.sleep(2000);
		return wd.findElement(AlertmsgOkButton).isDisplayed();
	}
	public String ValidateCpCpOnlyCurrentPassword() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserCurrentPassword).sendKeys("vsscewjnee");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		return wd.findElement(Alertmsg).getText();
	}
	public String ValidateCpCpOnlyNewPassword() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserNewPassword).sendKeys("vsdvd");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		return wd.findElement(Alertmsg).getText();
	}
	public String ValidateCpCpOnlyConfirmPassword() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserConfirmPassword).sendKeys("vsdvd");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		return wd.findElement(Alertmsg).getText();
	}
	public String ValidateCpCpIncorrectCurrentPassword() throws Exception
	{
		Thread.sleep(2000);
		wd.findElement(MenuButtonn).click();
		System.out.println("menu button got clicked");
		wd.findElement(Changepasswordbutton).click();
		wd.findElement(UserCurrentPassword).sendKeys("Geneo");
		wd.findElement(UserNewPassword).sendKeys("Geneo@1234");
		wd.findElement(UserConfirmPassword).sendKeys("Geneo@1234");
		wd.findElement(ChangePasswordWSaveButton).click();
		Thread.sleep(2000);
		return wd.findElement(Alertmsg).getText();
	}
	
	
	
}
