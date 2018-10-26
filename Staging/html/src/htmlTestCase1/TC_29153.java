package htmlTestCase1;


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
 * @see : Press the square to toggle fullscreen. Make sure no other keys other than arrow keys, spacebar, and tab ouputs keycodes.


 */

public class TC_29153 extends Generic{

	static String TC_Name = "TC_29153";
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
	public static void tc_29153() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "full screen keyboard test: arrow, space, tab  " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2209273/fsTest.html";
			String title = "fsTest";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");


			String image1 = "fullScreenOn";
			expImage = imageFinder(image1);
			objClick(screen, expImage, ele);

			Thread.sleep(500);
			MyRobot.getInstance().keyPress(KeyEvent.VK_RIGHT);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_RIGHT);

			MyRobot.getInstance().keyPress(KeyEvent.VK_LEFT);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_LEFT);

			MyRobot.getInstance().keyPress(KeyEvent.VK_UP);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_UP);
			
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_DOWN);
			
			MyRobot.getInstance().keyPress(KeyEvent.VK_SPACE);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_SPACE);

			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);

			MyRobot.getInstance().keyPress(KeyEvent.VK_A);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_A);

			MyRobot.getInstance().keyPress(KeyEvent.VK_B);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_B);
			Thread.sleep(500);

			String image2 = "Background";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen,TC_Name,expImage,image2);
			imageMatcher(expImage,actImagePath);

			String image3 = "fullScreenOff";
			expImage = imageFinder(image3);
			objClick(screen, expImage, ele);
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




