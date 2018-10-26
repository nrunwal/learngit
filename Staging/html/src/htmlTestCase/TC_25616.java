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


public class TC_25616 extends Generic{

	static String TC_Name = "TC_25616";
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
	public static void tc_25616() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "FlashVars Crash Bug 2453617 Regression" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/FlashVars/Bug_2453617.html";
			String title = "Untitled Document";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");
            

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");
			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

	        Driver.findElement(By.linkText("Click Me")).click();
	        Thread.sleep(5000);
			String image1 = "Capture";
			
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen, TC_Name,expImage,image1);
			imageMatcher(expImage,actImagePath);


			/*Thread.sleep(1000);
			String image1 = "Capture";
			expImage = imageFinder(image1);
			//List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			//actImagePath = list.get(1).toString();
			//Assert.assertNotNull(list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			logger(Test, "TestCase Completed ", "I");
			Report.endTest(Test);
			*/return ;


		}catch(Exception e){

			logger(Test, e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;

		}catch(AssertionError a){
			logger(Test, a.getMessage(), "F");
			Report.endTest(Test);
			a.getStackTrace();
			throw a;
		}


	}

}


