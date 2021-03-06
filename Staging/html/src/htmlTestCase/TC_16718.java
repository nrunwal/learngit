package htmlTestCase;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
/**
 * @author ymishra
 */


public class TC_16718 extends Generic{

	static String TC_Name = "TC_16718";
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
	public static void tc_16718() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Verify the alert" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Security/allowDomainChanges/inboundScripting_GP_secure.htm";
			String title = "";
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
			objClick(screen, expImage, ele);

			Driver.findElement(By.linkText("GetVariable")).click();
			Thread.sleep(3000);

			

			try
			{
				WebDriverWait wait = new WebDriverWait(Driver, 2);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = Driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				// Assert.assertTrue(alert.getText().contains("Thanks."));
			}
			catch(Exception e){
				System.out.println("Test Case Fail !!");
			}
			
			logger(Test, "Test Case Completed !! "+ele, "I");
			
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



