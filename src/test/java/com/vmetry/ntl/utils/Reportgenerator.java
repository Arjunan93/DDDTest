package com.vmetry.ntl.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntl.initiliazer.Initiliazer;

public class Reportgenerator extends Initiliazer {
	//@Test
	public static void archivefiles() throws IOException{
		if (isArchive){
		SimpleDateFormat sf= new SimpleDateFormat("YYYY-MM-dd HH-mm-SS-mmm");
		String date =sf.format(new Date());
		
		File src = new File ("E:\\selenium\\DDTtest\\Screenshot");
		File dst = new File ("E:\\selenium\\DDTtest\\Screenshot\\old_"+date);
		
		FileUtils.copyDirectory(src,dst);
		FileUtils.cleanDirectory(src);
		isArchive=false;
	}

}
}