package htmlTestCase;


import java.io.File;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC_16703 extends Generic {
	static String TC_Name = "TC_16703";
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
	public  void tc_16703() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "	PrintJobAPI_RelativePath";
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Printing/PrintJobAPI_RelativePaths/PrintJobAPI_RelativePath.html";
			String title = "PrintJobAPI_RelativePath";

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			//screen.click();
			//WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			//logger(Test, "Flash Element Found: "+ele, "I");
			robotClick();

			for(int i=1;i<=2;i++){

				String image1 = "PrintBtn"+i;
				expImage = imageFinder(image1);
				objClick(screen,expImage, null);
				logger(Test, "BTN is clicked", "I");
				print(TC_Name);

				launchSave_Print(TC_Name);
				Thread.sleep(2000);
				PDFUtil pdfUtil = new PDFUtil();
				String locationName = null;
				locationName=new File(Generic.getOutputPath()+File.separator+"Screenshot"+File.separator+TC_Name+".pdf").getAbsolutePath();
				pdfUtil.getPageCount(locationName);
				String file1=locationName;
				System.out.println("file1 "+file1);
				String file2=Generic.getCurrentTestBaselinePath()+File.separator+TC_Name+".pdf";
				System.out.println("file2 "+file2);
				logger(Test, "Comparing File1:"+file1+"\nFile2:"+file2, "I");

				pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
				boolean flag = pdfUtil.compare(file1, file2);
				Assert.assertTrue(flag,"Compare Flag found false- PDF's are not matched as expected");
				logger(Test, "Print PDF's Compared Successfully !!", "I");
			}
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
