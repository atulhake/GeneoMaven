package Com.GeneoStudent.Testcases;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.GeneoStudent.Base.TestBase;
import Com.GeneoStudent.Pages.CoverPage;
import Com.GeneoStudent.Pages.LoginPage;
import Com.GeneoStudent.Util.TestUtil;

public class Cover_Page_Change_Password_Test extends TestBase
     {
	CoverPage coverpage;
	LoginPage loginpage;
	public Cover_Page_Change_Password_Test()
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
	@Test(priority=1)
	public void  Cover_Pg_Change_Password_Blank_Input_Test() throws Exception
	{
		String ss= coverpage.ValidateCpCpSaveButton();
		Assert.assertEquals(ss, "Please fill all the fields.","Cover page change Password save button is not working");
		System.out.println("Cover page change Password save button is working fine & All field blank test pass");
	}
	@Test(priority=2)
	public void  Cover_Pg_Change_Password_Cancel_button_Test() throws Exception
	{
		boolean ss= coverpage.ValidateCpCpCancelButton();
		Assert.assertFalse(ss, "Cover page change Password save button is not working");
		System.out.println("Cover page change Password cancel button is working fine ");
	}
	@Test(priority=3)
		public void  Cover_Pg_Change_Password_Alert_Ok_Button_Test() throws Exception
		{
			boolean ss= coverpage.ValidateCpCpAlertOKButton();
			Assert.assertFalse(ss, "Cover page change Password alert pop up OK button is not working");
			System.out.println("Cover page change Password alert pop up OK button is  working fine");
		}
	@Test(priority=4)
		public void  Cover_Pg_Change_Password_Only_Current_Password_Input_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpOnlyCurrentPassword();
			Assert.assertEquals(ss, "Please fill all the fields.","Cover page change Password Only current password Test failed");
			System.out.println("Cover page change Password Only current password Test passed");
		}
		@Test(priority=5)
		public void  Cover_Pg_Change_Password_Only_new_Password_Input_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpOnlyCurrentPassword();
			Assert.assertEquals(ss, "Please fill all the fields.","Cover page change Password Only new password Test failed");
			System.out.println("Cover page change Password Only new password Test passed");
		}
		@Test(priority=6)
		public void  Cover_Pg_Change_Password_Only_confirm_Password_Input_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpOnlyConfirmPassword();
			Assert.assertEquals(ss, "Please fill all the fields.","Cover page change Password Only confirm password Test failed");
			System.out.println("Cover page change Password Only confirm password Test passed");
		}	
		@Test(priority=7)
		public void  Cover_Pg_Change_Password_Incorrect_Current_Password_Input_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpIncorrectCurrentPassword();
			Assert.assertEquals(ss, "This does not match your current password.","Cover page change Password Incorrect current password Test failed");
			System.out.println("Cover page change Password Incorrect current password Test Passed");
		}
		@Test(priority=8)
		public void  Cover_Pg_Change_Password_Positive_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpcPosoitiveTest();
			Assert.assertEquals(ss, "Your password has been updated.","Cover page change Password Positive Test failed.");
			System.out.println("Cover page change Password Positive Test Passed.");
			String dd= coverpage.RevertPassword();
			Assert.assertEquals(dd, "Your password has been updated.","Cover page change Password Revert password try failed please Change it manually failed.");
			System.out.println("Password reverted successfully");
		}
		@Test(priority=9)
		public void  Cover_Pg_Change_Password_New_OLD_Pass_Mismatch_Input_Test() throws Exception
		{
			String ss= coverpage.ValidateCpCpcNewAndConfirmPassMismatchedTest();
			Assert.assertEquals(ss, "New password not matching with confirm password.","Cover page change Password New Old Mismatch password Test failed");
			System.out.println("Cover page change Password New Old Mismatch password Test Passed.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 @AfterMethod
			public void teardown(ITestResult result)
			{
				TestUtil testutil = new TestUtil();
				testutil.ScreenShotOfFailedMenthod(result);
			//wd.quit();	
			}
		
		
		
		
		
		
		
		
		
		
		
		
	
 }