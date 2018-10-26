package htmlTestCase;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


public class TC_28510 extends Generic {
	static String TC_Name = "TC_28510";
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
	public  void tc_28510() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "	Domain resolution and escape characters " ;
			String url = "http://test.playercore10.com/url/malformed_urls.html";
			String title = "Regression test: escape sequences in domain names";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			String mainWindow = Driver.getWindowHandle();

			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			//robotClick();

					for(String winddow : Driver.getWindowHandles()){
					System.out.println("list :"+Driver.getWindowHandles());
					System.out.println("Current Window :"+winddow);

					Driver.switchTo().window(winddow);
					Thread.sleep(1000);

					String title1 = Driver.getTitle();
					System.out.println("Title Print"+title1);
//					if(CURRENTBROWSER.contains("chrome")){
//						if(title1.contains("test.playercore10.com")){
//							Driver.close();
//							System.out.println("Window Closed");
//
//						}
//					}else{
						if(title1==null || title1.isEmpty() || title1.contains("test.playercore10.com")){
							Driver.close();
							System.out.println("Window Closed");

						}
					}
					Driver.switchTo().window(mainWindow);
					System.out.println("Window Switched");

				
			System.out.println("window titler"+Driver.getTitle());


//			}else{
//
//
//			}


			//	 ArrayList tabs = new ArrayList ();

		//	objClick(screen, title, null);
			
			robotClick();
			
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().delay(200);
			
			
			Thread.sleep(1000);
			String image1 = "ExpImg";
			expImage = imageFinder(image1);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image1);
			Match match = screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match,"Match is found null for image: "+image1);
			//imageMatcher(expImage,actImagePath);
			
			
			WebElement ele= Driver.findElement(By.xpath("/html/body/p[7]/b/a"));
			logger(Test, "Flash Element Found: "+ele, "I");
			ele.click();

			Thread.sleep(2000);
			String image2 = "ExpImg1";
			expImage = imageFinder(image2);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image2);
			imageMatcher(expImage,actImagePath);
			
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().delay(200);
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().delay(200);
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().delay(200);
			MyRobot.getInstance().keyPress(KeyEvent.VK_DOWN);
			MyRobot.getInstance().delay(200);
			
			WebElement ele1= Driver.findElement(By.xpath("/html/body/p[10]/b/a"));
			logger(Test, "Flash Element Found: "+ele1, "I");
			ele1.click();


			Thread.sleep(20000);
			String image3 = "ExpImg2";
			expImage = imageFinder(image3);
			actImagePath = Generic.printMatcher(screen, TC_Name, expImage, image3);
			imageMatcher(expImage,actImagePath);
			//Driver.navigate().refresh();


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
