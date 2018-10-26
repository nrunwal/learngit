package htmlTestCase1;
import java.io.IOException;

import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.basics.Settings;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;

/**
 * @author ankjoshi
 * @see : 1) The number in red should be lower than 1000

 */

@Test
public class TC_29667 extends Generic {

	static String TC_Name = "TC_29667";
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

	@Test
	public static void tc_29667() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "performance regression 2600755" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Staging/HTML/BugRegression/2600755//2600755.html";
			String title = "2600755";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			String image1 = "image1";
			expImage = imageFinder(image1);

			Pattern pObj=new Pattern(expImage);
			Match match=screen.exists(pObj);
			if(match==null){
				logger(Test, "Match Found Null for the print desired", "F");
				Assert.assertNotNull(match, "BaseLine Image is not matched from saved PDF");
			}
			int x= match.getX();
			int y= match.getY();
			int h= match.getH();
			int w= match.getW();
			System.out.println(x+" "+y+" "+h+" "+w);
			capturedImg=getActualSnapper(screen, TC_Name, x, y, w, h,image1);

			Region s = screen.setRect(x, y, w+40, h+40);
			Settings.OcrTextRead = true; // to switch on the Region.text() function
			Settings.OcrTextSearch = true;

			String text = screen.find(expImage).right(20).text();
			System.out.println("Text="+text);

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
