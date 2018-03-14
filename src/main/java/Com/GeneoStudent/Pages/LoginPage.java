package Com.GeneoStudent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;

import Com.GeneoStudent.Pages.HomePage;
import Com.GeneoStudent.Base.TestBase;

public class LoginPage 
  {
   WebDriver wd;
   By username = By.id("login_input_Uname");
   By Password = By.id("login_input_Pwd");
   By loginbutton = By.xpath("/html/body/div[2]/div/div/form/input");
  // By KillAllSession = By.id("update_flag_login");
   By KillAllSession = By.cssSelector("#update_flag_login");
   By popup = By.xpath("//*[@id='alert-msg']");
   By coverpage_title = By.xpath("/html/head/title[contains(text(),'Geneo Student Cover Page')]");
   By LandingPage_title = By.xpath("/html/head/title[contains(text(),'Student Landing page')]");
   By ForgotPasswordHyperLink = By.className("login_forgot");
   By ForgotPasswordWindow = By.id("txt_UserName");
   By FP_SendButton = By.id("btn_SendFogotPassword");
   By FP_Send_Click_PopUP = By.xpath("//*[@id='myModal_alertmessage']/div/div/div/h4");
   By Checkbox = By.xpath("/html/body/div[2]/div/div/form/div[3]/span/label");
   By Password12 = By.xpath("//input[@id='login_input_Pwd'][@type='text']");
 public LoginPage(WebDriver wd)
    {
	    this.wd = wd;
    }
     public String validateLoginPageTitle()
     {
		return wd.getTitle();
	 }
     
     public String validateLogin()
     {
    	WebElement  element = wd.findElement(popup);
    	String PopupTitle = element.getText();
		return PopupTitle;
     }
     
     public  HomePage LoginToGeneo(String UId,String pass) throws InterruptedException
     {
    wd.findElement(username).sendKeys(UId);
   	   wd.findElement(Password).sendKeys(pass);
   	   wd.findElement(loginbutton).click();
   	Thread.sleep(1000);
   	  try {
   		  
   		if(wd.findElement(KillAllSession).isDisplayed());
 	   {
 		   Thread.sleep(1000);
 		   wd.findElement(KillAllSession).click();  
 		   System.out.println("killed all other sessions");
 	   }
 	   if(wd.getTitle().equals("Student Landing page")||wd.getTitle().equals("Geneo Student Cover Page"))
	  	   {
	  		   System.out.println("successful Logged in");
	  	   }
   	  		} catch (Exception e){}
      	return new HomePage(wd);
     }
     
  public String ValidateForgotPassword(String ss) throws Exception
  {
	  wd.findElement(ForgotPasswordHyperLink).click();
	  wd.findElement(ForgotPasswordWindow).sendKeys(ss);
	  wd.findElement(FP_SendButton).click();
	  Thread.sleep(2000);
	 WebElement FP = wd.findElement(FP_Send_Click_PopUP);
	 
	 String name = FP.getText();
	// System.out.println(name);
	 return name;
  }
  
  public Boolean ValidateShowPassword(String Pass) throws Exception 
	 {
		 wd.findElement(Password).sendKeys(Pass);
		 wd.findElement(Checkbox).click();
		// Thread.sleep(5000);
		 boolean After =wd.findElement(Password12).isEnabled();
		return true;
	 }

  }    
     
     
     
