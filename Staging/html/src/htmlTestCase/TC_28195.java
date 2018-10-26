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
import org.openqa.selenium.WebDriver;
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
 * @author runwal
 */


public class TC_28195 extends Generic{

	static String TC_Name = "TC_28195";
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
	public static void TC_28195() throws Exception{


		Screen screen = new Screen();
		try
		{

			String testCase = "Verify the alert" ;
			String url = "http://fpserver01.macromedia.com/players/testsuites/jsEmbed/tags/allowScriptNever.htm";
			String title = "all tags";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			try
			{	
				Driver.get(url);
				logger(Test, "Loading:"+url, "I");
				titleMatch(title);
				logger(Test, "Loaded:"+url, "I");


				Thread.sleep(2000);

				WebDriverWait wait = new WebDriverWait(Driver, 5);
				while(wait.until(ExpectedConditions.alertIsPresent())!=null) {
					Alert alert = Driver.switchTo().alert();
					System.out.println(alert.getText());
					Assert.assertTrue(alert.getText().contains(""));
					alert.accept();
					Thread.sleep(1000);
					System.out.println("Alert accepted");
					logger(Test, "Alert Accepted", "I");}
				Thread.sleep(5000);


				expImage=Web.getImageElement("Button2");
				objClick(screen,expImage, null);
				System.out.println("Button Clicked");
				Thread.sleep(500);

			}
			catch(Exception e){
				System.out.println("Under Exception.. ");

				try {
					System.out.println("Alert is present");
					WebDriverWait wait = new WebDriverWait(Driver, 8);
					while(wait.until(ExpectedConditions.alertIsPresent())!=null) {
						Alert alert = Driver.switchTo().alert();
						System.out.println(alert.getText());
						Assert.assertTrue(alert.getText().contains(""));
						alert.accept();
						Thread.sleep(1000);
						System.out.println("Alert accepted");
						logger(Test, "Alert Accepted", "I");
					}}
				catch(Exception e1){
					System.out.println("no further alert present");
				}
				Thread.sleep(5000);


				expImage=Web.getImageElement("Button2");
				objClick(screen,expImage, null);
				System.out.println("Button Clicked");
				Thread.sleep(500);

			}


			Report.endTest(Test);
		}
		catch(Exception e){

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