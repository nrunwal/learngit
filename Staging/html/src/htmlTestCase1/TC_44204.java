package htmlTestCase1;


import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.DataHandler;
import utill.Generic;


/**
 * @author ankjoshi
 * @see : Follow the instructions on the page.


 */

public class TC_44204 extends Generic{

	static String TC_Name = "TC_44204";
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
	public static void tc_44204() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Regression of 3057411 (PSIRT 1093) Clickjacking" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Security/BugRegression-HTMLSuite/RespDisc/3057411.html";
			String title = "Regression of bug #3057411 \"[PSIRT ID 1093] Clickjacking, Adobe Flash Macromedia Website\"";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");


			Thread.sleep(500);
			WebElement ele1= Driver.findElement(Web.getWebElement("Div1"));
			WebElement ele2= Driver.findElement(Web.getWebElement("Div2"));
			logger(Test, "Flash Element Found: "+ele1+"; "+ele2, "I");
			
			String image1 = "Div1";
			expImage = imageFinder(image1);	
			actImagePath = Generic.getSeleniumSnap(ele1, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			
			String image2 = "Div2";
			expImage = imageFinder(image2);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
			imageMatcher(expImage,actImagePath);

			Report.endTest(Test);

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




