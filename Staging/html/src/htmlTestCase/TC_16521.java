package htmlTestCase;
import java.awt.event.KeyEvent;
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
import utill.MyRobot;

/**
 * @author ankjoshi
 * @see : 
 */

@Test
public class TC_16521 extends Generic {

	static String TC_Name = "TC_16521";
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
	public static void tc_16521() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "SeamlessTabbingFalse7" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/SeamlessTabbing/SeamlessTabbingFalse8.html";
			String title = "SeamlessTabbingFalse7";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			robotClick();


			String image1 = "YCapture1";
			expImage = imageFinder(image1);
			actImagePath=printMatcher(screen, TC_Name, expImage, image1);
			imageMatcher(expImage, actImagePath);
			logger(Test, "Initial Screen Matched ", "I");
			objClick(screen,expImage, null);
			logger(Test, "Screen is clicked", "I");

			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(100);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

		
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(100);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(100);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);		
			Thread.sleep(2000);

			String image4 = "YCapture4";
			expImage = imageFinder(image4);
			actImagePath=printMatcher(screen, TC_Name, expImage, image4);
			imageMatcher(expImage, actImagePath);
			logger(Test, "All matched, TestCase Completed ", "I");
			
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
