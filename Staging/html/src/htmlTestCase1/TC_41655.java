package htmlTestCase1;


import java.io.IOException;

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
/**
 * @author ankjoshi
 * @see : 	Follow the instructions to load viewSource.swf from local, SecurityError #2028 should be thrown. For FP 11.0.1.120 and above.
 * 
 */

public class TC_41655 extends Generic{
	static String TC_Name = "TC_41655";
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

	@Test
	public static void tc_41655() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "Regression test for 2943761 (PSIRT 1040)" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Security/BugRegression-HTMLSuite/RespDisc/2943761/regression.html";
			String title = "Bug regression of #2943761";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");


			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			
			Driver.findElement(By.partialLinkText("this link")).click();
			Thread.sleep(500);

		

			String image1 = "Security";
			expImage = imageFinder(image1);
			
			String image2 = "okBtn";
			expImage = imageFinder(image2);
			objClick(screen,expImage, ele);
			logger(Test, "BTN is clicked", "I");

			Thread.sleep(500);
			String image3 = "bG";
			expImage = imageFinder(image3);
			Match match = screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match,"Match is found as expected for img"+expImage);

			logger(Test, "Font is Matched ", "I");
			Report.endTest(Test);

		}catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;
		}




	}


}
