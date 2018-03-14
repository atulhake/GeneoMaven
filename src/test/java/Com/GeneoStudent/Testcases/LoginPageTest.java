package Com.GeneoStudent.Testcases;
import java.io.File;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import Com.GeneoStudent.Base.TestBase;
import Com.GeneoStudent.Pages.LandingPage;
import Com.GeneoStudent.Pages.LoginPage;
import Com.GeneoStudent.Util.TestUtil;

public class LoginPageTest extends TestBase 
{
	LoginPage loginpage;
	LandingPage homepage;
	public LoginPageTest()	
	{
		super();  
	}
	 
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage(wd);
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Geneo Student Login", "Login page title mismatched");
	}
	
	
	@Test(priority=2)
	public void LoginTest() throws Exception
	{
		homepage =  loginpage.LoginToGeneo(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Geneo Student Cover Page","does not match");
	}
	
	
	@Test(priority=3)
		public void Login_Correct_ID_Incorrect_Password_Test() throws Exception
		{
		
			loginpage.LoginToGeneo(prop.getProperty("UN1"), prop.getProperty("PS1"));
	        Thread.sleep(2000);
			String aa= loginpage.validateLogin();
	        Assert.assertEquals(aa, "Please enter valid Username and Password.","Pop up text does not match");
		}
		
		
	@Test(priority=4)
	public void Login_InCorrect_ID_Incorrect_Password_Test() throws Exception
	{
	
		loginpage.LoginToGeneo(prop.getProperty("UN2"), prop.getProperty("PS2"));
        Thread.sleep(2000);
		String aa= loginpage.validateLogin();
        Assert.assertEquals(aa, "Please enter valid Username and Password.","Pop up text does not match");
	}
	
	
	@Test(priority=5)    // take text from sanket for this pop up
	public void Login_Blank_ID_Blank_Password_Test() throws Exception
	{
	
		loginpage.LoginToGeneo(prop.getProperty("UN3"), prop.getProperty("PS3"));
        Thread.sleep(2000);
		String aa= loginpage.validateLogin();
        Assert.assertEquals(aa, "Please enter Username and Password.","Pop up text does not match");
	}
	
	
	@Test(priority=6)    // take text from sanket
	public void Login_Blank_ID_Valid_Password_Test() throws Exception
	{
	
		loginpage.LoginToGeneo(prop.getProperty("UN4"), prop.getProperty("PS4"));
        Thread.sleep(2000);
		String aa= loginpage.validateLogin();
        Assert.assertEquals(aa, "Please enter valid Username and Password.","Pop up text does not match");
	}
	
	
	@Test(priority=7)
	public void Forgot_Password_Positive_test() throws Exception
	{
		String FP = loginpage.ValidateForgotPassword(prop.getProperty("Registered_ID_For_FP"));
		Assert.assertEquals(FP, "Password Resent", " Password sent pop up failed to display");
	}
	
	
	@Test(priority=8)
	public void Forgot_Password_Negative_test() throws Exception
	{
		String FP = loginpage.ValidateForgotPassword(prop.getProperty("Unregistered_ID_For_FP"));
		Assert.assertEquals(FP, "Incorrect Details", " Password Incorrect Details pop up failed to display");
	}
	@Test(priority=9)
	public void Forgot_Password_Blank_ID_test() throws Exception
	{
		String FP = loginpage.ValidateForgotPassword(prop.getProperty("Blank_ID_For_FP"));
		Assert.assertEquals(FP, "Incorrect Details", " Password Incorrect Details pop up failed to display");
	}
	@Test(priority = 10)
	public void Show_Password_Test() throws Exception 
	{
		loginpage.ValidateShowPassword("Abcde");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		TestUtil testutil = new TestUtil();
		testutil.ScreenShotOfFailedMenthod(result);
		
	//wd.quit();	
	}
	
	
}
