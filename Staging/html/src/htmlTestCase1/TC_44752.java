package htmlTestCase1;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
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
public class TC_44752 extends Generic {
	static String TC_Name = "TC_44752";
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
	public  void tc_44752() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Concurrency HTML test";
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/HTMLSuite/";
			String title = "Concurrency HTML Tests";
			WebElement link = null;
			boolean testPass;
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

			//Test 2a
			Thread.sleep(5000);
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/BlockingTests/MainBlockingReceive.html");
			Thread.sleep(500);
			link = Driver.findElement(By.xpath("//*[@id='MainBlockingReceive']/object"));

			expImage=Web.getImageElement("Test2"+File.separator+"image2aBtn");
			try{
				screen.find(new Pattern(expImage));
			}catch(FindFailed e){
				Thread.sleep(1000);
				System.out.println("Caught Find Failed");
				Driver.switchTo().defaultContent();

			}

			objClick(screen,expImage, link);
			Thread.sleep(15000);

			String image2a = "Test2"+File.separator+"image2a";
			expImage = imageFinder(image2a);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image2a);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2a: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test2a: Fail", "F");
			}  

			Driver.navigate().back();

			//Test 2b	
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/BlockingTests/MainBlockingSend.html");
			Thread.sleep(500);
			link = Driver.findElement(By.xpath("//*[@id='MainBlockingSend']/object"));

			expImage=Web.getImageElement("Test2"+File.separator+"image2bBtn");
			objClick(screen,expImage, link);
			Thread.sleep(15000);

			String image2b =  "Test2"+File.separator+"image2b";
			expImage = imageFinder(image2b);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image2b);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2b: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test2b: Fail", "F");
			}  

			Driver.navigate().back();

			//Test 2c	

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/BlockingTests/MainConditionMutexBlocking.html");
			Thread.sleep(500);
			link = Driver.findElement(By.xpath("//*[@id='MainConditionMutexBlocking']/object"));

			expImage=Web.getImageElement("Test2"+File.separator+"image2cBtn");
			objClick(screen,expImage, link);
			Thread.sleep(15000);

			String image2c =  "Test2"+File.separator+"image2c";
			expImage = imageFinder(image2c);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image2c);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2c: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test2c: Fail", "F");
			}  
			Driver.navigate().back();

			//Test 2d	
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/BlockingTests/MainMutexLockBlocking.html");
			Thread.sleep(500);

			link = Driver.findElement(By.xpath("//*[@id='MainMutexLockBlocking']/object"));

			expImage=Web.getImageElement("Test2"+File.separator+"image2dBtn");
			objClick(screen,expImage, link);
			Thread.sleep(2000);

			String image2d = "Test2"+File.separator+"image2d";
			expImage = imageFinder(image2d);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image2d);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test2d: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test2d: Fail", "F");
			}  

			Driver.navigate().back();


			//Test 3	
			String Link3 ="Test Link";
			Scroller(Link3);

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/ImageLoader/testfiles/ImageLoader.html");;

			link = Driver.findElement(By.xpath("//*[@id='ImageLoader']"));

			expImage=Web.getImageElement("Test3"+File.separator+"setImage");
			objClick(screen,expImage, link);

			expImage=Web.getImageElement("Test3"+File.separator+"loadImage");
			objClick(screen,expImage, link);

			Thread.sleep(1000);

			String image3 = "backGrd";
			expImage=Web.getImageElement(image3);
			actImagePath = printMatcher(screen, TC_Name,expImage,image3);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test3: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test3: Fail", "F");
			}  

			Driver.navigate().back();

			//Music Player Cannot Automate

			//Test 4a	

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/UnsupportedSWF/FuzzedSWF.html");;

			link = Driver.findElement(By.xpath("//*[@id='flashContent']/object/object"));

			expImage=Web.getImageElement("Test4"+File.separator+"load");
			objClick(screen,expImage, link);
			Thread.sleep(2000);

			String image4a = "Test4"+File.separator+"Background";
			expImage = imageFinder(image4a);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image4a);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test4: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test4: Fail", "F");
			}  

			//Test 4b	
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/UnsupportedSWF/OldSWFVersion.html");;

			link = Driver.findElement(By.xpath("//*[@id='OldSWFVersion']/object"));

			expImage=Web.getImageElement("Test4"+File.separator+"load2");
			objClick(screen,expImage, link);
			Thread.sleep(2000);

			String image4b = "Test4"+File.separator+"Background2";
			expImage = imageFinder(image4b);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image4b);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test4: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test4: Fail", "F");
			}  

			Driver.navigate().back();


			//Test 5

			//Test6

			//Test7
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/WorkerStressTest/StressWorker.html");;

			link = Driver.findElement(By.xpath("//*[@id='StressWorker']/object"));

			Thread.sleep(102000);

			String image7 = "Test7"+File.separator+"WorkerStress";
			expImage = imageFinder(image7);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image7);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test7: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test7: Fail", "F");
			}  


			Driver.navigate().back();


			//Test8a
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/Concurrency/WMODE/isSupported.html");;

			link = Driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/object/object"));

			String image8a = "Test8"+File.separator+"image8a";
			expImage = imageFinder(image8a);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image8a);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test8a: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test8a: Fail", "F");
			} 

			//Test8b
			link = Driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/object/object"));

			String image8b = "Test8"+File.separator+"image8b";
			expImage = imageFinder(image8b);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image8b);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test8b: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test8b: Fail", "F");
			}  


			link = Driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]/object/object"));

			String image8c = "Test8"+File.separator+"image8c";
			expImage = imageFinder(image8c);
			actImagePath = Generic.getSeleniumSnap(link, TC_Name, image8c);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test8c: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test8c: Fail", "F");
			} 

			Driver.navigate().back();


			//Test9a
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/AS3++mt1.swf");
			Thread.sleep(2000);

			MyRobot.getInstance().mouseMove(500, 6000);
			screen.hover();
			screen.wheel(50,1);

			expImage=Web.getImageElement("mouseMove");
			Thread.sleep(2000);

			String image9a = "image9a";
			expImage=Web.getImageElement(image9a);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9a);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9a: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9a: Fail", "F");
			} 

			 
				//Test9b
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/AS3++mt2.swf");
			Thread.sleep(2000);

			for(int i = 0;i<10;i++){
				Driver.navigate().refresh();
			}
			Thread.sleep(2000);

			for(int i = 0;i<10;i++){
				Driver.navigate().refresh();
			}
			Thread.sleep(2000);

			String image9b = "image9b";
			expImage=Web.getImageElement(image9b);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9b);


			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9b: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9b: Fail", "F");
			} 

			//Test9c
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/AS3++mt3.swf");

			Thread.sleep(5000);
			String image9c = "image9c";
			expImage=Web.getImageElement(image9c);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9c);

			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9c: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9c: Fail", "F");
			} 


			 
			
			//Test9f 
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/pthread_mutex_test_optimized.swf");

			Thread.sleep(90000);

			String image9f = "image9f";
			expImage=Web.getImageElement(image9f);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9f);


			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");

			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9f: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9f: Fail", "F");
			} 
			 
/*
			//Test9g
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/pthreads.swf");

		
			MyRobot.getInstance().mouseMove(500, 200);
			MyRobot.getInstance().mouseMove(500, 500);
			MyRobot.getInstance().mouseMove(500, 200);

			Thread.sleep(2000);
			String image9g = "image9g";
			expImage=Web.getImageElement(image9g);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9g);


			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9g: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9g: Fail", "F");
			} 

*/
			//Test9h
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/Automated/Objects/Concurrency/Acceptance/Alchemy/_rsc/mc.swf");

			Thread.sleep(20000);
			String image9h = "Test9h";
			expImage=Web.getImageElement(image9h);
			actImagePath = printMatcher(screen, TC_Name,expImage,image9h);


			testPass = new Imagetest().compare(expImage, actImagePath);  
			logger(Test, "Image Matched Successfully for Image:"+actImagePath, "I");


			if(testPass){
				TotaltestPass++;
				logger(Test, "Test9h: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"tc_44752");
				logger(Test, "Test9h: Fail", "F");
			} 




			Assert.assertTrue(TotaltestPass==15, TC_Name+" failed with  "+ (15-TotaltestPass) + "  failed testcases.");
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
