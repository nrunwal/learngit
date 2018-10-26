package htmlTestCase;


import java.io.IOException;

import org.jdom2.JDOMException;
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
 * @see :Run the test case. follow instruction.
 */

public class TC_45360 extends Generic{

	static String TC_Name = "TC_45360";
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
	public static void tc_45360() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Regression test for 3293809" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Security/BugRegression-HTMLSuite/RespDisc/3293809/index_MSVCR71.html";
			//Crash Url http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/InfiniteLoopDialogBox/infinite_loops.html
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
			
		
			String image1 = "CrashChrome";
			expImage = imageFinder(image1);
			Thread.sleep(1000);
			Pattern pObj = new Pattern(expImage);
			Match match = screen.exists(pObj);
			Assert.assertNull(match,"Match is not found null as expected for image"+expImage);
			
			
			String image2 = "Capture";
			expImage = imageFinder(image2);
			Thread.sleep(1000);
			Pattern pObj1 = new Pattern(expImage);
			Match match1 = screen.exists(pObj1);
			Assert.assertNotNull(match1,"Match is found null as expected for image"+expImage);
			
			
		//	imageMatcher(expImage,actImagePath);

		
			logger(Test, "TestCase Completed ", "I");

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




