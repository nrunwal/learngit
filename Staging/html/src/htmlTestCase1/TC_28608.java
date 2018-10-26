package htmlTestCase1;


import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.MouseEvent;

import utill.Generic;
import utill.MyRobot;


/**
 * @author ankjoshi
 * @see :Run the test case. follow instruction.
 */

public class TC_28608 extends Generic{

	static String TC_Name = "TC_28608";
	static String actImagePath="";
	static String expImage="";

	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Xml.elementHandler(TC_Name);
		Generic.setCurrentTestBaselinePath(TC_Name);
	}


	@AfterMethod
	public void tc_end(ITestResult result) throws Throwable{
		Generic.NotepadClose();

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
	public static void tc_28608() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "Bug 2200963  " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2200963/mouseTest.html";
			String title = "mouseTest";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
			
			Thread.sleep(1000);
			MyRobot.getInstance().mouseMove(400, 400);
			MyRobot.getInstance().mousePress(InputEvent.BUTTON1_MASK);
			MyRobot.getInstance().mouseRelease(InputEvent.BUTTON1_MASK);
			screen.click();
			MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
			MyRobot.getInstance().keyPress(KeyEvent.VK_R);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_R);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			
			expImage = imageFinder( "click");
			objClick(screen, expImage, ele);

			String image1 = "Capture";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			Match match1 = screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match1,"Match is found null for title Click"+image1);

			expImage = imageFinder("title");
			objClick(screen, expImage, ele);
			logger(Test, "Title Clicked", "I");
			Match titielMatch =  screen.exists(new Pattern(expImage));
			Assert.assertNotNull(titielMatch,"Match is found null for titielMatch Click"+image1);


			String image2 = "Capture1";
			expImage = imageFinder(image2);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image2);
			Match match2 =  screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match2,"Match is found null for title Click"+image2);
			
			logger(Test, "Title Click Macthed Moving to next TextCase", "I");
			logger(Test, "Moving Mouse", "I");

			screen.mouseMove(titielMatch.getX()+10, titielMatch.getY());
			expImage = imageFinder(image2);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image2);
			match2 =  screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match2,"2nd Match iss found null for title Click"+image2);
			logger(Test, "Mouse Move Verified for title", "I");

			Generic.NotepadOpen();
			logger(Test, "Opening Notepad", "I");
			Thread.sleep(1000);
			
			expImage = imageFinder("notepadClick");
			objClick(screen, expImage, ele);
			Match notepadMatch =  screen.exists(new Pattern(expImage));
			Assert.assertNotNull(notepadMatch,"Match is found null for notepadMatch Click"+image1);

			String image3 = "Capture2";
			expImage = imageFinder(image3);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image3);
			Match match3 =  screen.exists(new Pattern(expImage).similar(0.5f));
			Assert.assertNotNull(match3,"Match is found null for Application Notepad Click"+image3);
			
			logger(Test, "Moving Mouse to application", "I");
			screen.mouseMove(notepadMatch.getX()+20, notepadMatch.getY()+20);
			
			expImage = imageFinder(image3);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image3);
			match3 =  screen.exists(new Pattern(expImage));
			Assert.assertNotNull(match3,"Match is found null for Application Notepad Click"+image3);

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



