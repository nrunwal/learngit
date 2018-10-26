package htmlTestCase1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
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
import utill.Imagetest;
import utill.MyRobot;


public class TC_44895 extends Generic{
	static String TC_Name = "TC_44895";
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
	public static void tc_44895() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "Verify SWFbox & new window" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Manual/html/Printing/3221903/crash1.htm";
			String title = "Bug 763237 - [adbe 3210091] Firefox crash in F1398665248_____________________________";
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
			objContextClick(screen,expImage, ele);	

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			Match match = screen.exists(new Pattern(expImage));

			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image2);
			actImagePath = list.get(1).toString();*/
			Assert.assertNotNull(match, "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);
			Thread.sleep(5000);

			Driver.getWindowHandles();
			Assert.assertTrue(new ArrayList<String> (Driver.getWindowHandles()).size()==1,"Second tab is not opened");

			Point point = ele.getLocation();
			MyRobot.getInstance().mouseMove(point.getX()+200, point.getY()+200);
			MyRobot.getInstance().mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
			MyRobot.getInstance().mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
			
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



