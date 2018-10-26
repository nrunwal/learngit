package htmlTestCase1;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import utill.Imagetest;

/**
 * @author ankjoshi
 * @see : Please follow instructions on the test page.
 * Flash Player Protected Mode enabled(The default is enabled.),
 * Right-click the non-text portion at the bottom of the Flash movie and choose "Print..."
 *  from the context menu.The printout should be wrapped correctly.
 */
public class TC_44994 extends Generic {
	static String TC_Name = "TC_44994";
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
	public  void tc_44994() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "The printout of dynamic multiline text should be wrapped correctly(Bug3282532)";
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Manual/html/Printing/3282532/printBug.html";
			String title = "horse";

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			String image1 = "Capture1";
			expImage = imageFinder(image1);
			objContextClick(screen,expImage, ele);	
			
			String image2 = "Capture2";
			expImage = imageFinder(image2);
			objClick(screen,expImage, ele);	
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
