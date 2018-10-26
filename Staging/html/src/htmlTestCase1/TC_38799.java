package htmlTestCase1;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;

/**
 * @author ankjoshi
 * @see : 1)Spicy 10.2 or later
Run URL for 20 seconds. If slow script dialog appears, press "Yes" to dismiss it. Verify no crash occurs.
Reload page a few times and verify still no crash.
 */

@Test
public class TC_38799 extends Generic {

	static String TC_Name = "TC_38799";
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
	public static void tc_38799() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Regression media for bug 2752288 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/fuzzed/2752288/";
			String title = "2747834";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele1= Driver.findElement(Web.getWebElement("Div1"));
			WebElement ele2= Driver.findElement(Web.getWebElement("Div2"));
			logger(Test, "Flash Element Found: "+ele1+ele2, "I");

			Driver.navigate().refresh();
			Driver.navigate().refresh();
			Driver.navigate().refresh();
			Driver.navigate().refresh();
			
			
			String image1 = "Capture1";
			expImage = imageFinder(image1);
			//Through selenium giving stale reference exception
			actImagePath = printMatcher(screen, TC_Name,expImage,image1);
			imageMatcher(expImage,actImagePath);
			

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen, TC_Name,expImage,image2);
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
