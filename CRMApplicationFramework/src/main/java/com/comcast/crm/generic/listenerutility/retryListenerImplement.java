package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryListenerImplement implements IRetryAnalyzer {

	int count =0;
	int limitcount=5;
	public boolean retry(ITestResult result) {
		if(count<limitcount) {
			
			count++;
			return true;
		}
		return false;
	}
}
