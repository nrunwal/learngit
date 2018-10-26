package htmlTestCase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.sikuli.script.*;

import utill.Generic;
import utill.Imagetest;

@Test

public class TC_20659 extends Generic {


	static String TC_Name = "TC_20659";
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
	public static void tc_20659() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "Firefox JAR protocol";
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/JarProtocol/";
			String title = "flashjar";

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			String image1 = "Capture";
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen, TC_Name,expImage,image1);
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
