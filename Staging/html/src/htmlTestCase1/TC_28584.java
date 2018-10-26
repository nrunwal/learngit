package htmlTestCase1;


import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Location;
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
 *  */

public class TC_28584 extends Generic{

	static String TC_Name = "TC_28584";
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
	public static void tc_28584() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "	SeamlessTabbingDefault" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/browserHTML/SeamlessTabbing/SeamlessTabbingDefault7.htm";
			String title = "SeamlessTabbingDefault7";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			expImage = imageFinder("imgClick");
			objClick(screen, expImage, ele);
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);

			String image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);

			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image2);
			imageMatcher(expImage,actImagePath);
			
			for(int i=1;i<=3;i++){
				logger(Test, "Inside Loop for run "+i, "I");
				
				MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);

				String image3 = "Capture3";
				expImage = imageFinder(image3);
				actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image3);
				imageMatcher(expImage,actImagePath);
				
				MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);

				String image4 = "Capture4";
				expImage = imageFinder(image4);
				actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image4);
				imageMatcher(expImage,actImagePath);

			}

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




