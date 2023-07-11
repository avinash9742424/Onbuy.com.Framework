package com.Onbuy.com_Utilityclasses;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public  class ListnerClass_implementation implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
		
		TakesScreenshot tss=(TakesScreenshot)Base_class.tdriver;
		File screenshot =tss.getScreenshotAs(OutputType.FILE);
		LocalDateTime now = LocalDateTime.now();
		String date = now.toString().replace(" ", "_").replace(":", "_");
		File dst = new File("./Screenshots/"+testname+"_"+date+".png");
		try {
			FileUtils.copyFile(screenshot, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
