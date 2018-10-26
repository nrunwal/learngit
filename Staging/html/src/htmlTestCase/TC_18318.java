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


public class TC_18318 extends Generic {
	static String TC_Name = "TC_18318";
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
	public  void tc_18318() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "	JSObjecttoFlash " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/BrowserHTML/JavaScript/JSObject/JSObjecttoFlash.html";
			String title = "Send a Javascript Object to Flash via ExternalInterface with a space at the beginning and end";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(By.xpath("/html/body/input"));
			logger(Test, "Flash Element Found: "+ele, "I");
			ele.click();
			
//			Thread.sleep(1000);
//			String image2 = "ExpImg1";
//			expImage = imageFinder(image2);
//			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
//			imageMatcher(expImage,actImagePath);

			//String image3 = "Btn";
			//expImage = imageFinder("Btn");
			//objClick(screen, expImage, ele);

			
			Thread.sleep(1000);
			String image1 = "ExpImg";
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
