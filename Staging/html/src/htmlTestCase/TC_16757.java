package htmlTestCase;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
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

@Test

public class TC_16757 extends Generic {

	static String TC_Name = "TC_16757";
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

	public static void tc_16757() throws Throwable{


		Match match = null;	

		Screen screen = new Screen();
		try
		{
			String testCase = "FlashPaper: Superlong" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/FlashPaper/Superlong.html";
			String title = "Superlong.swf";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			Thread.sleep(1000);

			expImage= Web.getImageElement("TotalText");

			String expImage1=Web.getImageElement("TextStart");
			String expImage2 =Web.getImageElement("TextEnd");
			logger(Test, " Baseline Image found", "I");
			Pattern pObj=new Pattern(expImage);
			Pattern pObj1=new Pattern(expImage1);
			Pattern pObj2=new Pattern(expImage2);

			Thread.sleep(2000);
			screen.doubleClick(pObj1);
			Thread.sleep(1000);
			match=screen.exists(pObj);
			try {
				match.dragDrop(pObj1,pObj2);
				System.out.println("drag drop");

			} catch (FindFailed e) {
				logger(Test, "Could not select the text", "I");
				e.printStackTrace();
			}
			Thread.sleep(1000);

			MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
			MyRobot.getInstance().keyPress(KeyEvent.VK_C);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_C);
			MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
			logger(Test, "Copied the selectedtext", "I");

			Generic.NotepadOpen();
			logger(Test, "Opening Notepad", "I");
			Thread.sleep(1000);
			try{
				MyRobot.getInstance().keyPress(KeyEvent.VK_CONTROL);
				MyRobot.getInstance().keyPress(KeyEvent.VK_V);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_V);
				MyRobot.getInstance().keyRelease(KeyEvent.VK_CONTROL);
				logger(Test, "Trying to paste the selectedtext", "I");


				String image4 = "";
				System.out.println("actImage:-"+actImagePath);

				image4 = "ResultOnNotePad";
				expImage = imageFinder(image4);
				Match matchNotepad1=screen.exists(new Pattern(expImage));

				if(matchNotepad1==null){
					logger(Test,"First Match Found Null Looking for another match","I");
					image4 = "ResultOnNotePad2";
					expImage = imageFinder(image4);
				}

				actImagePath = printMatcher(screen, TC_Name,expImage,image4);
				imageMatcher(expImage,actImagePath);
				

				System.out.println("actImage:-"+actImagePath);

			}catch(Exception e){

			}


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
