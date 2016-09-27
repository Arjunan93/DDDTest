//package temp;
package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporttest {

	ExtentReports report;
	ExtentTest log;
	WebDriver wd;
	@Test(priority=1)
	public void validLogin(){
		report=new ExtentReports("S:\\Vmetry\\JavaWorkspace\\DDTest\\reports\\tcreports.html");
		log=report.startTest("validLogin");
		wd=new FirefoxDriver();
		wd.get("https://www.google.co.in");
	}
	
	@Test(priority=2)
	public void inValidLogin(){
		log=report.startTest("inValidLogin");
		wd.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/?tab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1");
	}
	@Test(priority=3)
	public void partialvalidLogin(){
		log=report.startTest("partialvalidLogin");
		wd.get("https://in.yahoo.com/");		
	}
	
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException{

		if(it.isSuccess()){
			String path=takeScreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "test pass");
		} else {
			String path=takeScreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "test fail");			
		}

		report.endTest(log);
		report.flush();
		
	}
	
	public String takeScreenshot(String path) throws IOException{
		
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE); 
		File dst=new File("S:\\Vmetry\\JavaWorkspace\\DDTest\\screenshot\\"+path+".jpg");
		FileUtils.copyFile(src, dst);
		
		return dst.toString();
	}
	
}
