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
		String title = coverpage.ValidateIndexPageTitle();
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
	
	
}
