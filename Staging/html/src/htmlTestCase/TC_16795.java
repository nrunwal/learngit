package htmlTestCase;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
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

@Test

public class TC_16795 extends Generic {

	static String TC_Name = "TC_16795";
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
	public static void tc_16795() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "HTMLvars_URLQueryStringVariable" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/browserHTML/Variables/Vars%20in%20HTML/Other%20Testcases/HTMLvars_URLQueryStringVariable.html";
			String title = "HTMLvars_URLQueryStringVariable";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			Thread.sleep(1500);

			String image1 = "Link";
			expImage = imageFinder(image1);
			objClick(screen,expImage, ele);

			Thread.sleep(2000);
			String image2 = "Result";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen, TC_Name,expImage,image2);
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
