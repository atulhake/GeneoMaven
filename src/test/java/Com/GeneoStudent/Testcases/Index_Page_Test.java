package Com.GeneoStudent.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.GeneoStudent.Base.TestBase;
import Com.GeneoStudent.Pages.IndexPage;
import Com.GeneoStudent.Pages.LoginPage;


public class Index_Page_Test extends TestBase
{
	
	LoginPage loginpage;
	IndexPage indexpage;
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	public Index_Page_Test()
	{
		super();
	}
	@BeforeMethod
	public void setup() throws Exception  
	{
		initialization();
		loginpage = new LoginPage(wd);
		indexpage = new IndexPage(wd);
		loginpage.LoginToGeneo(prop.getProperty("username"), prop.getProperty("password"));
		select_std_sub(8, "SCIENCE");
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
		Thread.sleep(2000);
		String title = loginpp.validateLoginPageTitle();
		Assert.assertEquals(title, "Geneo Student Login", "Signout pop up SIGNOUT button is not working");
	}
	
}
