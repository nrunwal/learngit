package htmlTestCase;


import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
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
import utill.MyRobot;


public class TC_17157 extends Generic {
	static String TC_Name = "TC_17157";
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
	public  void tc_17157() throws Exception{
		Screen screen = new Screen();
		try
		{if(CURRENTBROWSER.contains("edge")){
			Assert.fail("The Upload/ Download functionaslity is not supported hence skipping the test for edge alone");
		}else{
			String testCase = "	Javascript Pseudo-Protocol Disabled in Network-Enabled APIs " ;
			String url = "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/Security/JavascriptPseudoProtocol/javascriptPseudoProtocol_AS3.html";
			String title = "Javascript Psuedo-Protocol Disabled";
			System.out.println("\n\n---------------Executing TestCase: -------------------- "+TC_Name+", Desc: "+testCase+"-------------------------\n\n");

			logger(Report, TC_Name, title);
			logger(Test, "Browser launched ", "I");

			Driver.get(url);
			logger(Test, "Loading:"+url, "I");
			titleMatch(title);

			String mainWindow = Driver.getWindowHandle();

			logger(Test, "Loaded:"+url, "I");

			WebElement ele= Driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/embed"));
			logger(Test, "Upload Button Found: "+ele, "I");

			String image1 = "UploadBtn";
			expImage = imageFinder(image1);
			Thread.sleep(1000);
			objClick(screen,expImage, ele);
			//ele.sendKeys("C:/$099293F4.jpg");
			Thread.sleep(500);
			if(CURRENTBROWSER.contains("edge")){
				Match match =null;
				logger(Test, "The Upload/ Download functionality is not supported hence skipping the test for edge alone", "I");
				Assert.assertNotNull(match,"The Upload/ Download functionality is not supported hence skipping the test for edge alone");
			}else{
				upload(TC_Name);
			}

			WebElement eletext= Driver.findElement(By.xpath("//*[@id='FileReference_upload']"));
			System.out.println(eletext.getText());
			Assert.assertTrue((eletext.getText().contains("PASS")), "Upload Button Failed");

			WebElement ele1= Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[3]/embed"));
			logger(Test, "Download Button Found: "+ele1, "I");
			ele1.click();

			WebElement ele1text= Driver.findElement(By.xpath("//*[@id='FileReference_download']"));
			System.out.println(ele1text.getText());
			Assert.assertTrue((ele1text.getText().contains("PASS")), "Download Button Failed");

			WebElement ele2= Driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[3]/embed"));
			logger(Test, "Click Me Button Found: "+ele2, "I");

			String image2 = "ClickmeBtn";
			expImage = imageFinder(image2);
			Thread.sleep(1000);
			objClick(screen,expImage, ele2);
			Thread.sleep(1000);

			WebElement ele2text= Driver.findElement(By.xpath("//*[@id='textField_htmlText']"));
			System.out.println(ele2text.getText());
			Assert.assertTrue((ele2text.getText().contains("PASS")), "Click Me Button Failed");

			WebElement eleList = null;
			for(int i=2;i<=10;i++){
				eleList= Driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr["+i+"]/td[1]"));
				String text= eleList.getText();
				System.out.println("text:"+text);
				Assert.assertTrue(text.equals("PASS"), "\n Mismatch in PASS for the testcase element"+eleList);
			}


			//Driver.navigate().refresh();


			logger(Test, "TestCase Completed ", "I");

			Report.endTest(Test);
		}
		}
		catch(Exception e){
			logger(Test,e.getMessage(), "F");
			Report.endTest(Test);
			e.getStackTrace();
			throw e;

		}

	}


}





