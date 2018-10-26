package htmlTestCase1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utill.Generic;

//@author rijain

@Test
public class TC_16781 extends Generic {

	static String TC_Name = "TC_16781";
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
	public static void tc_16781() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "RPathBT_getUrlSameDir" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/browserHTML/Variables/Path/RelativePath-basetag/RPathBT_getUrlSameDir.html";
			String title = "Path_getUrlSameDir";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");

			

			String mainwind = Driver.getWindowHandle();

			/*String image1 = "167811_img";
			expImage = imageFinder(image1);
			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage,actImagePath);
			logger(Test, "Image Matched ", "I");*/

			String image2 = "167812_img";
			expImage = imageFinder(image2);
			objClick(screen,expImage, ele);
			Thread.sleep(1000);

			logger(Test, "BTN is clicked", "I");
			//Driver.findElement(By.xpath("/html/body")).click();
			
			Set<String> windows = Driver.getWindowHandles();

			for(String window: windows){

				if(!mainwind.equals(window)){

					Driver.switchTo().window(window);

		    		WebElement ele1 = Driver.findElement(Web.getWebElement("Div2"));
					logger(Test, "Flash Element Found: "+ele1, "I");                  

					String expectedtext="SameDir - PASS";
					if(CURRENTBROWSER.equals("edge")) {
						expectedtext +=" ";
					}
					String Actualtext = ele1.getText().toString();

					Assert.assertEquals(expectedtext,Actualtext,"\n Test match Failed in new window");

					System.out.println("Window switched:L "+window);
					Driver.close();	
				}
			}

			Driver.switchTo().window(mainwind);
		  	   
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
