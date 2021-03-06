package htmlTestCase;


import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
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


public class TC_20819 extends Generic {
	static String TC_Name = "TC_20819";
	static String actImagePath="";
	static String expImage="";

	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Xml.elementHandler(TC_Name);
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
	public  void tc_20819() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "load bad swf Refresh Crash " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/loadRefreshCrash.html";
			String title = "loadRefreshCrash.swf";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(By.xpath("/html/body/object"));
			logger(Test, "Flash Element Found: "+ele, "I");
			//ele.click();
			
			Thread.sleep(1000);
			String image2 = "ExpImg1";
			expImage = imageFinder(image2);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
			imageMatcher(expImage,actImagePath);

			Thread.sleep(1000);
			//String image3 = "Btn";
			expImage = imageFinder("Btn");
			objClick(screen, expImage, ele);

			
			Thread.sleep(1000);
			String image1 = "ExpImg2";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
			imageMatcher(expImage,actImagePath);
			//Driver.navigate().refresh();

		
			logger(Test, "TestCase Completed ", "I");

			Report.endTest(Test);

		}catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;
		}

	}


}
