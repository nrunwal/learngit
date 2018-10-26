package htmlTestCase1;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

import utill.Generic;
import utill.Imagetest;
import utill.MyRobot;

/**
 * @author ankjoshi
 * @see :Run all tests on the HTML page and follow the instructions on each test.
Wasabi (10.3) and up.
 * 
 */
public class TC_41311 extends Generic {
	static String TC_Name = "TC_41311";
	static String actImagePath="";
	static String expImage="";
	int TotaltestPass=0;

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
	public  void tc_41311() throws Exception{

		boolean testPass ;
		Screen screen = new Screen();
		try
		{
			String testCase = "GMail cross site 0-day exploit - Regression test suite";
			String url = "http://2888124.playercore10.com/index.html";
			String title = "0-day regression media for Watson 2888124 & Watson 2759370";
			WebElement link = null;
			String[] expImage1 = new String[6];
			List<Pattern> pobj = new ArrayList<Pattern>();

			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			

			//Test 1	
			String Link1 ="http://2888124.playercore10.com/txt/MovieClip-loadVariables.html";
			Scroller(Link1);

			link = Driver.findElement(By.partialLinkText(Link1));
			link.click();

			Thread.sleep(5000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables']/object"));
			String image1 = "Link1";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image1);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test1: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test1: Fail", "F");
			}  

			Driver.navigate().back();

			
			//Test 2	
			String Link2 ="http://2888124.playercore10.com/txt/MovieClipLoader-loadVariables.html";

			link = Driver.findElement(By.partialLinkText(Link2));
			link.click();

			Thread.sleep(5000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClipLoader-loadVariables']/object"));
			String image2 = "Link2";
			expImage = imageFinder(image2);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image2);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test2: Fail", "F");
			}  

			Driver.navigate().back();
			
			
			//Test 3	
			String Link3 ="http://2888124.playercore10.com/swf/MovieClip-loadVariables.html";

			link = Driver.findElement(By.partialLinkText(Link3));
			link.click();

			Thread.sleep(5000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables']/object"));
			String image3 = "Link3";
			expImage = imageFinder(image3);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image3);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test3: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test3: Fail", "F");
			}  

			Driver.navigate().back();
			
			
			

			//Test 4	
			String Link4 ="http://2888124.playercore10.com/swf/MovieClipLoader-loadVariables.html";

			link = Driver.findElement(By.partialLinkText(Link4));
			link.click();

			Thread.sleep(5000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClipLoader-loadVariables']/object"));
			String image4 = "Link4";
			expImage = imageFinder(image4);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image4);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test4: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test4: Fail", "F");
			}  

			Driver.navigate().back();
			
			
			
			//Test 5	
			String Link5 ="http://2888124.playercore10.com/txt/MovieClip-loadVariables-bypass.html";

			link = Driver.findElement(By.partialLinkText(Link5));
			link.click();

			Thread.sleep(10000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables-bypass']/object"));
			String image5 = "Link5";
			expImage = imageFinder(image5);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image5);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test5: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test5: Fail", "F");
			}  

			Driver.navigate().back();
			
			
			//Test 6	
			String Link6 ="http://2888124.playercore10.com/swf/MovieClip-loadVariables-bypass.html";

			link = Driver.findElement(By.partialLinkText(Link6));
			link.click();
			
			Thread.sleep(10000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables-bypass']/object"));
			String image6 = "Link6";
			expImage = imageFinder(image6);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image6);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test6: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test6: Fail", "F");
			}  

			Driver.navigate().back();
			
			
			
			//Test 7	
			String Link7 ="http://2888124.playercore10.com/swf/MovieClip-loadVariables-AB-B.html";

			link = Driver.findElement(By.partialLinkText(Link7));
			link.click();

			Thread.sleep(10000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables-AB-B']/object"));
			String image7 = "Link7";
			expImage = imageFinder(image7);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image7);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test7: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test7: Fail", "F");
			}  

			Driver.navigate().back();
			
			

			//Test 8	
			String Link8 ="http://2888124.playercore10.com/swf/MovieClip-loadVariables-ABC.html";

			link = Driver.findElement(By.partialLinkText(Link8));
			link.click();

			Thread.sleep(10000);
			link = Driver.findElement(By.xpath("//*[@id='MovieClip-loadVariables-ABC']/object"));
			String image8 = "Link8";
			expImage = imageFinder(image8);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image8);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test8: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test8: Fail", "F");
			}  

			Driver.navigate().back();
			

			//Test 9	
			String Link9 ="http://2759370.playercore10.com/y.htm";

			link = Driver.findElement(By.partialLinkText(Link9));
			link.click();

			Thread.sleep(10000);
			link = Driver.findElement(By.xpath("//*[@id='xmlBox']"));
			String image9 = "Link9";
			expImage = imageFinder(image9);
			actImagePath = printMatcher(screen, TC_Name, expImage, image9);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_41311");
				logger(Test, "Test9: Fail", "F");
			}  

			Driver.navigate().back();
		
			Assert.assertTrue(TotaltestPass==9, TC_Name+" failed with  "+ (9-TotaltestPass) + "  failed testcases.");

			
			
			logger(Test, "TestCase Completed ", "I");

			Report.endTest(Test);

		}catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;
		}

	}
}
