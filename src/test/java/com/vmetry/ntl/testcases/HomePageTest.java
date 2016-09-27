
package com.vmetry.ntl.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntl.initiliazer.Driverfunctionstest;
import com.vmetry.ntl.initiliazer.Initiliazer;
import com.vmetry.ntl.pages.homepage;
import com.vmetry.ntl.utils.Screenshotgenerator;
import com.vmetry.ntltaxi.inputreader.inputReader;

public class HomePageTest extends Initiliazer {

	@BeforeClass
	public void setUp() throws IOException{
		initailize();
	}
	@Test(dataProvider="HomePageTest")
	public void testHomePage(String data,String userName,String mobileNo,String picadd,String dropadd,String basic) throws IOException, InterruptedException {
		log=report.startTest("validLogin");
		Driverfunctionstest.loadURL();
		homepage.enterUserName(userName);
		homepage.enterMobieNo(mobileNo);
		homepage.enterPicAdd(picadd);
		homepage.enterDrop(dropadd);
		homepage.selectBasic(basic);
	}
	
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePageData() throws Exception{
		if (inputReader.RunModeVerification("HomePageTest")){
		Object[][] data= inputReader.selectSingleDataOrMulitiData("HomePageTest"); //data=new Object[3][6];
		//First data set
		/*data[0][0]= "HomepageTest_data1";
		data[0][1]="testa";
		data[0][2]="9656756";
		data[0][3]="ADYAR";
		data[0][4]="ADYAR";
		data[0][5]="Sedan";
		
		//second data set
		data[1][0]= "HomepageTest_data2";
		data[1][1]="testb";         // coomments because - weh have bring in excel file
		data[1][2]="9656756";
		data[1][3]="ADYAR";
		data[1][4]="ADYAR";
		data[1][5]="Sedan";
				
				
		//third data set
		
		data[2][0]= "HomepageTest_data3";
		data[2][1]="testa";
		data[2][2]="9656756";
		data[2][3]="ADYAR";
		data[2][4]="ADYAR";
		data[2][5]="Sedan";*/
		
		return data;
		}
		return null;
		
		
	}
	@AfterMethod
	public void teardown(ITestResult it) throws IOException{
		Screenshotgenerator.getScreenshot(it);
	}
	

	}














