package com.vmetry.ntl.initiliazer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntl.utils.Reportgenerator;

public class Initiliazer {
	// archive initilization
	public static boolean isArchive =true;
// Reports initialization
	public static ExtentReports report;
	public static ExtentTest log;
	//Env prop declartion
	public static FileInputStream envFis=null;
	public static Properties envPro=null;

	//Locator prop declartion
	public static FileInputStream locatorFis=null;
	public static Properties locatorPro=null;
	
	//driver declaration
	public static WebDriver wd=null;
	
	public static void initailize() throws IOException{
	Reportgenerator.archivefiles();
	    envFis=new FileInputStream(new File("E:\\selenium\\DDTtest\\src\\test\\java\\com\\vmetry\\ntl\\config\\env.properties"));
		 // "E":+File.separator+"Selenium"+File.seperator+"DDTest"+... - we can use for all OS 
	    envPro=new Properties();
		envPro.load(envFis);
	
		report=new ExtentReports("E:\\selenium\\DDTtest\\Report\\DDD.html");
		locatorFis=new FileInputStream(new File("E:\\selenium\\DDTtest\\src\\test\\java\\com\\vmetry\\ntl\\config\\locator.properties"));
		locatorPro=new Properties();
		locatorPro.load(locatorFis);

	
		if(envPro.getProperty("BROWSER").equals("firefox")){
			 wd=new FirefoxDriver();
		} else if(envPro.getProperty("BROWSER").equals("chrome")){
			 wd=new ChromeDriver();
		}
		
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
}
