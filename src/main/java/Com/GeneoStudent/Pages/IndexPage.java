package Com.GeneoStudent.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {
	
	WebDriver wd;
	By AnyChapterClick = By.xpath("//*[@id='index_table_rows']/div[3]/div[1]/span[2]");
	By IndexPgResumebutton = By.xpath("//button[contains(text(),'RESUME')]");
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	By SignOutMenuButton = By.xpath("//img[contains(@src,'logout.png')]");
	By SignoutPopUpSignOutButtton = By.xpath("//button[contains(text(),'Sign Out')]");
	By SignoutpopUpCanceButton = By.xpath("//button[contains(text(),'Cancel')][contains(@class,'button_createnote')]");
	

	public IndexPage(WebDriver wd)
    {
	    this.wd = wd;
    }
	
	public String ValidateIndexPgChapterClick()
	{
		
		wd.findElement(AnyChapterClick).click();
		return wd.getTitle();
	}	
	
	public String ValidateIndexPgResumeButton()
	{
		wd.findElement(IndexPgResumebutton).click();
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
	public String Validate_Index_Page_SignOut_PopUp_60_sec_AutoSignOut1() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		System.out.println("time Started");
		Thread.sleep(62000);
		return wd.getTitle();
	}
	public boolean Validate_Index_Page_SignOut_PopUp_60_sec_AutoSignOut2() throws Exception
	{
		wd.findElement(SignOutMenuButton).click();
		System.out.println("time Started");
		Thread.sleep(59000);
		return wd.findElement(SignoutPopUpSignOutButtton).isEnabled();
		
	}
	
	
	
	
}