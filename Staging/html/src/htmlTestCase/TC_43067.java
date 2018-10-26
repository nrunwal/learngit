package htmlTestCase;


import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
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
import utill.MyRobot;


public class TC_43067 extends Generic{

	static String TC_Name = "TC_43067";
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
		
		WebElement ele= Driver.findElement(Web.getWebElement("Div"));
		Point point = ele.getLocation();
		
		MyRobot.getInstance().mouseMove(point.getX()+100, point.getY()+100);
		MyRobot.getInstance().mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
		MyRobot.getInstance().mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
		System.out.println("\n\nDone Executing ----------------------"+TC_Name+"----------------------\n\n");

	}

	@SuppressWarnings("static-access")

	@Test
	public static void TC_43067() throws Exception{


		Screen screen = new Screen();
		try
		{

			String testCase = "Verify no OutOfMemory" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Staging/HTML/BugRegressions/2917604/index.html";
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
			Thread.sleep(1000);
			screen.rightClick();
		//	new Actions(Driver).contextClick(ele).build().perform();
			Thread.sleep(500);
		 
			
			
			String image1 = "ContextMenu";
			expImage = imageFinder(image1);
			Match match  = screen.exists(new Pattern(expImage));
			
		/*	List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();*/
			Assert.assertNotNull(match, "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			Thread.sleep(1000);

		
			//new Actions(Driver).doubleClick().build().perform();  

//			String image2 = "Capture1";
//			expImage = imageFinder(image2);
//			actImagePath = printMatcher(screen, TC_Name,expImage,image2);
//			imageMatcher(expImage,actImagePath);

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


