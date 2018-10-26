package htmlTestCase;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.DataHandler;
import utill.Generic;
import utill.Imagetest;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see : Open up http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/FPLogoMouseCursor.html and 
 * http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/ArrowMouseCursor.html in multiple browser windows and tabs. 
 * You should try a combination of different browsers. 
 * You should only see the mouse cursor as indicated by the instructions within each SWF's stage boundaries. 
 * Even if you overlap browser windows, you should only see the cursor that is indicated by the instructions for that SWF's stage boundary. 
 * It doesn't matter which browser instance has focus currently. It only matters which SWF's stage area has the mouse hovering over it. 
 * NOTE: On OS X, you'll only get the custom cursor for whichever browser window currently has focus on it.
 * Mouse Hover Capture is a challenge needs to be modified
 * 
 */

public class TC_30308 extends Generic{

	static String TC_Name = "TC_30308";
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
	public static void tc_30308() throws Exception{

		Screen screen = new Screen();
		try
		{
			
			String testCase = "Regression media for URL double slash domain issue - bugs 2681676, 2674868 and 2664229" ;
			String url = "http://junk.playercore10.com//123/";
			String title = "Regression media for bugs 2681676, 2674868 and possibly 2664229";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			String image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath= getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage, actImagePath);
			String image2 = "Area1";
			expImage = imageFinder(image2);
			objContextClick(screen, expImage, ele);
			String image3 = "Area2";
			expImage = imageFinder(image3);
			Thread.sleep(1000);
			screen.doubleClick(new Pattern(expImage));
			Thread.sleep(1000);

			String image7 = "Camera_Btn";
			expImage = imageFinder(image7);
			Thread.sleep(1000);
			screen.doubleClick(new Pattern(expImage));
			Thread.sleep(1000);
			String image4 = "Capture2";
			expImage = imageFinder(image4);
			actImagePath= getSeleniumSnap(ele, TC_Name, image4);
			imageMatcher(expImage, actImagePath);
		if(CURRENTBROWSER.equals("edge")|| CURRENTBROWSER.equals("ie")) {
			String image = "Area3";
			expImage = imageFinder(image);
			Thread.sleep(1000);
			screen.doubleClick(new Pattern(expImage));
		}else {
			MyRobot.getInstance().keyPress(KeyEvent.VK_SHIFT);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_SHIFT);
		}
			
		
			Thread.sleep(1000);
			String image5 = "Btn1";
			expImage = imageFinder(image5);
			objClick(screen, expImage, ele);
			String image6 = "Capture3";
			expImage = imageFinder(image6);
			actImagePath= getSeleniumSnap(ele, TC_Name, image6);
			imageMatcher(expImage, actImagePath);
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




