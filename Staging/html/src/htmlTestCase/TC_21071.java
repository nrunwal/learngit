package htmlTestCase;


import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.Imagetest;
/**
 * @author runwal
 */


public class TC_21071 extends Generic{

	static String TC_Name = "TC_21071";
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
	public static void TC_21071() throws Exception{


		Screen screen = new Screen();
		try
		{


			String testCase = "BufferOverflow2217024" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/BufferOverflow2217024/heapspray.htm";
			String title = "";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");


			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");


			try
			{	
				Driver.get(url);
				logger(Test, "Loading:"+url, "I");
				Thread.sleep(15000);
				//	titleMatch(title);
				System.out.println("title: "+Driver.getTitle());

				logger(Test, "Loaded:"+url, "I");


				WebDriverWait wait = new WebDriverWait(Driver, 8);
				while(wait.until(ExpectedConditions.alertIsPresent())!=null) {
					Alert alert = Driver.switchTo().alert();
					System.out.println(alert.getText());
					Assert.assertTrue(alert.getText().contains(""));
					alert.accept();
					Thread.sleep(1000);
					System.out.println("Alert accepted");
				}

				Thread.sleep(15000);

				//Capture and Match
				String image1 = "Capture1";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				screen.exists(new Pattern(actImagePath).similar(0.8f));
				//boolean testPass = new Imagetest().compare(baseImage, captImage);
				//imageMatcher(expImage,actImagePath);

				// as per test case requirement 

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
						System.out.println("Alert accepted");}}
				catch(Exception e1){
					System.out.println("no further alert present");
				}

				Thread.sleep(5000);


				Thread.sleep(180000);// as per test case requirement 

				//Capture and Match
				String image1 = "Capture1";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				screen.exists(new Pattern(actImagePath).similar(0.8f));
				//	imageMatcher(expImage,actImagePath);

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
