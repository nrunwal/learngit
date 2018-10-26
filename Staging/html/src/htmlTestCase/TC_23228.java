package htmlTestCase;


import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see :Run the test case. follow instruction.
 */

public class TC_23228 extends Generic{

	static String TC_Name = "TC_23228";
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
	public static void tc_23228() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "234860.swf" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/Crash234860/234860.html";
			String title = "234860.swf";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
		
			String image1 = "Capture";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
			imageMatcher(expImage,actImagePath);

		
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




