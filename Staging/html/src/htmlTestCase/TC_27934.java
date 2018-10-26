package htmlTestCase;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;
/**
 * @author runwal
 */


public class TC_27934 extends Generic{

	static String TC_Name = "TC_27934";
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
	public static void TC_27934() throws Exception{

		Screen screen = new Screen();
		try
		{
			

			String testCase = "Kite_again.swf" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/CrashTests/2510928/Kite_again.html";
			String title = "Kite_again.swf";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");
			

			Driver.get(url);
		logger(Test, "Loading:"+url, "I");
		titleMatch(title);
		logger(Test, "Loaded:"+url, "I");
		
			String image1 = "Capture";
			expImage = imageFinder(image1);
			objClick(screen, expImage, null);

			 image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen, TC_Name,expImage,image1);
			imageMatcher(expImage,actImagePath);

			Report.endTest(Test);
			
			Thread.sleep(500);
		
				Report.endTest(Test);
				
			}
			
			
			catch(Exception e){

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
	
