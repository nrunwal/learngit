package htmlTestCase1;

import java.io.IOException;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;

public class TC_16550 extends Generic
{
	static String TC_Name = "TC_16550";
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
	public static void tc_16550() throws Exception{
		String mainwind="";
		Screen screen = new Screen();
		try
		{
			String testCase = "RPathBT_getUrlSubSubPath" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/Variables/Path/RelativePath-basetag/RPathBT_getUrlSubSubPath.html";
			String title = "Path_getUrlSubSubPath";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele1= Driver.findElement(Web.getWebElement("Div1"));
			logger(Test, "Flash Element Found: "+ele1, "I");

			 mainwind = Driver.getWindowHandle();
			System.out.println(mainwind);

			String image1 = "Green_Btn";
			expImage = imageFinder(image1);
			objClick(screen, expImage, ele1);
			Thread.sleep(1000);

			Set<String> windows = Driver.getWindowHandles();

			for(String window: windows){


				if(!mainwind.equals(window))
				{

					Driver.switchTo().window(window);

					WebElement ele2= Driver.findElement(Web.getWebElement("Div2"));
					logger(Test, "Flash Element Found: "+ele2, "I");                  

					//					String image2 = "Capture1";
					//					expImage = imageFinder(image2);
					//					actImagePath= getSeleniumSnap(ele2, TC_Name, image2);
					//					imageMatcher(expImage, actImagePath);

					String expectedtext="subSubPath - PASS";
					if(CURRENTBROWSER.equals("edge")) {
						expectedtext +=" ";
					}
					String Actualtext = ele2.getText().toString();

					Assert.assertEquals(expectedtext,Actualtext);

					System.out.println("Window switched:L "+window);
					Driver.close();
				}
			}

			Driver.switchTo().window(mainwind);
			System.out.println("Main Window switched:L "+mainwind);

			logger(Test, "TestCase Completed ", "I");

			Report.endTest(Test);

			//			expImage=imageFinder(image1);
			//			actImagePath=printMatcher(screen, TC_Name, expImage, image1);
			//			imageMatcher(expImage, actImagePath);

		}

		catch(Exception e){
			logger(Test, e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;

		}catch(AssertionError a){
			
			logger(Test, a.getMessage(), "F");
			Report.endTest(Test);
			Driver.switchTo().window(mainwind);

			a.getStackTrace();
			throw a;
		}
	}
}
