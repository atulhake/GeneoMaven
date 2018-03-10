package Com.GeneoStudent.Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
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
		wd.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	
}
