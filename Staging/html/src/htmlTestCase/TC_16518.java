package htmlTestCase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utill.Generic;
import utill.Imagetest;

@Test

public class TC_16518 extends Generic {


	String actImagePath="";
	String expImage="";
	int TotaltestPass=0;

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Generic.setCurrentTestBaselinePath(TC_16518.class.getSimpleName());
		Xml.elementHandler(TC_16518.class.getSimpleName());

	}



	@AfterMethod
	public void tc_end() throws JDOMException, IOException{
		System.out.println("Done TC_16518");
	}
	@SuppressWarnings("static-access")

	public  void tc_16518() throws IOException, InterruptedException{

		logger(Report, "TC_16518", "JavaScript API");
		logger(Test, "Browser is launched", "I");

		Match match = null;
		Screen screen;  
		String[] Results = new String[30];
		WebElement ScrollToNext;
		WebElement ele;
		try
		{		

			screen =new Screen();
			boolean testPass = false;

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/JavaScript/index.htm");
			logger(Test, "Loading : http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/JavaScript/index.htm", "I");
			org.testng.Assert.assertTrue(Driver.getTitle().equalsIgnoreCase("JavaScript API"), "Actual Page title:- "+Driver.getTitle()+" doesn't match with expected:-JavaScript API");
			logger(Test, "http://ats.macromedia.com/Players/ATS/ATS9AS3/Shipping/html/browserHTML/JavaScript/index.htm", "I");
			Thread.sleep(500);


			//Test 1	

			Driver.findElement(By.linkText("CurrentFrame")).click();
			logger(Test, "Clicked on CurrentFrame", "I");
			Thread.sleep(500);
			Results[1] =Driver.findElement(Web.getWebElement("Test1")).getText();
			logger(Test, "Got " + Results[1] , "I");

			if(Results[1].trim().equals("5"))
			{
				logger(Test, "Test1: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test1: Fail", "I");
			}

			/*	//OPEN BUG
					//Test 2 ToDO: Get Flash Version Dynamically
				             Driver.findElement(By.linkText("FlashVersion")).click();
				             Results[2] =Driver.findElement(Web.getWebElement("Test2")).getText();
								logger(Test, "Got " + Results[1] , "I");

								if(Results[2].trim().equals("5"))
								{
									logger(Test, "Test2: Pass", "I");
									totalPass++;
								}
								else{

									logger(Test, "Test2: Fail", "I");
								}

			 */		
			//Test 3
			if(CURRENTBROWSER.contains("edge")){
				Thread.sleep(1000);
				Driver.findElement(By.linkText("GetVariable")).click();
				Thread.sleep(1000);

				logger(Test, "Clicked on GetVariable", "I");
				Results[3] =Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[10]/td[1]")).getText();
				logger(Test, "Got " + Results[3], "I");
				if(Results[3].trim().equals("undefined")||Results[3].trim().equals("0")||Results[3].trim().equals("empty")||Results[3].trim().equals("null")||Results[3]==null|| Results[3].isEmpty())
				{
					logger(Test, "Test3: Pass", "I");
					TotaltestPass++;
				}
				else{

					logger(Test, "Test3: Fail; Expected:Null Got:"+Results[3], "I");
				}

			}else{
				Thread.sleep(1000);
				Driver.findElement(By.linkText("GetVariable")).click();
				Thread.sleep(1000);

				logger(Test, "Clicked on GetVariable", "I");
				Results[3] =Driver.findElement(Web.getWebElement("Test3")).getText();
				logger(Test, "Got " + Results[3], "I");
				if(Results[3].trim().equals("undefined")||Results[3].trim().equals("0")||Results[3].trim().equals("empty")||Results[3].trim().equals("null")||Results[3]==null|| Results[3].isEmpty())
				{
					logger(Test, "Test3: Pass", "I");
					TotaltestPass++;
				}
				else{

					logger(Test, "Test3: Fail; Expected:Null Got:"+Results[3], "I");
				}					
			}






			//Test 4  
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[12]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[12]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("GotoFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "GotoFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 4" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 4" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("GotoFrame","4","TC_16518");
			}






			//Test 5

			Driver.findElement(By.linkText("IsPlaying")).click();
			logger(Test, "Clicked on Isplaying", "I");
			Thread.sleep(500);
			Results[5] =Driver.findElement(Web.getWebElement("Test5")).getText();
			logger(Test, "Got " + Results[5], "I");
			if(Results[5].trim().equals("true"))
			{
				logger(Test, "Test5: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test5: Fail; Expected:true Got:" + Results[5], "I");

			}



			//Test 6
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[17]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[17]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("LoadMovie");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "LoadMovie");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 6" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 6" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("LoadMovie","6","TC_16518");	
			}


			//Test 7
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[19]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[19]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("Pan");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "Pan");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 7" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 7" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("Pan","7","TC_16518");
			}


			//Test 8
			System.out.println("Test 8");
			Driver.findElement(By.linkText("PercentLoaded")).click();
			logger(Test, "Clicked on PercentLoaded", "I");
			Thread.sleep(500);
			Results[8] =Driver.findElement(Web.getWebElement("Test8")).getText();
			logger(Test, "Got " + Results[8] , "I");

			if(Results[8].trim().equals("100"))
			{
				logger(Test, "Test8: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test8: Fail; Expected:100 Got:"+ Results[8], "I");
			}


			//Scrolling Down.
			Scroller("Rewind");


			//Test 9
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[24]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[24]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("Rewind");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "Rewind");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 9" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 9" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=  utility("Rewind","9","TC_16518"); 
			}



			//Test 10

			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[26]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[26]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("SetVariable");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "SetVariable");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 10" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 10" + ": Fail", "F");
				}

			}else{
				TotaltestPass+= utility("SetVariable","10","TC_16518");
			}




			//Test 11
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[28]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[28]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("SetZoomRect");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "SetZoomRect");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 11" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 11" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=  utility("SetZoomRect","11","TC_16518");
			}


			//Test 12

			System.out.println("Test 12");
			Driver.findElement(By.linkText("TCurrentFrame")).click();
			logger(Test, "Clicked on TCurrentFrame", "I");
			Thread.sleep(500);
			Results[12] =Driver.findElement(Web.getWebElement("Test12")).getText();
			logger(Test, "Got " + Results[12] , "I");

			if(Results[12].trim().equals("4"))
			{
				logger(Test, "Test12: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test12: Fail; Expected:4 Got:"+ Results[12], "I");
			}

			Scroller("TCurrentLabel");  

			//Test13

			Driver.findElement(By.linkText("TCurrentLabel")).click();
			logger(Test, "Clicked on TCurrentLabel", "I");
			Thread.sleep(500);
			Results[13] =Driver.findElement(Web.getWebElement("Test13")).getText();

			logger(Test, "Got " + Results[13] , "I");

			if(Results[13].trim().equals("woltonia"))
			{
				logger(Test, "Test13: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test13: Fail ; Expected: woltania  Got: "+Results[13], "I");
			} 


			//Test 14

			Driver.findElement(By.linkText("TGetProperty")).click();
			logger(Test, "Clicked on TGetProperty", "I");

			Thread.sleep(500);
			Results[14] =Driver.findElement(Web.getWebElement("Test14")).getText();
			logger(Test, "Got " + Results[14] , "I");

			if(Results[14].trim().equals("33"))
			{
				logger(Test, "Test14: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test14: Fail ; Expected: 33  Got: "+Results[14], "I");
			} 


			//Test 15

			Driver.findElement(By.linkText("TGetPropertyAsNumber")).click();
			logger(Test, "Clicked on TGetPropertyAsNumber", "I");
			Thread.sleep(500);
			Results[15] =Driver.findElement(Web.getWebElement("Test15")).getText();
			logger(Test, "Got " + Results[15], "I");
			if(Results[15].trim().equals("7.5"))
			{
				logger(Test, "Test15: Pass", "I");
				TotaltestPass++;
			}
			else{

				logger(Test, "Test15: Fail; Expected:7.5 Got: "+Results[15], "I");
			}



			//Test 16
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[41]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[41]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TGotoFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "TGotoFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 16" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 16" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("TGotoFrame","16","TC_16518");
			}

			Scroller("TGotoLabel");    


			//Test 17
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[43]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[43]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TGotoLabel");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "TGotoLabel");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 17" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 17" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=  utility("TGotoLabel","17","TC_16518");
			}





			//Test 18
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[45]/td[1]/p/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[45]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TSetProperty");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "TSetProperty");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 18" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 18" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("TSetProperty","18","TC_16518");
			}






			//Test 19
			if(Generic.currentBR().equals("ie")||Generic.currentBR().equals("edge")){

			}else{
				Scroller("TotalFrames"); 
				Driver.findElement(By.linkText("TotalFrames")).click();
				logger(Test, "Clicked on TotalFrames", "I");
				Thread.sleep(250);
				Results[19] =Driver.findElement(Web.getWebElement("Test19")).getText();

				Thread.sleep(500);
				logger(Test, "Got " + Results[21], "I");
				if(Results[19].trim().equals("10"))
				{
					logger(Test, "Test19: Pass", "I");
					TotaltestPass++;
				}

				else{

					logger(Test, "Test19: Fail; Expected:10 Got:"+Results[19], "I");
				}
			}
			Scroller("TStopPlay");



			String text="";
			//Test 20
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[50]/td[1]/div/font/a")).click();
				logger(Test, "Clicked on TPlay", "I");

				ele=Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[50]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				int  c=0;	
				expImage=Generic.getSeleniumSnap(ele,"TC_16518" ,"TPlay_Before_Update");
				for(int i=1;i<=3;i++){
					text= Driver.findElement(Web.getWebElement("Test20")).getText();
					Thread.sleep((3000/i));
					actImagePath=Generic.getSeleniumSnap(ele,"TC_16518" ,"TPlay_After_Update"+i);
					testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);
					if(!testPass)
						break;
				}
				if(!testPass){
					TotaltestPass++;
					logger(Test, "Test20: Pass", "I");
				}
				else{
					Generic.appendxml(expImage, actImagePath,"TC_16518");
					logger(Test, "Test20: Fail, No Animation", "F");
				}  
			}else{
				Driver.findElement(By.linkText("TPlay")).click();
				logger(Test, "Clicked on TPlay", "I");

				ele=Driver.findElement(Web.getWebElement("Test20"));
				ele.click();
				int  c=0;	
				expImage=Generic.getSeleniumSnap(ele,"TC_16518" ,"TPlay_Before_Update");
				for(int i=1;i<=3;i++){
					text= Driver.findElement(Web.getWebElement("Test20")).getText();
					Thread.sleep((3000/i));
					actImagePath=Generic.getSeleniumSnap(ele,"TC_16518" ,"TPlay_After_Update"+i);
					testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);
					if(!testPass)
						break;
				}
				if(!testPass){
					TotaltestPass++;
					logger(Test, "Test20: Pass", "I");
				}
				else{
					Generic.appendxml(expImage, actImagePath,"TC_16518");
					logger(Test, "Test20: Fail, No Animation", "F");
				}  
			}





			Scroller("TStopPlay");
			//Test 21  
			Driver.findElement(By.linkText("TStopPlay")).click();
			logger(Test, "Clicked on TStopPlay", "I");
			Thread.sleep(1000);

			ele= Driver.findElement(Web.getWebElement("TStopPlay"));
			text= Driver.findElement(Web.getWebElement("TStopPlay")).getText();
			Thread.sleep(2000);

			expImage=Generic.getSeleniumSnap(ele,"TC_16518" ,"TStopPlay_Before_Update");
			//Thread.sleep((3000/i));

			text= Driver.findElement(Web.getWebElement("TStopPlay")).getText();
			Thread.sleep(2000);

			actImagePath=Generic.getSeleniumSnap(ele,"TC_16518" ,"TStopPlay_After_Update1");
			String act1 = actImagePath;

			text= Driver.findElement(Web.getWebElement("TStopPlay")).getText();
			Thread.sleep(2000);	

			actImagePath=Generic.getSeleniumSnap(ele,"TC_16518" ,"TStopPlay_After_Update2");
			String act2 = actImagePath;

			testPass=new Imagetest().compareSame(act1, act2);
			if(testPass){
				TotaltestPass++;
				logger(Test, "Test21: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"TC_16518");
				logger(Test, "Test21: Fail,Animation has not stopped!!!", "F");
			}


			/*					actImagePath=Generic.getSeleniumSnap(ele,"TC_16518" ,"TStopPlay");
		         			 c=0;  
							String[] expImage21 = new String[15];
							for(int i =0 ;i<=9;i++){

								 expImage21[i]= Web.getImageElement("TStopPlay") +File.separator+"Frame"+i;
								 System.out.println(expImage21[i]);
								 logger(Test, " Frames found" +i  , "I");
								 testPass=new Imagetest().compare(expImage21[i], actImagePath);

								 if(testPass){
									 c++;
									 expImage=expImage21[i];
								 }
							  }

							if(c==1)
		           	    {   
		           	    	logger(Test, "Test21: Pass", "I");
								TotaltestPass++;
		           	    }		
		                else if(c>=2){  
		                	expImage=expImage21[0];
		                	 Generic.appendxml(expImage, actImagePath,"TC_16518");
								logger(Test, "Test21: Fail ; Animation did not stop!!! c= "+c, "F");
								}

		                else{
		                	expImage=expImage21[0];
		                	 Generic.appendxml(expImage, actImagePath,"TC_16518");


		                	logger(Test, "Test21: Fail ; Animation did not stop!!! c= "+c, "F");
		                }
			 */
			//Test 22

			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[54]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[54]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("Zoom");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16518", "Zoom");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 22" + ": Pass", "I");
					TotaltestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16518");
					logger(Test, "Test 22" + ": Fail", "F");
				}

			}else{
				TotaltestPass+=utility("Zoom","22","TC_16518");
				}




			logger(Test, "Test case is done", "I");

			if(Generic.currentBR().equals("ie")||Generic.currentBR().equals("edge")){
				Assert.assertTrue(TotaltestPass==20, "TC_16518 failed with  "+ (20-TotaltestPass) + "  failed testcases.");
				Report.endTest(Test);
			}else{
				Assert.assertTrue(TotaltestPass==21, "TC_16518 failed with  "+ (21-TotaltestPass) + "  failed testcases.");
				Report.endTest(Test);


			}
		}



		catch(AssertionError|Exception  e){
			logger(Test, e.getMessage(),"F");

			Report.endTest(Test);

			throw e;}




	}




}
