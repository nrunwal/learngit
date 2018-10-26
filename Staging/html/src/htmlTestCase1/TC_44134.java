package htmlTestCase1;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.DataHandler;
import utill.Generic;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see : Open up http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/FPLogoMouseCursor.html and 
 *1. FP should not crash in FF and Chrome 2. When opened in IE, 
 *FP should not crash or it should not open the calculator app every 500 ms(setTimeout("loadFlash()", 500);)

 */

public class TC_44134 extends Generic{

	static String TC_Name = "TC_44134";
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
	public static void tc_44134() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Regression of 3126792 (PSIRT 1153) - IE only	" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Security/BugRegression-HTMLSuite/RespDisc/3126792/3126792.html";
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");


			MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);     
			MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);     


			String image1 = "BackGround";
			expImage = imageFinder(image1);

			Thread.sleep(500);
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);

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




