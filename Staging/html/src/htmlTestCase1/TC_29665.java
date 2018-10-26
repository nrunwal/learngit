package htmlTestCase1;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 * @see : 1
 */

@Test
public class TC_29665 extends Generic {

	static String TC_Name = "TC_29665";
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
	public static void tc_29665() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "bug 2548140 regression  " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/MouseEvents/Bug_2548140/2548140.html";
			String title = "2548140";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele1= Driver.findElement(Web.getWebElement("Div1"));
			WebElement ele2= Driver.findElement(Web.getWebElement("Div2"));
			logger(Test, "Flash Element Found: "+ele1+";"+ele2, "I");

			String image1 = "Green";
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen, TC_Name,expImage,image1);
			imageMatcher(expImage,actImagePath);

			String image2 = "Green2";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen, TC_Name,expImage,image2);
			imageMatcher(expImage,actImagePath);

			WebElement ScrollToNext = Driver.findElement(By.xpath("//*[@id='flashContent']/p[30]"));
			((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", ScrollToNext);
			String text = ScrollToNext.getText();
			Assert.assertTrue(text.equals("END"),"End of page is not found as per the testcase");

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
