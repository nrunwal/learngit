package htmlTestCase1;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.Imagetest;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see :Follow instructions on test page.

Serrano (11.0) and up.
 */

public class TC_41418 extends Generic{

	static String TC_Name = "TC_41418";
	static String actImagePath="";
	static String expImage="";
	static int TotaltestPass=0;

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
	public static void tc_41418() throws Exception{

		boolean testPass;
		Screen screen = new Screen();
		try
		{

			String testCase = "Regression test suite for 2143843" ;
			String url = "http://2143843.playercore10.com/index.html";
			String title = "Regression test suite for Watson 2143843";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			logger(Test, "Loaded:"+url, "I");



			//Test 1	
			Driver.get("http://2143843.playercore10.com/Positive/uploadTest.php");
			Thread.sleep(500);
			WebElement link = Driver.findElement(By.xpath("/html/body/object"));

			expImage=Web.getImageElement("runBtn");
			objClick(screen,expImage, link);
			Thread.sleep(500);

			upload(TC_Name);

			String image1 = "Capture";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test1: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41418");
				logger(Test, "Test1: Fail", "F");
			}  

			Driver.navigate().back();

			//Test 2	
			Driver.get("http://2143843.playercore10.com/Negative/uploadTestCrossDomainFail.php");
			Thread.sleep(500);
			link = Driver.findElement(By.xpath("/html/body/object"));

			expImage=Web.getImageElement("runBtn");
			objClick(screen,expImage, link);
			Thread.sleep(500);

			upload(TC_Name);

			String image2 = "Capture2";
			expImage = imageFinder(image2);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41418");
				logger(Test, "Test2: Fail", "F");
			}  

			Driver.navigate().back();

			//Test 3	
			Driver.get("http://2143843.playercore10.com/Negative/uploadTestCrossDomain.php");
			((JavascriptExecutor) Driver).executeScript("window.open('http://2143843-evil.playercore10.com/uploadTest.php','_blank');");

			MyRobot.getInstance().delay(1000);
			MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
			MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);


			Thread.sleep(1000);
			link = Driver.findElement(By.xpath("/html/body/object"));
			String mainwind = Driver.getWindowHandle();
			Set<String> windows = Driver.getWindowHandles();

			for(String window: windows){
				if(!mainwind.equals(window)){
					Driver.switchTo().window(window);
					Driver.close();
				}
			}

			Driver.switchTo().window(mainwind);
			
			expImage=Web.getImageElement("runBtn");
			objClick(screen,expImage, link);
			Thread.sleep(500);

			upload(TC_Name);

			String image3 = "Capture3";
			expImage = imageFinder(image3);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);


			

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test3: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41418");
				logger(Test, "Test3: Fail", "F");
			}  


			//Do something to open new tabs
			Driver.navigate().back();


			//Test 4	
			Driver.get("http://2143843.playercore10.com/Negative/uploadTestRequestHeaders.php");
			Thread.sleep(500);
			link = Driver.findElement(By.xpath("/html/body/object"));
			Driver.switchTo().defaultContent();

			expImage=Web.getImageElement("runBtn");
			objClick(screen,expImage, link);
			Thread.sleep(500);

			upload(TC_Name);

			String image4 = "Capture4";
			expImage = imageFinder(image4);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image4);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test4: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41418");
				logger(Test, "Test4: Fail", "F");
			}  

			Driver.navigate().back();

			Assert.assertTrue(TotaltestPass==4, TC_Name+" failed with  "+ (4-TotaltestPass) + "  failed testcases.");
			logger(Test, "TestCase Completed ", "I");

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




