package htmlTestCase;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utill.Generic;
import utill.Imagetest;


public class TC_42239 extends Generic{
	static String TC_Name = "TC_42239";
	static String actImagePath="";
	static String expImage="";

	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Generic.setCurrentTestBaselinePath(TC_Name);
	}


	@AfterMethod
	public void tc_end(ITestResult result) throws Throwable{

		if(result.getStatus() == ITestResult.FAILURE)
		{ 
			String methodName=result.getName().toString().trim();
			Generic.appendxml(expImage,actImagePath,methodName);
			System.out.println("\n***********Test Failed***********");
		}
		System.out.println("\n\nDone Executing ----------------------"+TC_Name+"----------------------\n\n");

	}

	@SuppressWarnings("static-access")

	@Test
	public static void tc_42239() throws Exception{

		try
		{

			String testCase = "Verify SWFbox & new window" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/BugRegression-HTMLSuite/RespDisc/2962383/2962383.html";
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");


			List<WebElement> weColl=  Driver.findElements(By.xpath("//p[@class='oneColLiqCtr']//a"));
			int collSIZE=weColl.size();
			for(int i=0;i<=collSIZE-1;i++){
				Thread.sleep(1000);
				weColl=  Driver.findElements(By.xpath("//p[@class='oneColLiqCtr']//a"));
				WebElement weObj= weColl.get(i);
				String weName=weObj.getText();
				weObj.click();
				try{
					Driver.switchTo().alert();
					logger(Test, weName+":- Alert is present","F");
				}catch(NoAlertPresentException e){
					logger(Test, weName+":- Alert is not present","I");
				}
				Driver.navigate().back();

			}


			logger(Test, "Test case is done", "I");
			Report.endTest(Test);


		}catch(AssertionError e){
			logger(Test, e.getMessage(),"F");
			Report.endTest(Test);
			throw e;

		}catch(Exception e){
			logger(Test,e.getMessage(),"F");
			Report.endTest(Test);
			throw e;
		}




	}

}



