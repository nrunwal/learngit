package htmlTestCase1;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.basics.OS;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utill.Generic;
import utill.MyRobot;

/**
 * @author abhishekpuri
 * @see :Run the test case. follow instruction.
 */

public class TC_28589 extends Generic
{

	static String TC_Name = "TC_28589";
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
	public static void tc_28589() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Bug 2290104 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2290104/index.html";
			String title = "HTML Test Case Wrapper";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			
			//ele.click();

			robotClick();
			
			Thread.sleep(1000);
			//Robot robot = new Robot();
			MyRobot.getInstance().mouseMove(558,550);
			MyRobot.getInstance().delay(1000);

			//MyRobot.getInstance().mousePress(InputEvent.BUTTON1_DOWN_MASK);
			//MyRobot.getInstance().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			MyRobot.getInstance().delay(2000);

			if (Generic.CURRENTOS.equalsIgnoreCase("win"))
			{
			MyRobot.getInstance().mouseWheel(100);
			MyRobot.getInstance().delay(1000);
			MyRobot.getInstance().mouseWheel(100);
			MyRobot.getInstance().delay(1000);
			MyRobot.getInstance().mouseWheel(100);
			MyRobot.getInstance().delay(1000);
			}
			 //screen.mouseMove(new Region(r));
            // SET THE MOUSE X Y POSITION
           // robot.mouseMove(558, 550);
			else
			{
				MyRobot.getInstance().mouseWheel(-100);
				MyRobot.getInstance().delay(1000);
				MyRobot.getInstance().mouseWheel(-100);
				MyRobot.getInstance().delay(1000);
				MyRobot.getInstance().mouseWheel(-100);
				MyRobot.getInstance().delay(1000);
			}
			
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
