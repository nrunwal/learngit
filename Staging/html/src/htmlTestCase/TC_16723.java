package htmlTestCase;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
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
 * @author ymishra
 */


public class TC_16723 extends Generic{

	static String TC_Name = "TC_16723";
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
	public static void tc_16723() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Verify No alert Present" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Security/javaScriptHole/getURLschemeBlockedChars.html";
			String title = "getURLschemeBlockedChars";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");


			
			try{

				Set<String> windows = Driver.getWindowHandles();
				int count = windows.size();
				Assert.assertEquals(1, count,"\n Window is redirected to another page");


				Alert al = Driver.switchTo().alert();
				al.accept();
				logger(Test, "Alert Found !! "+ele, "I");


			}catch(Exception e){
				logger(Test, "Alert Not Found !! "+ele, "I");

				String image1 = "Capture1";
				expImage = imageFinder(image1);
 				actImagePath = getSeleniumSnap(ele, TC_Name, image1);
				imageMatcher(expImage, actImagePath);	
			}
		
			logger(Test, "Test Case Completed !! "+ele, "I");

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



