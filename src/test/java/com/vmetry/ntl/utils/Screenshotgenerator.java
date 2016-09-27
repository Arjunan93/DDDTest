package com.vmetry.ntl.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntl.initiliazer.Initiliazer;

public class Screenshotgenerator extends Initiliazer{
public static String takeScreenshot(String path) throws IOException{
		
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE); 
		File dst=new File("E:\\selenium\\DDTtest\\Screenshot\\"+path+".jpg");
		FileUtils.copyFile(src, dst);
		
		return dst.toString();
	}
public static void getScreenshot(ITestResult it) throws IOException{
	Object[] data = it.getParameters();
	if(it.isSuccess()){
		String path=Screenshotgenerator.takeScreenshot(data[0].toString());
		log.addScreenCapture(path);
		log.log(LogStatus.PASS,data[0].toString()+ "test pass");
	} else {
		String path=Screenshotgenerator.takeScreenshot(data[0].toString());
		log.addScreenCapture(path);
		log.log(LogStatus.FAIL,data[0].toString()+ "test fail");			
	}

	report.endTest(log);
	report.flush();
	

}
	

}
