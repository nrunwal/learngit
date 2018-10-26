package htmlTestCase;



import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.Keys;
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
@SuppressWarnings("static-access")
public class TC_44954 extends Generic{

	String TC_Name = "TC_44954";
	String actImagePath="";
	String expImage="";

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
	public void tc_44954() throws Exception{

		Screen screen = new Screen();
		try
		{
			
			String testCase = "Bug3300031 (PSIRT 1306): Keypress Test with Protected Mode enabled" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/Bug3300031/index.html";
			String title = "Bug3300031 (PSIRT 1306): Keypress Test";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");
			
			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");
			
			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			Driver.navigate().refresh();
			logger(Test, "Refresh Checked ", "I");

			Thread.sleep(500);
			Driver.findElement(Web.getWebElement("RandomHTML")).click();
			logger(Test, "Random Clicked Checked ", "I");

			Driver.findElement(Web.getWebElement("TextField")).sendKeys("ab",Keys.ARROW_LEFT,Keys.ARROW_RIGHT,Keys.ARROW_UP,Keys.ARROW_DOWN);
			logger(Test, "Keys Sent ", "I");
			
			Thread.sleep(500);
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			
			String image1 = "doneBTN";
			expImage = imageFinder(image1);
			Match match = screen.exists(new Pattern(expImage));
		/*	List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);*/
			//actImagePath = list.get(1).toString();
			Assert.assertNotNull(match, "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			objClick(screen,expImage, ele);
			logger(Test, "Done BTN is clicked", "I");

			String image2 = "checkBOX";
			expImage = imageFinder(image2);

			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image2);

			imageMatcher(expImage,actImagePath);
			logger(Test, "check box is Matched ", "I");

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
