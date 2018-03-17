package Com.GeneoStudent.Testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.GeneoStudent.Base.TestBase;
import Com.GeneoStudent.Pages.CoverPage;
import Com.GeneoStudent.Pages.LoginPage;

public class CoverPageTest extends TestBase
     {
	CoverPage coverpage;
	LoginPage loginpage;
	public CoverPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() throws Exception  
	{
		initialization();
		loginpage = new LoginPage(wd);
		coverpage = new CoverPage(wd);
		loginpage.LoginToGeneo(prop.getProperty("username"), prop.getProperty("password"));
		select_std_sub(8, "SCIENCE");
	
		
	}
	@Test(priority = 1)
	public void Cover_Page_Click_Test()
	{
		String title = coverpage.Validate_Cover_Page_Click();
		Assert.assertEquals(title, "Geneo Student Index","Cover page click is not working");
	}
	@Test(priority = 2)
	public void Cover_Page_Resume_Button_Test()
	{
		String title = coverpage.ValidateCoverPgResumeButton();
		Assert.assertEquals(title, "Geneo Reader","Cover Page resume button is not working");
	}
	
	@Test(priority = 3)
	public void Cover_Page_SignOut_Button_Test() throws Exception
	{
		LoginPage loginpp = coverpage.ValidateSignOutButton();
		Thread.sleep(2000);
		String title = loginpp.validateLoginPageTitle();
		Assert.assertEquals(title, "Geneo Student Login", "Signout pop up SIGNOUT button is not working");
	}
	@Test(priority = 4)
		public void Cover_Page_SignOut_PopUp_Cancel_Button_Test() throws Exception
		{
			String title = coverpage.ValidateSignOutPopUpCancelButton();
			Assert.assertEquals(title, "Geneo Student Cover Page", "Signout pop up Cancel button is not working");
		}
    @Test(priority = 5)
		public void Cover_Page_SignOut_PopUp_60_sec_AutoSignOut_Test1() throws Exception
		{
			String title = coverpage.Validate_Cover_Page_SignOut_PopUp_60_sec_AutoSignOut1();
			Assert.assertEquals(title, "Geneo Student Login", "Signout pop up 60 seconds auto Signout is not working");
			System.out.println("Account get logged out after 60 seconds");
		}	
    @Test(priority = 6)
	public void Cover_Page_SignOut_PopUp_60_sec_AutoSignOut_Test2() throws Exception
	{
		boolean title = coverpage.Validate_Cover_Page_SignOut_PopUp_60_sec_AutoSignOut2();
		Assert.assertEquals(title, true, "Signout pop up does not wait for 60 seconds");
		System.out.println("Signout pop up displayed for 60 seconds");
	}
    @Test(priority = 7)
   	public void Cover_Page_menu_My_profile_Button_Test() throws Exception
   	{
   		String title = coverpage.Validate_Cover_Page_menu_My_profile_Button();
   		Assert.assertEquals(title, "Geneo Student Profile","After click on coverpage -> menu -> my profile expected My profile page does npot appeared");
   		System.out.println("coverpage -> menu -> my profile button is working fine");
   	}
    @Test(priority = 8)
   	public void Cover_Page_menu_Lock_Screen_Button_Test() throws Exception
   	{
   		String title = coverpage.ValidateCoverPageLockScreenButton();
   		Assert.assertEquals(title, "Geneo Student Login","After click on coverpage -> menu -> Lock screen button expected Login page does npot appeared");
   		System.out.println("coverpage -> menu -> Lock screen button is working fine");
   	}
//    @Test(priority=9)
//    public void Cover_Page_Lock_Screen_Functionality_Test() throws Exception
//   	{
//   		String title = coverpage.ValidateCoverPageLockScreenFunctionality();
//   		Assert.assertEquals(title, "Geneo Student Cover Page","After click on coverpage -> menu -> Lock screen-> again login with same account ->  expected Cover page does npot appeared");
//   		System.out.println("coverpage -> menu -> Lock screen-> Again Login with same account :: Lock screen Functionality is working fine");
//   	}
    
    @Test(priority = 10)
   	public void Cover_Page_menu_Change_Password_Button_Test() throws Exception
   	{
   		Boolean title = coverpage.ValidateCoverPageChangePasswordButton();
   		Assert.assertFalse(title,"Change Password window Failed to open");
   		System.out.println("coverpage -> menu -> Change password button is working fine");
   	}
    
    
    
}