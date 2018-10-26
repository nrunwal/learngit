package htmlTestCase1;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;

/**
 * @author ankjoshi
 * @see : 	DO NOT FOLLOW THE INSTRUCTIONS ON THE ATS TESTCASE ITSELF. 
Click on the fullscreen button then escape to get out. Repeat this nine times. Verify that the browser doesn't crash.
 * 
 */

@Test
public class TC_39241 extends Generic {

	static String TC_Name = "TC_39241";
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
			MyRobot.getInstance().keyPress(KeyEvent.VK_ESCAPE);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_ESCAPE);
			String methodName=result.getName().toString().trim();
			Generic.appendxml(expImage,actImagePath,methodName);
			System.out.println("\n***********Test Failed***********");
		}
		System.out.println("\n\nDone Executing ----------------------"+TC_Name+"----------------------\n\n");

	}

	@Test
	public static void tc_39241() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "	FullScreen on and off 10x" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Staging/ATS.html?testID=29406";
			String title = "ATS9 AS3";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			
			for(int i=0;i<=6;i++){
				
				Thread.sleep(1000);
				String image1 = "fullModeOff";
				expImage = imageFinder(image1);
				objClick(screen,expImage, ele);
				
				Thread.sleep(1000);
				String image2 = "fullModeOn";
				expImage = imageFinder(image2);
				objClick(screen,expImage, ele);
			}
			
			
			String image3 = "Capture1";
			expImage = imageFinder(image3);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);
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
