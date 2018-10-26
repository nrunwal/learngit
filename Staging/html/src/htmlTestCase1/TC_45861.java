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
 * @see : G11n test case for ExternalInterface: 1 contain existed ExternalInterface case 45856/45857/45858/45859/45860 2 Add real world test case
 * 
 */
public class TC_45861 extends Generic {
	static String TC_Name = "TC_45861";
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
	public  void tc_45861() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "G11n test case for ExternalInterface";
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/ExternalAPI/G11n%20test%20case%20for%20ExternalInterface.html";
			String title = "ExternalInterface.call() and ExternalInterface.addCallback() G11n test case";
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
	/*		String Link1 ="http://www.nicovideo.jp/watch/sm7443506";
			Scroller(Link1);

			link = Driver.findElement(By.partialLinkText(Link1));
			link.click();

			Thread.sleep(500);
			link = Driver.findElement(By.xpath("//*[@id='Login_nico']"));
			link.click();
			link = Driver.findElement(By.xpath("//*[@id='input__mailtel']"));
			link.sendKeys("ossan@ossan.com");
			link = Driver.findElement(By.xpath("//*[@id='input__password']"));
			link.sendKeys("adobeadobe");
			link = Driver.findElement(By.xpath("//*[@id='login__submit']"));
			link.click();

			Thread.sleep(8000);
			String image11 = "enBTn";
			expImage = imageFinder(image11);
			objClick(screen,expImage, link);

			String image12 = "jpBtn";
			expImage = imageFinder(image12);
			objClick(screen,expImage, link);

			String image13 = "playBtn";
			expImage = imageFinder(image13);
			objClick(screen,expImage, link);*/

			/*for(int i =1 ;i<=5;i++){
				expImage1[i]= Web.getImageElement("Screen" + i);
				logger(Test, " Baseline Image found" +i  , "I");
				pobj.add(new Pattern(expImage1[i]));
				expImage= expImage1[i];
			}*/
/*
			Thread.sleep(1000);
			int imageCount = videoMatcher(screen, pobj, expImage1);
*//*
			if(imageCount==6){
				TotaltestPass++;
				logger(Test, "Test1: Pass", "I");
			}else{
				Generic.appendxml(expImage, actImagePath,"tc_45861");
				logger(Test, "Test1: Fail wiht failed image Matches"+(6-imageCount) , "F");
			}
			Driver.navigate().back();


*/


			//Test 2	
			String Link2 ="http://clockmaker.jp/labs/130914_ExternalInterface/return.html";
			Scroller(Link2);

			link = Driver.findElement(By.partialLinkText(Link2));
			link.click();

			Thread.sleep(500);
			link = Driver.findElement(By.xpath("//*[@id='external_index']"));
			String image21 = "ExtIntCase2";
			expImage = imageFinder(image21);
			objClick(screen,expImage, link);

			String image22 = "ExpImgCase2";
			expImage = imageFinder(image22);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image22);

			boolean testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_45861");
				logger(Test, "Test2: Fail", "F");
			}  

			Driver.navigate().back();



			//Test 3	
			String Link3 ="http://www.webtvsolutions.com/webtv-es/index.php/video/15/tr%C3%A1fico-autopista/#";
			Scroller(Link3);

			link = Driver.findElement(By.partialLinkText(Link3));
			link.click();

			logger(Test, "Clicked on"+link, "I");
			link = Driver.findElement(By.xpath("//*[@id='videoContainer_media']"));

			expImage=Web.getImageElement("pressOk");
			objClick(screen,expImage, link);

			Thread.sleep(8000);

			expImage=Web.getImageElement("Test3")+File.separator+"playBtn";
			screen.wait(new Pattern(expImage));
			objClick(screen,expImage, link);

			Actions action = new Actions(Driver);
			action.moveToElement(link).build().perform();

			Thread.sleep(2000);
			MyRobot.getInstance().mouseMove(500, 500);
			
			expImage=Web.getImageElement("pauseBtn");
			objClick(screen,expImage, link);

			String image ="Frame4";
			expImage=Web.getImageElement("Test3")+File.separator+image;

			Match match1=screen.exists(new Pattern(expImage));
			double sc1 = match1.getScore();

			if(match1==null || sc1<=0.7f){
				System.out.println("\nFirst Match Found:"+match1+", Looking for another match\n");
				image =  "Frame41";
				expImage=Web.getImageElement("Test3")+File.separator+image;
				match1=screen.exists(new Pattern(expImage));
				sc1 = match1.getScore();
			}

			logger(Test, "Image Matched Successfully for Image:"+expImage, "I");

			if(sc1>=0.7f){
				TotaltestPass++;
				logger(Test, "Test3: Pass", "I");
			}
			else{
				actImagePath = Generic.getSeleniumSnap(link, TC_Name, image);
				Generic.appendxml(expImage, actImagePath,"tc_45861");
				logger(Test, "Test3: Fail", "F");
			}  
			Driver.navigate().back();


			Assert.assertTrue(TotaltestPass==2, TC_Name+" failed with  "+ (2-TotaltestPass) + "  failed testcases.");
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
