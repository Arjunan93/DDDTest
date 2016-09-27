package com.vmetry.ntl.pages;

import com.vmetry.ntl.initiliazer.Driverfunctionstest;
import com.vmetry.ntl.initiliazer.Initiliazer;

public class homepage extends Initiliazer {

	public static void enterUserName(String userName) throws InterruptedException{
		Driverfunctionstest.getWebelementByXpath("HOMEPAGE_TYPE_NAME_XPATH").sendKeys(userName);
		
	}
	
	public static void enterMobieNo(String mobileNo) throws InterruptedException{
		Driverfunctionstest.getWebelementByXpath("HOMEPAGE_TYPE_MOBILE_XPATH").sendKeys(mobileNo);
		
	}
	
	public static void enterPicAdd(String picadd) throws InterruptedException{
		Driverfunctionstest.getWebelementByXpath("HOMEPAGE_TYPE_PICADD_XPATH").sendKeys(picadd);
	
	}
	
	public static void enterDrop(String dropadd) throws InterruptedException{
		Driverfunctionstest.getWebelementByXpath("HOMEPAGE_TYPE_DROPADD_XPATH").sendKeys(dropadd);
	
	}
	
	public static void selectBasic(String data) throws InterruptedException{
		Driverfunctionstest.selectDropOption("HOMEPAGE_TYPE_BASIC_XPATH", data);
	}


}
