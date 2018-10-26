package htmlTestCase1;
import java.io.IOException;

import org.jdom2.JDOMException;
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
 * @see : 1) Animation should start with the # 1. If not, log bug
 */

@Test
public class TC_29792 extends Generic {

	static String TC_Name = "TC_29792";
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

	@Test
	public static void tc_29792() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Timer2sec" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Staging/HTML/BugRegression/2638189/index.html";
			String title = "HTML Test Case Wrapper";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			

			String image1 = "image1";
			expImage = imageFinder(image1);
			Match match = screen.exists(new Pattern(expImage).similar(0.9f));

			for(int i=0;i<20;i++){
				if(match==null){
					Thread.sleep(500);		
					match = screen.exists(new Pattern(expImage).similar(0.9f));
				}else {
					break ;
				}
			}


			if(match!=null){			
				actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
				System.out.println("Match found breaking the loops");
			}


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
