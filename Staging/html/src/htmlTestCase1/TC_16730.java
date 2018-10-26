package htmlTestCase1;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utill.Generic;import utill.Imagetest;


@Test

public class TC_16730 extends Generic {

	static int change=0;

	static String TC_Name = "TC_16730";
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
	public static void tc_16730() throws Exception{
		Screen screen = new Screen();
		try
		{
			String testCase = "XMLSock_http_policy_file" ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/XMLPolicyFile/XMLSock_http_policy_file.html";
			String title = "XMLSock_http_policy_file";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);
			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(Web.getWebElement("Div"));
			logger(Test, "Flash Element Found: "+ele, "I");
			Thread.sleep(4000);
			String image1 = "Capture";
			expImage = imageFinder(image1);			boolean testPass = false;			actImagePath = Generic.getSeleniumSnap(ele, TC_Name, image1);			for(int i=1;i<=3;i++){				Thread.sleep((3000));				actImagePath=Generic.getSeleniumSnap(ele,"TC_16713" ,image1);				testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);				if(!testPass){					Driver.navigate().refresh();					ele= Driver.findElement(Web.getWebElement("Div"));					logger(Test, "PixelDiffFound Reloading Page", "I");				}else{					logger(Test, "PixelDiff not Found breaking loop", "I");					break;				}			}			if(testPass){				logger(Test, "Test is Completed Successfully", "I");			}
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

	private static Object isChanged() {
		change = 1;
		return null;
	}
}
