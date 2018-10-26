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
 * @see : 1)Run swf and click on the button "Add Client-broken" 
 * 2)"Client3" should be added to the list. If not, log a bug.
 * This has been tested to work on mainline 10.2.150.219
 */

@Test
public class TC_33800 extends Generic {

	static String TC_Name = "TC_33800";
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
	public static void tc_33800() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "XMLListCollection sort regression bug#2664346" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Staging/HTML/BugRegression/2664346/index.html";
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

			String image1 = "Capture1";
			expImage = imageFinder(image1);
			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();
			Assert.assertNotNull(list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);
	*/		actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			logger(Test, "Font is Matched ", "I");

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			objClick(screen,expImage, ele);

			logger(Test, "BTN is clicked", "I");
			Driver.findElement(By.xpath("/html/body")).click();

			String image3 = "Capture3";
			expImage = imageFinder(image3);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image3);
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
