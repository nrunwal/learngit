package htmlTestCase;


import java.io.File;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.Imagetest;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;
/**
 * @author ankjoshi
 * @see : Please follow instructions on the test page.
 * 
 */
public class TC_16697 extends Generic {
	static String TC_Name = "TC_16697";
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
	public  void tc_16697() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "grid";
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Printing/PrintJobAPI_PrintArea/grid.html";
			String title = "grid";

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			if(CURRENTBROWSER.contains("ie")){
				WebDriverWait wait = new WebDriverWait(Driver, 5);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = Driver.switchTo().alert();
				alert.dismiss();
				Driver.navigate().refresh();
				Thread.sleep(2000);
			}
			
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
