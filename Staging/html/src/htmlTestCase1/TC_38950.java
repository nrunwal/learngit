package htmlTestCase1;
import java.io.IOException;
import java.util.List;

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
 * @see : This test attempts to send a Javascript Object to Flash via ExternalInterface with a space at the beginning and end
 */

@Test
public class TC_38950 extends Generic {

	static String TC_Name = "TC_38950";
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
	public static void tc_38950() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "JS Object name " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/BrowserHTML/JavaScript/JSObject/JSObjecttoFlash.html";
			String title = "Send a Javascript Object to Flash via ExternalInterface with a space at the beginning and end";
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
			Match match = screen.exists(new Pattern(expImage));

			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();*/
			Assert.assertNotNull(match, "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			objClick(screen,expImage, ele);
			logger(Test, "BTN is clicked", "I");
			Thread.sleep(2000);
			String image3 = "Capture3";
			expImage = imageFinder(image3);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);
			imageMatcher(expImage,actImagePath);
			logger(Test, "Font is Matched ", "I");

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
