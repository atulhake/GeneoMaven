package Com.GeneoStudent.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.GeneoStudent.Base.TestBase;
import Com.GeneoStudent.Pages.IndexPage;
import Com.GeneoStudent.Pages.LoginPage;
import Com.GeneoStudent.Util.TestUtil;


public class Index_Page_Test extends TestBase
{
	
	LoginPage loginpage;
	IndexPage indexpage;
	
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
//	@FindBy(xpath="//img[contains(@src,'cover.png')]")
//	public WebElement CoverPageClick;
	
	
	public Index_Page_Test()
	{
		super();
		PageFactory.initElements(wd, this);
		
	}
	
	@BeforeMethod
	public void setup() throws Exception  
	{
		initialization();
		loginpage = new LoginPage(wd);
		indexpage = new IndexPage(wd);
		loginpage.LoginToGeneo(prop.getProperty("username"), prop.getProperty("password"));
		select_std_sub(8, "SCIENCE");
		Thread.sleep(3000);
		wd.findElement(CoverPageClick).click();
		
		
	}
	@Test(priority = 1)
	public void Index_Page_Chapter_Click_Test()
	{
		String title = indexpage.ValidateIndexPgChapterClick();
		Assert.assertEquals(title, "Geneo Reader","Index page chapter selection is not working");
	}
	@Test(priority = 2)
	public void Index_Page_Resume_Button_Test()
	{
		String title = indexpage.ValidateIndexPgResumeButton();
		Assert.assertEquals(title, "Geneo Reader","Index  Page resume button is not working");
	}
	@Test(priority = 3)
	public void Index_Page_SignOut_Button_Test() throws Exception
	{
		LoginPage loginpp = indexpage.ValidateSignOutButton();
		String title = loginpp.validateLoginPageTitle();
		Assert.assertEquals(title, "Geneo Student Login", "Signout pop up SIGNOUT button is not working");
	}
	@Test(priority = 4)
	public void Index_Page_SignOut_PopUp_Cancel_Button_Test1() throws Exception
		{
			String title = indexpage.ValidateSignOutPopUpCancelButton();
			Assert.assertEquals(title, "Geneo Student Index", "Signout pop up Cancel button is not working");
		}
	 @Test(priority = 5)
	public void Index_Page_SignOut_PopUp_60_sec_AutoSignOut_Test1() throws Exception
	{
		String title = indexpage.Validate_Index_Page_SignOut_PopUp_60_sec_AutoSignOut1();
		Assert.assertEquals(title, "Geneo Student Login", "Signout pop up 60 seconds auto Signout is not working");
		System.out.println("Account get logged out after 60 seconds");
	}	
	  @Test(priority = 6)
	  public void Cover_Page_SignOut_PopUp_60_sec_AutoSignOut_Test2() throws Exception
		{
			boolean title = indexpage.Validate_Index_Page_SignOut_PopUp_60_sec_AutoSignOut2();
			Assert.assertEquals(title, true, "Signout pop up does not wait for 60 seconds");
			System.out.println("Signout pop up displayed for 60 seconds");
		}
		@Test(priority = 9)
	   	public void Index_Page_menu_My_profile_Button_Test() throws Exception
	   	{
	   		String title = indexpage.Validate_index_Page_menu_My_profile_Button();
	   		Assert.assertEquals(title, "Geneo Student Profile","After click on IndexPage -> menu -> my profile button, expected My profile page does npot appeared");
	   		System.out.println("IndexPage -> menu -> my profile button is working fine");
	   	}
		 @Test(priority = 10)
		   	public void Index_Page_menu_Lock_Screen_Button_Test() throws Exception
		   	{
		   		String title = indexpage.ValidateIndexPageLockScreenButton();
		   		Assert.assertEquals(title, "Geneo Student Login","After click on IndexPage -> menu -> Lock screen button, expected Login page does npot appeared");
		   		System.out.println("IndexPage -> menu -> Lock screen button is working fine");
		   	}
		 
		 @AfterMethod
			public void teardown(ITestResult result)
			{
				TestUtil testutil = new TestUtil();
				testutil.ScreenShotOfFailedMenthod(result);
			wd.quit();	
			}
}