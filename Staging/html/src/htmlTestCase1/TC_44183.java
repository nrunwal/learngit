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
 * @see : 1)Open the URL 3. verify text and graphic get render on the complex text
 */

@Test
public class TC_44183 extends Generic {

	static String TC_Name = "TC_44183";
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
	public static void tc_44183() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Regression of 3023249 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/3023249/index.html";
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

		/*	String image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
			imageMatcher(expImage,actImagePath);
			objClick(screen,expImage, ele);
			Thread.sleep(1000);

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
			imageMatcher(expImage,actImagePath);
			objClick(screen,expImage, ele);
			Thread.sleep(1000);*/

			ele.click();
			Thread.sleep(1000);

			ele.click();
			Thread.sleep(1000);

			ele.click();
			Thread.sleep(1000);

			ele.click();
			Thread.sleep(1000);

						
			String image3 = "Capture3";
			expImage = imageFinder(image3);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);
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
