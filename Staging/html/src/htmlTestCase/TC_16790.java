package htmlTestCase;
import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

//@author rijain

@Test

public class TC_16790 extends Generic {

	static int change=0;

	static String TC_Name = "TC_16790";
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
	public static void tc_16790() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "RPathBT_ldVarSubPath ";
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/browserHTML/Variables/Path/RelativePath-basetag/RPathBT_ldVarSubPath.html";
			String title = "Path_ldVarSubPath";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
	
			
		    String image1 = "16790_img";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			
			/*List<Object> list = Matcher(screen, TC_Name, expImage, ele, image1);
			actImagePath = list.get(1).toString();
			Assert.assertNotNull((Match)list.get(0), "Match Found Null, BaseLine image doesn't match with Screen Image"+expImage);

			Match match=(Match) list.get(0);
			match.onChange(100,isChanged());

			org.testng.Assert.assertTrue(change==1,"Animation is not stopped");
*/
			/*actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);*/
			logger(Test, "Test is Completed Successfully", "I");

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
