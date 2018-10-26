package htmlTestCase;


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
import utill.Imagetest;


public class TC_41321 extends Generic {
	static String TC_Name = "TC_41321";
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
	public  void tc_41321() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "Verify the test case";
			String url = "http://2867121-1.playercore10.com/PolicyRedirectTest.html";
			String title = "PolicyRedirectTest";

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			//WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			//logger(Test, "Flash Element Found: "+ele, "I");
			
			String image3= "ExpImg1";
			expImage = imageFinder(image3);
			actImagePath = printMatcher(screen, TC_Name,expImage,image3);
			imageMatcher(expImage,actImagePath);


			String image1 = "Btn1";
			expImage = imageFinder(image1);
			/*List<Object> list1 = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list1.get(1).toString();
			Assert.assertNotNull(list1.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);
*/
			objClick(screen,expImage, null);
			Thread.sleep(500);
			logger(Test, "BTN is clicked", "I");
			
			/*Thread.sleep(500);
			print(TC_Name);
			launchSave_Print(TC_Name);*/

			Thread.sleep(1000);
			String image2 = "ExpImg2";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen, TC_Name,expImage,image2);
			imageMatcher(expImage,actImagePath);

			Report.endTest(Test);

		}catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;
		}

	}


}
