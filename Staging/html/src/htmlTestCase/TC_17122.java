package htmlTestCase;


import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;


/**
 * @author ankjoshi
 *  @see :Run the test case. follow instruction.
 * For each test configuration, we will compare the quality of scaled down image between Pre 
 * Play_9_0_r40d36 builds and current FP9. The passing criteria is current FP9 produces higher quality output with reduced dropout artifacts.
 *  Recommend using SAP to compare the performance. Each test should switch Monitor display to 8, 16 and 32 bit. 
 *  Platform support 1.Vista, XP, Win 2000 2.Mac PPC, MacTel 3.RedHat, SUSE, Solaris, Ubuntu Mobile Testing: Even though this may not be supported on 
 *  the mobile device you are testing, please run this test case to insure the test does not cause a crash
 */

public class TC_17122 extends Generic{

	static String TC_Name = "TC_17122";
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
	public static void tc_17122() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "AS3_load_32bit.swf" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/AnimationAndRendering/MipmapSupport/QualityTest/AS3_load_32bit.html";
			String title = "AS3_load_32bit.swf";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
			Thread.sleep(1000);
		
			String image1 = "Capture";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
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




