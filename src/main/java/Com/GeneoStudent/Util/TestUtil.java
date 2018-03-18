package Com.GeneoStudent.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Com.GeneoStudent.Base.TestBase;

public  class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public ITestResult result;
	
	public static String TESTDATA_SHEET_PATH = "C:/eclipse/Geneo_maven/src/main/java"
			+"/Com/GeneoStudent/TestData/Data.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	DateFormat df = new SimpleDateFormat("ddMMYYHHmmss");
	Date DateTime = new Date();
	String ss=df.format(DateTime);

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int lastrowno= sheet.getLastRowNum();
		int lastcellno = sheet.getRow(0).getLastCellNum();
		System.out.println(lastrowno);
		System.out.println(lastcellno);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
public  void ScreenShotOfFailedMenthod(ITestResult result)
{
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
		{
		try 
			{
			// Create refernce of TakesScreenshot
			TakesScreenshot ts=(TakesScreenshot)wd;
			// Call method to capture screenshot
			File source=ts.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location here it will save all screenshot in our project home directory and
			// result.getName() will return name of test case so that screenshot name will be same
			FileUtils.copyFile(source, new File("./screenshots_geneo/"+result.getName()+ss+".png"));
			System.out.println("Screenshot taken");
			} 
		catch (Exception e)
			{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
}
public void getscreenshots(WebDriver wd ,String name)
	{
		try{
			
			
			TakesScreenshot ts = (TakesScreenshot)wd;
			File source =ts.getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(source, new File("./screenshots_geneo/"+result.getName()+ss+".png"));
		   }
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
}




















	


