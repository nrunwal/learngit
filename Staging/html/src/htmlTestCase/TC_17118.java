package htmlTestCase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
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

@Test

public class TC_17118 extends Generic {

	static String TC_Name = "TC_17118";
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

	public static void tc_17118() throws Throwable{

		logger(Report, "TC_17118", " 	RPathBT_ldMovAbsPath    ");
		logger(Test, "Browser is launched", "I");
		String[] actImage21 = null;
		Match match = null;
		Screen screen;
		boolean testPass;
		try
		{		

			screen =new Screen();

			String[] expImage1 = new String[6];
			List<Pattern> pobj = new ArrayList<Pattern>();
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/AnimationAndRendering/MipmapSupport/QualityTest/AS2_loadMovie_32bit_smoothed.html");
			logger(Test, "URL loading", "I");

				
			logger(Test, "URL Loaded", "I");
			
			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");			
		
			Thread.sleep(1000);
			String image1 = "TC17118";
			expImage = imageFinder(image1);
			actImagePath = printMatcher(screen,TC_Name,expImage,image1);
			//actImagePath= getSeleniumSnap(ele, TC_Name, image1);
			imageMatcher(expImage, actImagePath);
									
			logger(Test, "Test is Completed Successfully", "I");

			Report.endTest(Test);
		}

		catch(AssertionError|Exception  e){
			logger(Test, e.getMessage(),"F");

			Report.endTest(Test);
			
			throw e;
			
		}
		}

	}

