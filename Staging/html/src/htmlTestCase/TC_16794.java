package htmlTestCase;
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
public class TC_16794 extends Generic {

	static String TC_Name = "TC_16794";
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
	public static void tc_16794() throws Exception{


		Screen screen = new Screen();
		try
		{
			String testCase = "HTMLvars_F6HttpLinkQueryString" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/browserHTML/Variables/Vars%20in%20HTML/Other%20Testcases/HTMLvars_F6HttpLinkQueryString.html";
			String title = "HTMLvars_F6HttpLinkQueryString";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");


			String image2 = "Btn";
			expImage = imageFinder(image2);
			objClick(screen,expImage, null);
			Thread.sleep(6000);

			url  = "at-campus.net";
			System.out.println("Title" +Driver.getTitle()+"url"+url);
			Thread.sleep(3000);

		/*	Assert.assertTrue(Driver.getTitle().contains(title),
					"Actual Page title:- " + Driver.getTitle() + " doesn't match with expected:-" + title);*/
			Assert.assertTrue(Driver.getCurrentUrl().contains(url),
					"Actual Page URL:- " + Driver.getCurrentUrl() + " doesn't match with expected:-" + url); 

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
