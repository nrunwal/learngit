package htmlTestCase1;


import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;


/**
 * @author ankjoshi
 * @see :Run the test in the link, ensure that the Japanese fonts for each row of FTE text look different.



 */

public class TC_28629 extends Generic{

	static String TC_Name = "TC_28629";
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
	public static void tc_28629() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Test 2541598 " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2541598/GenericFontsFTE.html";
			String title = "GenericFontsFTE";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			
			WebElement ele = Driver.findElement(By.xpath("/html/body"));

			if(currentOS().contains("mac")){
				String image1 = "download";
				expImage = imageFinder(image1);
				Match match = screen.exists(new Pattern(expImage));
				if(match!=null) {
					objClick(screen, expImage, ele);
					Driver.navigate().refresh();
					ele = Driver.findElement(By.xpath("/html/body"));
				}
			}
			
						

			String image2 = "background";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen,TC_Name,expImage,image2);
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




