package practice_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {

//basically retry anylyzer listener functionality is used to retry only the failed test script
@Test(retryAnalyzer = com.comcast.crm.generic.listenerutility.retryListenerImplement.class)
	public void activatesim() {
		System.out.println("Execute activatesim");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
