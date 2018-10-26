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

public class TC_16739 extends Generic {


	static String TC_Name = "TC_16739";
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
	public static void tc_16739() throws Exception{

		try {
			
			String testCase = "Floating Point Matrices: Bitmap Scaling Test" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/AnimationAndRendering/AnimationTest/animationPage1.html";
			String title = "Floating Point Matrices: Bitmap Scaling Test";
			
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			
			logger(Test, "Loaded:"+url, "I");
			WebElement ele;
			

			//Page 1 Validation
			ele = Driver.findElement(By.xpath("//*[@id='bitmapScaling7']/embed"));
			 ImageAnimation(ele,"page1",TC_Name);
					
			//Page 2 Validation
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/AnimationAndRendering/AnimationTest/animationPage2.html");
			ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/p[2]/object[1]/embed"));
			ImageAnimation(ele,"page2",TC_Name);

			//Page 3 Validation
			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/AnimationAndRendering/AnimationTest/animationPage3.html");
			ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/p[2]/object/embed"));
			ImageAnimation(ele,"page3",TC_Name);
			
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
