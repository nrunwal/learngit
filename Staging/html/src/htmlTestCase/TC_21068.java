package htmlTestCase;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
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


public class TC_21068 extends Generic{

	static String TC_Name = "TC_21068";
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
	public static void TC_21068() throws Exception{


		Screen screen = new Screen();
		try
		{

			String testCase = "CRASHER-BugRegression-WB1933510 RTMP" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/BugRegressions/WB1933510/1_rtmp.html";
			String title = "1_rtmp";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");


			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			Thread.sleep(1000);
			robotClick();

			if(CURRENTOS.contains("win")){

				String image1 = "Capture1";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				imageMatcher(expImage,actImagePath);
				System.out.println("Matching Done !");

				MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyPress(KeyEvent.VK_T);
				MyRobot.getInstance().delay(1000);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_T);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
				MyRobot.getInstance().delay(1000);
				Thread.sleep(2000);
				
				if(CURRENTBROWSER.contains("edge")){
					Thread.sleep(1000);

					String image = "Screen";
					expImage = imageFinder(image);

					objClick(screen, expImage, null);
					Thread.sleep(1000);
				}
				Thread.sleep(1000);

				screen.type("https://edition.cnn.com/");

				MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(200);
				Thread.sleep(5000);

				image1 = "Capture2";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				Match match = screen.exists(new Pattern(expImage));

				if(match==null){
					MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
					MyRobot.getInstance().delay(200);
					MyRobot.getInstance().keyPress(KeyEvent.VK_W);
					MyRobot.getInstance().delay(1000);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_W);
					MyRobot.getInstance().delay(200);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
					MyRobot.getInstance().delay(1000);
					Thread.sleep(2000);
					Assert.assertNotNull(match,"Match is found null for the above function ");

				}else{
					Assert.assertNotNull(match,"Match is found null for the above function ");
					System.out.println("Matching Done !");

					for(int i =0;i<=3;i++) {
						MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
						MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
						MyRobot.getInstance().delay(1000);
						MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
						MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
						MyRobot.getInstance().delay(1000);	
						Thread.sleep(2000);
					}

					MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
					MyRobot.getInstance().delay(200);
					MyRobot.getInstance().keyPress(KeyEvent.VK_W);
					MyRobot.getInstance().delay(1000);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_W);
					MyRobot.getInstance().delay(200);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
					MyRobot.getInstance().delay(1000);
					Thread.sleep(2000);
				}





				Report.endTest(Test);
			}



			if(CURRENTOS.contains("mac")) {

				String image1 = "Capture1";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				imageMatcher(expImage,actImagePath);
				System.out.println("Matching Done !");

				MyRobot.getInstance().keyPress(KeyEvent.VK_META);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyPress(KeyEvent.VK_T);
				MyRobot.getInstance().delay(1000);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_T);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_META);
				MyRobot.getInstance().delay(1000);
				Thread.sleep(2000);

				screen.type("http://www.cnn.com");


				MyRobot.getInstance().keyPress(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_ENTER);
				MyRobot.getInstance().delay(200);
				Thread.sleep(5000);

				image1 = "Capture2";
				expImage = imageFinder(image1);
				actImagePath = printMatcher(screen, TC_Name,expImage,image1);
				imageMatcher(expImage,actImagePath);
				System.out.println("Matching Done !");

				for(int i =0;i<=3;i++) {
					MyRobot.getInstance().keyPress(KeyEvent.VK_META);
					MyRobot.getInstance().keyPress(KeyEvent.VK_TAB);
					MyRobot.getInstance().delay(1000);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_TAB);
					MyRobot.getInstance().keyRelease(KeyEvent.VK_META);
					MyRobot.getInstance().delay(1000);	
					Thread.sleep(2000);
				}

				MyRobot.getInstance().keyPress(KeyEvent.VK_META);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyPress(KeyEvent.VK_W);
				MyRobot.getInstance().delay(1000);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_W);
				MyRobot.getInstance().delay(200);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_META);
				MyRobot.getInstance().delay(1000);
				Thread.sleep(2000);


				Report.endTest(Test);	
			}

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

