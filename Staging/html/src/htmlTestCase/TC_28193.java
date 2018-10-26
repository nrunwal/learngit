package htmlTestCase;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
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


public class TC_28193 extends Generic{

	static String TC_Name = "TC_28193";
	static String actImagePath="";
	static String expImage="";

	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Xml.elementHandler(TC_Name);
		Generic.setCurrentTestBaselinePath(TC_Name);
	}


	@AfterMethod
	public void tc_end(ITestResult result) throws Throwable{
		robotClick();

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
	public static void tc_28193() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Param_menu_false" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/BrowserHTML/Variables/Param/Param_menu_false.html";
			String title = "Param_menu_false";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");



			if(currentOS().contains("mac")){
				MyRobot.getInstance().mouseMove(200, 250);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().mousePress(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
				MyRobot.getInstance().delay(500);
				String image2 = "Capture2";
				expImage = imageFinder(image2);
				actImagePath = printMatcher(screen, TC_Name,expImage,image2);
				imageMatcher(expImage,actImagePath);
				MyRobot.getInstance().mouseRelease(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
				Thread.sleep(5000);
				robotClick();
			}else{
				MyRobot.getInstance().mouseMove(200, 250);
				robotRightClick();

				/*String image1 = "Capture";
			String img = imageFinder(image1);
			objContextClick(screen,img, null);*/
				String image2 = "Capture2";
				expImage = imageFinder(image2);
				actImagePath = printMatcher(screen, TC_Name,expImage,image2);
				imageMatcher(expImage,actImagePath);
				robotClick();
			}

			/*Thread.sleep(1000);
			String image1 = "Capture";
			expImage = imageFinder(image1);
			//List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			//actImagePath = list.get(1).toString();
			//Assert.assertNotNull(list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			logger(Test, "TestCase Completed ", "I");
			Report.endTest(Test);
			return ;
*/ 
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



