package com.vmetry.ntl.initiliazer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Driverfunctionstest extends Initiliazer {

	public static void loadURL(){
		wd.get(envPro.getProperty("URL"));
	}
	
	
	public static WebElement getWebelementByXpath(String xpath) throws InterruptedException{
		
		WebElement element= wd.findElement(By.xpath(locatorPro.getProperty(xpath)));	
		highLightElement(element);
		return element;
	}
	
	public static void selectDropOption(String xpath, String data) throws InterruptedException{
		
		WebElement element=wd.findElement(By.xpath(locatorPro.getProperty(xpath)));
		highLightElement(element);
		Select s=new Select(element);
		s.selectByVisibleText(data);
	}
	
	public static void highLightElement(WebElement we) throws InterruptedException{
		
		((JavascriptExecutor)wd).executeScript("arguments[0].style.border='5px solid red'", we);
		Thread.sleep(700);
		((JavascriptExecutor)wd).executeScript("arguments[0].style.border=''", we);
		
	}
}
