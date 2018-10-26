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
 * @see :Instruction:
1. Click 'Load External Text' button (while use code page is false by default)
2. Check the first Textfield load Jp or combination UTF 8 character and DE or combination of Higher ASCII character/string, the second Textfield load German or combination of Higher ASCII character/string. (Be sure you have JP and DE code page installed for this case)
3. Reload the case, then click 'Use Code Page' to set it to true and then click 'Load External Text'
4. Check the first Textfield load Jp and DE or combination of Higher ASCII character/string, the second Text field load German or combination of Higher ASCII character/string.Instruction:
1. Click 'Load External Text' button (while use code page is false by default)
2. Check the first Textfield load Jp or combination UTF 8 character and DE or combination of Higher ASCII character/string, the second Textfield load German or combination of Higher ASCII character/string. (Be sure you have JP and DE code page installed for this case)
3. Reload the case, then click 'Use Code Page' to set it to true and then click 'Load External Text'
4. Check the first Textfield load Jp and DE or combination of Higher ASCII character/string, the second Text field load German or combination of Higher ASCII character/string.
 */

public class TC_28585 extends Generic{

	static String TC_Name = "TC_28585";
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
	public static void tc_28585() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "CodePageTestAS3 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/codePage/CodePageTestAS3.html";
			String title = "CodePageTestAS3";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			expImage = imageFinder("loadExtBtn");
			objClick(screen, expImage, ele);

			Thread.sleep(1000);
			String image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			//Driver.navigate().refresh();

			expImage = imageFinder("useCodeBtn");
			objClick(screen, expImage, ele);
			Thread.sleep(1000);
			expImage = imageFinder("loadExtBtn");
			objClick(screen, expImage, ele);

			Thread.sleep(1000);
			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image2);
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




