package Com.GeneoStudent.Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Com.GeneoStudent.Util.TestUtil;

public class TestBase 
{
      public static   WebDriver wd;
      public static Properties prop;
       
   	
   	public TestBase()	 
   	{
   		
		try {
			FileInputStream ip =  new FileInputStream("C:/eclipse/Geneo_maven/src/main/java/Com/GeneoStudent/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	
		}
	}
   	public  void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
			wd = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			wd = new FirefoxDriver(); 
		}
		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();
	    wd.get(prop.getProperty("url"));
		//wd.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
   	
    public void select_std_sub(int std,String subject) throws InterruptedException
    {
		 if(wd.getTitle().equals("Geneo Student Cover Page"))
			{
				wd.findElement(By.xpath(".//img[@class='landing_user']")).click();   // menu option
				wd.findElement(By.xpath(".//a[contains(text(),'Geneo')]")).click(); //GENEO OPTION OF MENU BAR 
			}
		 
		
		Thread.sleep(2000);  
		wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div/button")).click(); 
		 
    switch (std) {
    case 10:  
    	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a")).click(); //10th Standard
       
	     	System.out.println("\n\n10th standard");
    	      break;
    case 9:  
   	 wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div/ul/li[2]/a")).click();  //9th standard
		
		System.out.println("\n\n9th standard");
		      break;
    case 8:  
    	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div/ul/li[1]/a")).click();  //8th standard
    
		System.out.println("\n\n8th standard");
		      break;
    			}
	
	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/span/span")).click();  //subject dropdown

    switch (subject) {
        case "SCIENCE": 
        	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/ul/li[2]/a")).click();  //science 
        	System.out.println("Science");
        	     break;
        case "MATHAMATICS":  
        	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/ul/li[1]/a")).click(); //Maths 
    		System.out.println("Mathamatics");
                 break;
        case "ENGLISH":  
        	wd.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/ul/li[3]/a")).click(); //English 
    		System.out.println("English");
                 break;
    				}
		 Thread.sleep(1000);
		 By done_button =By.xpath("//button[contains(text(),'DONE')]");
		 wd.findElement(done_button).click();
  /*//============================cover to index page =================================//
		Thread.sleep(1000);
		wd.findElement(By.xpath(".//*[@class='chat_note_content']/a/img")).click(); // cover page click event
		Thread.sleep(1000);
		System.out.println("Index page displayed.");
		Thread.sleep(2000);
		*/
 	  
    }
	
}
