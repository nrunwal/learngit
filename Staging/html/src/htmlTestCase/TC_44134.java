package htmlTestCase;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
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
import utill.MyRobot;

public class TC_44134 extends Generic {

	static String TC_Name = "TC_44134";
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
	public static void tc_45323() throws IOException, InterruptedException{

		Screen screen = new Screen();
		try
		{
			String testCase = "Verify SWFbox & new window" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Security/BugRegression-HTMLSuite/RespDisc/3126792/3126792.html";
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");


			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

		
			try
			{	
				
				Driver.get(url);
				logger(Test, "Loading:"+url, "I");
				//titleMatch(title);
				logger(Test, "Loaded:"+url, "I");
				Thread.sleep(4000);
				
				WebDriverWait wait1 = new WebDriverWait(Driver, 5);
				wait1.until(ExpectedConditions.alertIsPresent());
				Alert alert1 = Driver.switchTo().alert();
				System.out.println(alert1.getText());
				Assert.assertTrue(alert1.getText().contains("1"), "Alert is skipped or not displayed as expected");
				alert1.accept();
		
				//Alert alert=Driver.switchTo().alert();
				//System.out.println(alert.getText());
				//alert.accept();
			
			}
			catch(Exception e){	
				
			System.out.println("Test Case Fail !!");
			
			}

			//MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
			//MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);

			
			//Thread.sleep(2000);
			
		}catch(Exception e){

		}


	}

}
