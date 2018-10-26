package htmlTestCase1;


import java.io.File;

/**
 * @author ankjoshi
 * @see : Follow instructions on test page.
 */

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

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

import utill.Generic;


public class TC_41628 extends Generic{
	static String TC_Name = "TC_41628";
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
	public static void tc_41628() throws Exception{

		Screen screen = new Screen();
		try
		{
			String testCase = "Regression Bug 2846773" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2846773/Bug2846773.html";
			String title = "Bug 2846773 Regression";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");


			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			//WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			//logger(Test, "Flash Element Found: "+ele, "I");

			String image1 = "PrintBtn";
			expImage = imageFinder(image1);
			objClick(screen,expImage, null);
			logger(Test, "BTN is clicked", "I");
			print(TC_Name);
			
			launchSave_Print(TC_Name);
			pdfMatcher(TC_Name);
			//pdfUtil.compare(file1, file2);
			Report.endTest(Test);

		

		}catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;
		}


	}


}
