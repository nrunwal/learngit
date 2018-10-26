package htmlTestCase;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import utill.Generic;
import utill.Imagetest;
import utill.MyRobot;

@Test

public class TC_40520 extends Generic {
	static String TC_Name = "TC_40520";
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
	public static void tc_40520() throws Exception{
		Screen screen = new Screen();
		try
		{

			String testCase = "bug2814734" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2814834/bug2814734_transparentWindowless.html";
			String title = "bug2814734";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			MyRobot.getInstance().delay(500);
			MyRobot.getInstance().mouseMove(100,500);
			Thread.sleep(1000);
			
			String image1 = "Mask_CHM";
			expImage = imageFinder(image1);
			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();
			Assert.assertNotNull(list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);
		*/	actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
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
