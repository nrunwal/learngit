package htmlTestCase1;


import java.io.IOException;

import org.jdom2.JDOMException;
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

public class TC_30466 extends Generic{

	static String TC_Name = "TC_30466";
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
	public static void tc_30466() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Native Mouse Cursors (Multiple browser windows and tabs" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/FPLogoMouseCursor.html";
			String title = "FPLogoMouseCursor";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");


			String image1 = "BackGround";
			expImage = imageFinder(image1);
			Match match = screen.exists(new Pattern(expImage));
			Thread.sleep(500);
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();*/
			Assert.assertNotNull(match, "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			objClick(screen,expImage, ele);
			logger(Test, "Done BTN is clicked", "I");


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




