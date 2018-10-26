package htmlTestCase1;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;
import utill.MyRobot;

/**
 * @author runwal
 * @see : 1)Run swf and click on the button "Add Client-broken" 
 * 2)"Client3" should be added to the list. If not, log a bug.
 * This has been tested to work on mainline 10.2.150.219
 */

@Test
public class TC_16529 extends Generic {

	static String TC_Name = "TC_16529";
	static String actImage="";
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
			Generic.appendxml(expImage,actImage,methodName);
			System.out.println("\n***********Test Failed***********");
		}
		System.out.println("\n\nDone Executing ----------------------"+TC_Name+"----------------------\n\n");

	}

	@Test
	public static void tc_16529() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "Param_play" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/Variables/Param/Param_play.html";
			String title = "Param_play";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");
			
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			
			logger(Test, "Flash Element Found: "+ele, "I");
			
			
			
			String image1 = "Globe1";
			expImage = imageFinder(image1);
			//new Pattern();
			//screen.rightClick(pObj2);
		Thread.sleep(10000);
		actImage= printMatcher(screen, TC_Name, expImage, image1);
			
			imageMatcher(expImage, actImage);
			
			//objContextClick(screen, expImage, ele);
		//	objClick(screen, expImage, ele);
	
		

	//		logger(Test, "BTN is clicked", "I");
			//Driver.findElement(By.xpath("/html/body")).click();
			
			
			
		/*	Set<String> windows = Driver.getWindowHandles();

			for(String window: windows){

				if(!mainwind.equals(window)){

					Driver.switchTo().window(window);

		    		WebElement ele1 = Driver.findElement(Web.getWebElement("Div2"));
					logger(Test, "Flash Element Found: "+ele1, "I");                  

					String image3 = "capture3";
					expImage = imageFinder(image3);
					actImagePath= getSeleniumSnap(ele1, TC_Name, image3);
					imageMatcher(expImage, actImagePath);
					System.out.println("Window switched:L "+window);
					Driver.close();
				}
			}
*/
	//		Driver.switchTo().window(mainwind);
		  	   
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
