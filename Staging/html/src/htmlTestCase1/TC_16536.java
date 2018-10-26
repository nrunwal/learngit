package htmlTestCase1;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;

/**
 * @author runwal
 * @see : 1)Run swf and click on the button "Add Client-broken" 
 * 2)"Client3" should be added to the list. If not, log a bug.
 * This has been tested to work on mainline 10.2.150.219
 */

@Test
public class TC_16536 extends Generic {

	static String TC_Name = "TC_16536";
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

	@Test
	public static void TC_16536() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Param_qualityHigh" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/Variables/Param/Param_stop.html";
			String title = "Param_stop";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			
			logger(Test, "Flash Element Found: "+ele, "I");
			
			
			//*[@id="Param_stop"]/embed
			String image1 = "Flower";
			expImage = imageFinder(image1);
			//new Pattern();
			//screen.rightClick(pObj2);
		
			actImagePath= printMatcher(screen, TC_Name, expImage, image1);
			Thread.sleep(5000);
			imageMatcher(expImage, actImagePath);
		   //wait few seconds
			Thread.sleep(5000);
			
			imageMatcher(expImage, actImagePath);
			
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
