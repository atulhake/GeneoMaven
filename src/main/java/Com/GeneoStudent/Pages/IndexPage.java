package Com.GeneoStudent.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {
	
	WebDriver wd;
	By AnyChapterClick = By.xpath("//*[@id='index_table_rows']/div[3]/div[1]/span[2]");
	By IndexPgResumebutton = By.xpath("//button[contains(text(),'RESUME')]");
	By CoverPageClick = By.xpath("//img[contains(@src,'cover.png')]");
	By SignOutMenuButton = By.xpath("//img[contains(@src,'logout.png')]");
	By SignoutPopUpButtton = By.xpath("//button[contains(text(),'Sign Out')]");
	

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
		wd.findElement(SignoutPopUpButtton).click();
		return new LoginPage(wd);
	}
	
}