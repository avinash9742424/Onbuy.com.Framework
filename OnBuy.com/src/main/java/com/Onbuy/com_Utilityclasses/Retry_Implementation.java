package com.Onbuy.com_Utilityclasses;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Implementation implements IRetryAnalyzer{
    
	int count=0;
	int retryLimit=3;
	
	public boolean retry(ITestResult result) {
		if (count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}
    
	
	
}
