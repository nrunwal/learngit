package htmlTestCase;


import java.io.IOException;

import org.jdom2.JDOMException;
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


/**
 * @author ankjoshi
 * @see :Run the test case. follow instruction.
 */

public class TC_16587 extends Generic{

	static String TC_Name = "TC_16587";
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
	public static void tc_16587() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "RSO_onSync" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/ClientServer/FlashCom/RSO_onSync.htm";
			String title = "RSO_onSync";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");

			
			Thread.sleep(5000);
			boolean testPass;
			Match match;
			for(int i=0;i<=5;i++){
				String image1 = "Capture";
				expImage = imageFinder(image1);
				actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
				match = screen.exists(new Pattern(expImage).exact());
				if(match!=null){
					Assert.assertNotNull(match,"Match is found null for the expected img");
					break;
				}else{
					image1 = "Capture1";
					expImage = imageFinder(image1);
					match = screen.exists(new Pattern(expImage).exact());
				}
				Driver.navigate().refresh();
				Thread.sleep(1000);

			}
			
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




