package htmlTestCase;


import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.DataHandler;
import utill.Generic;


/**
 * @author ankjoshi
 * @see : Open up http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/FPLogoMouseCursor.html and 
 * http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/HTML/NativeMouseCursor/ArrowMouseCursor.html in multiple browser windows and tabs. 
 * You should try a combination of different browsers. 
 * You should only see the mouse cursor as indicated by the instructions within each SWF's stage boundaries. 
 * Even if you overlap browser windows, you should only see the cursor that is indicated by the instructions for that SWF's stage boundary. 
 * It doesn't matter which browser instance has focus currently. It only matters which SWF's stage area has the mouse hovering over it. 
 * NOTE: On OS X, you'll only get the custom cursor for whichever browser window currently has focus on it.
 * Mouse Hover Capture is a challenge needs to be modified
 * 
 */

public class TC_16540 extends Generic{

	static String TC_Name = "TC_16540";
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
	public static void tc_16540() throws Exception{

		Screen screen = new Screen();
		try
		{

			String testCase = "RPathBT_getUrlRootPath" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/Variables/Path/RelativePath-basetag/RPathBT_getUrlRootPath.html";
			String title = "Path_getUrlRootPath";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele1= Driver.findElement(Web.getWebElement("Div1"));
			logger(Test, "Flash Element Found: "+ele1, "I");

			String mainwind = Driver.getWindowHandle();

			String image1 = "Green_Btn";
			expImage = imageFinder(image1);
			objClick(screen, expImage, ele1);
			Thread.sleep(1000);

			Set<String> windows = Driver.getWindowHandles();

			for(String window: windows){

				if(!mainwind.equals(window)){

					Driver.switchTo().window(window);

					WebElement ele2= Driver.findElement(Web.getWebElement("Div2"));
					logger(Test, "Flash Element Found: "+ele2, "I");                  
					String expectedtext="/Root - PASS";

					if(CURRENTBROWSER.equals("edge")) {
						expectedtext +=" ";
					}
					String Actualtext = ele2.getText().toString();
					

					Assert.assertEquals(expectedtext,Actualtext,"\n Test match Failed in new window");

					System.out.println("Window switched:L "+window);
					Driver.close();
				}
			}

			Driver.switchTo().window(mainwind);
			System.out.println("Main Window switched:L "+mainwind);

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




