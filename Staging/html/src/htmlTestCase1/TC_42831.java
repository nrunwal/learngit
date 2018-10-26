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

import utill.DataHandler;
import utill.Generic;


/**
 * @author ankjoshi
 * @see : Run the test on next page, if the test gets loaded without a crash, it is a pass, test done


 */

public class TC_42831 extends Generic{

	static String TC_Name = "TC_42831";
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
	public static void tc_42831() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Bug 3001456 Regression " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/3001456/module_8.html";
			String title = "Bug 3001456 Regression";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			Thread.sleep(500);
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			Thread.sleep(600);
			String image1 = "Capture1";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);

			String image2 = "Capture2";
			expImage = imageFinder(image2);

			Thread.sleep(500);
			objClick(screen, expImage, ele);

			String image3 = "Next";
			expImage = imageFinder(image3);

			Thread.sleep(600);
			objClick(screen, expImage, ele);

			Thread.sleep(5000);

			String image4 = "Capture33";
			expImage = imageFinder(image4);
			objClick(screen, expImage, ele);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image4);
			Match match4=screen.exists(new Pattern(expImage).exact());
			Assert.assertNotNull(match4,"Match found null for image: "+image4);

			String image5 = "Menu";
			expImage = imageFinder(image5);
			objClick(screen, expImage, ele);

			Thread.sleep(600);
			String image6 = "Capture4";
			expImage = imageFinder(image6);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image6);
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




