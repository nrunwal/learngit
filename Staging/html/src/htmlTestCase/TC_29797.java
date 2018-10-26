package htmlTestCase;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
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
import utill.MyRobot;

@Test

public class TC_29797 extends Generic {

	static String TC_Name = "TC_29797";
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
	public static void tc_29797() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "BugRegression/2550027" ;
			String url = "http://ats.macromedia.com/players/ATS/OTS/OTS10/BugRegression/2550027/TextInput.html";
			String title = "Untitled Document";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			String image1 = "Textfield1";
			expImage = imageFinder(image1);
			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();
			Assert.assertNotNull(list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);
*/
			Thread.sleep(500);
			Match match= screen.exists(new Pattern(expImage));
			match.click();

			Thread.sleep(1000);
			match.type("\n");
			Thread.sleep(500);

			Driver.findElement(By.xpath("/html/body")).click();

			String image2 = "Result";
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