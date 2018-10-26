package htmlTestCase1;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see :Follow the instruction in the bug page


 */

public class TC_28637 extends Generic{

	static String TC_Name = "TC_28637";
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
	public static void tc_28637() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Bug 2477654  " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2477654/2477654.html";
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ScrollToNext = Driver.findElement(By.xpath("/html/body/p[9]/object"));
			((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", ScrollToNext);
			Thread.sleep(500);		

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");


			String image1 = "textBox";
			expImage = imageFinder(image1);
			objClick(screen, expImage, ele);

			Robot myrobot = new Robot();
			myrobot.delay(1000);
			myrobot.keyPress(KeyEvent.VK_ENTER);
			myrobot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			myrobot.delay(1000);
			myrobot.mouseMove(200, 200);
			myrobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			myrobot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			
			String image2 = "Capture1";
			expImage = imageFinder(image2);
			objClick(screen, expImage, ele);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
			imageMatcher(expImage,actImagePath);

			expImage = imageFinder("textBox");
			objClick(screen, expImage, ele);
			MyRobot.getInstance().keyPress(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyPress(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_BACK_SPACE);
			screen.type("94");
			MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);

			myrobot.delay(1000);
			myrobot.mouseMove(200, 200);
			myrobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			myrobot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			
			Thread.sleep(500);
			String image3 = "Capture2";
			expImage = imageFinder(image3);
			objClick(screen, expImage, ele);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);
			imageMatcher(expImage,actImagePath);

			expImage = imageFinder("textBox2");
			screen.click(new Pattern(expImage).exact());

			MyRobot.getInstance().keyPress(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyPress(KeyEvent.VK_BACK_SPACE);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_BACK_SPACE);
			screen.type("105");
			MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
			myrobot.delay(1000);
			myrobot.mouseMove(200, 200);
			myrobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			myrobot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			
			Thread.sleep(500);
			String image4 = "Capture3";
			expImage = imageFinder(image4);
			objClick(screen, expImage, ele);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image4);
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




