package htmlTestCase;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

import utill.Generic;
import utill.MyRobot;
/**
 * @author ankjoshi
 * @see : Please follow instructions on the test page.
 * (Only applicable to windows 7 Internet Explorer, skip it on win 8.1/win 10) 1. Click the link to run the test 
2. From the browser's menu, File -> Print Preview 
3. Make sure that the content scale is not shrunk 
Note: The content of this flash has a blue outer rectangle and a red inner rectangle. p.s. There is a deferred bug 3343136 on Mac l & Win plugin from FP11
 * 
 * 
 */
public class TC_30011 extends Generic {
	static String TC_Name = "TC_30011";
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
	public  void tc_30011() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Browser Printing test - (bug 2677391)";
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Printing/2677391/BrowserPrintTest.html";
			String title = "";

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
			robotRightClick();

			if(CURRENTBROWSER.contains("edge")){
				Thread.sleep(1000);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_DOWN);
				
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_UP);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_UP);
				
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
			}else if(CURRENTOS.contains("mac")){
				Thread.sleep(1000);
				String image1 = "PrintBtn";
				expImage = imageFinder(image1);
				objContextClick(screen,expImage, null);
				
				Thread.sleep(1000);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_P);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_P);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
												
			}else{
			
				Thread.sleep(1000);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyPress(KeyEvent.VK_P);
				MyRobot.getInstance().delay(500);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_P);
				Thread.sleep(1000);
							
			}
			
			System.out.println("Print Clicked");
			print(TC_Name);
			Thread.sleep(1000);
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
