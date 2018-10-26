package htmlTestCase1;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.JavascriptExecutor;
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
 * @see :	Follow Instruction on the test page
 */

public class TC_41627 extends Generic{

	static String TC_Name = "TC_41627";
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
	public static void tc_41627() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "Regression Bug 2930617 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2930617/FormComboBox.html";
			String title = "Bug 2930617 Regression";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			JavascriptExecutor jse = (JavascriptExecutor) Driver;
			jse.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(2000);
			
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			expImage = imageFinder("clickBtn1");
			objClick(screen,expImage, ele);
			expImage = imageFinder("downClick");
			objClick(screen,expImage, ele);
			MyRobot.getInstance().mouseMove(500, 500);
			Thread.sleep(1000);			

			String image1 = "Capture3";
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen,TC_Name,expImage,image1);
			imageMatcher(expImage,actImagePath);

			/*expImage = imageFinder("clickBtn3");
			objClick(screen,expImage, ele);
			Thread.sleep(1000);			
			MyRobot.getInstance().keyPress(KeyEvent.VK_A);;
			MyRobot.getInstance().keyRelease(KeyEvent.VK_A);;
			expImage = imageFinder("downClick");
			objClick(screen,expImage, ele);
			MyRobot.getInstance().mouseMove(500, 500);
			Thread.sleep(2000);			

			String image3 = "";

			image3 = "Capture3";
			expImage = imageFinder(image3);

			Match match1=screen.exists(new Pattern(expImage));

			if(match1==null){
				logger(Test,"First Match Found Null Looking for another match","I");
				image3 = "Capture33";
				expImage = imageFinder(image3);
			}


			actImagePath = printMatcher(screen,TC_Name,expImage,image3);
			imageMatcher(expImage,actImagePath);	

			expImage = imageFinder("clickBtn2");
			objClick(screen,expImage, ele);

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen,TC_Name,expImage,image2);
			imageMatcher(expImage,actImagePath);*/

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
