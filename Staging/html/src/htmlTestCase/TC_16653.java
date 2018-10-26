package htmlTestCase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.sikuli.script.*;

import utill.Generic;
import utill.Imagetest;

@Test

public class TC_16653 extends Generic {


	static String TC_Name = "TC_16653";
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
	public static void tc_16653() throws Exception{


		Match match = null;
		Screen screen;
		boolean testPass;
		
		
		
		
		try {
			screen = new Screen();

			String[] expImage1 = new String[6];
			String[] actImage = new String[6];
			List<Pattern> pobj = new ArrayList<Pattern>();
			
			String testCase = "Sync" ;
			String url = "http://ats.macromedia.com/players/TestSuite/Video/testfiles/Sync.html";
			String title = "Sync";
			
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
			
			WebElement ele = Driver.findElement(By.xpath("//*[@id='Sync']/embed"));

			
			
			for (int i = 1; i <= 5; i++) {
				actImage[i] = getSeleniumSnap(ele, TC_Name, "Screen" + i);
				Thread.sleep(500);
				expImage1[i] = Web.getImageElement("Screen" + i);
				logger(Test, " Baseline Image found" + i, "I");
				pobj.add(new Pattern(expImage1[i]));
				expImage = expImage1[i];
			}
			
		
			System.out.println("Ready for loop");
			int c = 1;
			int wait = 20;
			for (Pattern pobj1 : pobj) {

				System.out.println("Inside for loop");
				match = screen.exists(pobj1, wait * c);
				System.out.println(match);
				Assert.assertNotNull(match, "BaseLine image " + c + " is not matched from Screen Image");
				int x = match.getX();
				int y = match.getY();
				int h = match.getH();
				int w = match.getW();
				System.out.println(x + " " + y + " " + h + " " + w);
				actImagePath = getActualSnapper(screen, TC_Name, x, y, w, h, TC_Name+"_" + c);
				logger(Test, "Actual Snap" + c + "is captured", "I");
				System.out.println("actImage:-" + actImagePath);
				logger(Test, "Animation Test case. Hence Step 2 matching is skipped. ", "I");

				c++;
			}
			Assert.assertTrue(c == 6, TC_Name+" failed with  " + (6 - c) + "  failed imageMatches.");

			logger(Test, "Test case is done", "I");
			Report.endTest(Test);
		}

		catch (AssertionError | Exception e) {
			logger(Test, e.getMessage(), "F");

			Report.endTest(Test);

			throw e;
		}

	}
}
