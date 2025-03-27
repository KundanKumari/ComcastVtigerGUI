package practice_testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInformationTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) throws InterruptedException{
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		
		String productname=driver.findElement(By.xpath("//h2[@aria-label=\"Apple iPhone 15 (128 GB) - Pink\"]")).getText();
		System.out.println(productname);
		
		//capture product info 
		String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div/div[1]/div[1]/a/span/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
	    System.out.println(price);
	    driver.quit();
}
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility eu=new ExcelUtility();
		int rowCount =eu.getRowcount("product");
		
		Object[][] objArr = new Object[rowCount][2];
		
		for(int i=0; i<rowCount;i++) {
		objArr[i][0] = eu.getDataFromExcel("product", i+1, 0);
		objArr[i][1] = eu.getDataFromExcel("product", i+1, 1);
		}
		return objArr;
	
	}
	
}