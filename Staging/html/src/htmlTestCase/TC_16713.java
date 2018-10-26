package htmlTestCase;
import java.io.File;
import java.io.IOException;
import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utill.Generic;
import utill.Imagetest;

@Test

public class TC_16713 extends Generic {
	String actImagePath="";
	String expImage="";
	int TotalTestPass=0;

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
		Generic.setCurrentTestBaselinePath(TC_16713.class.getSimpleName());
		Xml.elementHandler(TC_16713.class.getSimpleName());
	}



	@AfterMethod
	public void tc_end() throws JDOMException, IOException{
		System.out.println("Done TC_16713");
	}
	@SuppressWarnings("static-access")

	public  void tc_16713() throws IOException, InterruptedException{

		logger(Report, "TC_16713", "JSMethods Security");
		logger(Test, "Browser is launched", "I");

		Match match = null;
		Screen screen;  
		String[] Results = new String[30];
		WebElement ScrollToNext;
		boolean testPass = false;
		int x,y,h,w;
		String actImagePath=null;
		try
		{		

			screen =new Screen();

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Security/JSMethods/index.htm");
			logger(Test, "Loading : http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Security/JSMethods/index.htm", "I");
			org.testng.Assert.assertTrue(Driver.getTitle().equalsIgnoreCase("Security - JavaScript API"), "Actual Page title:- "+Driver.getTitle()+" doesn't match with expected:-Security - JavaScript API");
			logger(Test, "Loaded : http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/Security/JSMethods/index.htm", "I");
			Thread.sleep(500);


			//Test 1	

			Driver.findElement(By.linkText("CurrentFrame")).click();
			logger(Test, "Clicked on CurrentFrame", "I");
			Thread.sleep(250);
			Results[1] =Driver.findElement(Web.getWebElement("Test1")).getText();
			logger(Test, "Got " + Results[1] , "I");

			if(Results[1].trim().equals("5"))
			{
				logger(Test, "Test1: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test1: Fail", "I");
			}

			//Test 2 ToDO: Get Flash Version Dynamically
			//	Driver.findElement(By.linkText("FlashVersion")).click();


			//Test 3

			Driver.findElement(By.linkText("GetVariable")).click();
			logger(Test, "Clicked on GetVariable", "I");
			Thread.sleep(250);
			Results[3] =Driver.findElement(Web.getWebElement("Test3")).getText();
			logger(Test, "Got " + Results[3], "I");
			if(Results[3].trim().equals("undefined")||Results[3].trim().equals("0")||Results[3].trim().equals("empty")||Results[3].trim().equals("")||Results[3]==null)
			{
				logger(Test, "Test3: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test3: Fail; Expected:Null Got:"+Results[3], "I");
			}


			//Test 4
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[12]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				WebElement ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[12]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("GotoFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "GotoFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 4" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 4" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("GotoFrame","4","TC_16713");
			}

			Scroller("IsPlaying");

			//Test 5

			Driver.findElement(By.linkText("IsPlaying")).click();
			logger(Test, "Clicked on Isplaying", "I");
			Thread.sleep(500);
			Results[5] =Driver.findElement(Web.getWebElement("Test5")).getText();
			logger(Test, "Got " + Results[5], "I");
			if(Results[5].trim().equals("true"))
			{
				logger(Test, "Test5: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test5: Fail; Expected:true Got:" + Results[5], "I");

			}




			//Test 6
			//Test 6
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[17]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				WebElement ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[17]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("LoadMovie");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "LoadMovie");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 6" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 6" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("LoadMovie","6","TC_16713");	
			}



			//Test 7
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[19]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				WebElement ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[19]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("Pan");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "Pan");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 7" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 7" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("Pan","7","TC_16713");
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
				TotalTestPass++;
			}
			else{

				logger(Test, "Test8: Fail; Expected:100 Got:"+ Results[8], "I");
			}


			//Scrolling Down.
			Scroller("Rewind");

			//Test 9
			//Actual Snap is not captured due to animating nature of the test case.	   

			Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[24]/td[1]/div/font/a")).click();
			logger(Test, "Clicked on Rewind", "I");
			System.out.println("Clicked on Rewind");

			WebElement ele=Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[24]/td[1]/div/table/tbody/tr/th"));
			ele.click();
			Thread.sleep(500);
			int c=0;	
			expImage=Generic.getSeleniumSnap(ele,"TC_16713" ,"Rewind_Before_Update");
			for(int i=1;i<=3;i++){
				Thread.sleep((3000/i));
				actImagePath=Generic.getSeleniumSnap(ele,"TC_16713" ,"Rewind_After_Update"+ i);
				testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);
				if(!testPass)
					break;
			}
			if(!testPass){
				TotalTestPass++;
				logger(Test, "Test9: Pass", "I");
			}
			else{
				Generic.appendxml(expImage, actImagePath,"TC_16713");
				logger(Test, "Test9: Fail, No Animation", "F");
			}  



			//Test 10
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[26]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[26]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("SetVariable");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "SetVariable");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 10" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 10" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("SetVariable","10","TC_16713");	        	 
			}


			//Test 11
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[28]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[28]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("SetZoomRect");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "SetZoomRect");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 11" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 11" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("SetZoomRect","11","TC_16713");
			}


			//Test 12
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[30]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[30]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TCallFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TCallFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 12" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 12" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TCallFrame","12","TC_16713");
			}

			//Test13
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[30]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[30]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TCallFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TCallFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 13" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 13" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TCallFrame","12","TC_16713");
			}



			Scroller("TCurrentFrame");

			//Test 14

			Driver.findElement(By.linkText("TCurrentFrame")).click();
			logger(Test, "Clicked on TCurrentFrame", "I");
			Thread.sleep(250);
			Results[14] =Driver.findElement(Web.getWebElement("Test14")).getText();
			logger(Test, "Got " + Results[14] , "I");

			if(Results[14].trim().equals("-1"))
			{
				logger(Test, "Test14: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test14: Fail ; Expected: -1  Got: "+Results[14], "I");
			} 


			//Test 15

			Driver.findElement(By.linkText("TCurrentLabel")).click();
			logger(Test, "Clicked on TCurrentLabel", "I");
			Thread.sleep(250);
			Results[15] =Driver.findElement(Web.getWebElement("Test15")).getText();
			logger(Test, "Got " + Results[15], "I");
			if(Results[15].trim().equals("undefined")||Results[15].trim().equals("0")||Results[15].trim().equals("empty")||Results[15].trim().equals("")||Results[15]==null)
			{
				logger(Test, "Test15: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test15: Fail; Expected:null Got: "+Results[15], "I");
			}



			//Test 16

			Driver.findElement(By.linkText("TGetProperty")).click();
			logger(Test, "Clicked on TGetProperty", "I");
			Thread.sleep(250);
			Results[16] =Driver.findElement(Web.getWebElement("Test16")).getText();
			logger(Test, "Got " + Results[16], "I");
			if(Results[16].trim().equals("undefined")||Results[16].trim().equals("0")||Results[16].trim().equals("empty")||Results[16].trim().equals("")||Results[16]==null)
			{
				logger(Test, "Test16: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test16: Fail; Expected:null Got: "+Results[16], "I");
			}


			Scroller("TGetPropertyAsNumber");

			//Test 17

			Driver.findElement(By.linkText("TGetPropertyAsNumber")).click();
			logger(Test, "Clicked on TGetPropertyAsNumber", "I");
			Thread.sleep(250);
			Results[17] =Driver.findElement(Web.getWebElement("Test17")).getText();
			logger(Test, "Got " + Results[17], "I");
			if(Results[17].trim().equals("undefined")||Results[17].trim().equals("0")||Results[17].trim().equals("empty")||Results[17].trim().equals("")||Results[17]==null)
			{
				logger(Test, "Test17: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test17: Fail; Expected:null Got: "+Results[17], "I");
			}


			//Test 18
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[46]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[46]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TGotoFrame");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TGotoFrame");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 18" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 18" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TGotoFrame","18","TC_16713");
			}


			//Test 19
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[48]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[48]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TGotoLabel");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TGotoLabel");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 19" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 19" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TGotoLabel","19","TC_16713");
			}

			//Test 20
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[48]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[48]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TSetProperty");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TSetProperty");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 20" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 20" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TSetProperty","20","TC_16713");
			}


			//Test 21
			if(Generic.currentBR().equals("ie")||Generic.currentBR().equals("edge")){

			}else{
				Scroller("TotalFrames") ;
				Driver.findElement(By.linkText("TotalFrames")).click();
				logger(Test, "Clicked on TotalFrames", "I");
				Thread.sleep(250);
				Results[21] =Driver.findElement(Web.getWebElement("Test21")).getText();
				logger(Test, "Got " + Results[21], "I");
				if(Results[21].trim().equals("10"))
				{
					logger(Test, "Test21: Pass", "I");
					TotalTestPass++;
				}

				else{

					logger(Test, "Test21: Fail; Expected:10 Got:"+Results[21], "I");
				}
			}						
			//Test 22
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[55]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[55]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("TPlay");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "TPlay");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 22" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 22" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("TPlay","22","TC_16713"); 
			}


			//Test 23
			//Actual Snap is not Captured.
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[57]/td[1]/div/font/a")).click();
				logger(Test, "Clicked on TStopPlay", "I");
				System.out.println("Clicked on TStopPlay");

				ele=Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[57]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				Thread.sleep(500);
				c=0;	
				expImage=Generic.getSeleniumSnap(ele,"TC_16713" ,"TStopPlay_Before_Update");
				for(int i=1;i<=3;i++){
					Thread.sleep((3000/i));
					actImagePath=Generic.getSeleniumSnap(ele,"TC_16713" ,"TStopPlay_After_Update" +i);
					testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);
					if(!testPass)
						break;
				}
				if(!testPass){
					TotalTestPass++;
					logger(Test, "Test23: Pass", "I");
				}
				else{
					Generic.appendxml(expImage, actImagePath,"TC_16713");
					logger(Test, "Test23: Fail, No Animation", "F");
				}  
			}else{
				Driver.findElement(By.linkText("TStopPlay")).click();
				logger(Test, "Clicked on TStopPlay", "I");
				System.out.println("Clicked on TStopPlay");

				ele=Driver.findElement(Web.getWebElement("Test23"));
				ele.click();
				Thread.sleep(500);
				c=0;	
				expImage=Generic.getSeleniumSnap(ele,"TC_16713" ,"TStopPlay_Before_Update");
				for(int i=1;i<=3;i++){
					Thread.sleep((3000/i));
					actImagePath=Generic.getSeleniumSnap(ele,"TC_16713" ,"TStopPlay_After_Update" +i);
					testPass=new Imagetest().compare(expImage.replace(".png",""), actImagePath);
					if(!testPass)
						break;
				}
				if(!testPass){
					TotalTestPass++;
					logger(Test, "Test23: Pass", "I");
				}
				else{
					Generic.appendxml(expImage, actImagePath,"TC_16713");
					logger(Test, "Test23: Fail, No Animation", "F");
				}  							
				}



			//Test 24
			if(CURRENTBROWSER.contains("edge")){
				Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[59]/td[1]/div/font/a")).click();
				Thread.sleep(500);
				ele = Driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/th/table/tbody/tr[59]/td[1]/div/table/tbody/tr/th"));
				ele.click();
				logger(Test, "Clicked on " + ele, "I");

				expImage = Web.getImageElement("Zoom");
				actImagePath = Generic.getSeleniumSnap(ele, "TC_16713", "Zoom");
				logger(Test, "Actual Snap is captured at " + actImagePath, "I");
				testPass = new Imagetest().compare(expImage, actImagePath);
				if (testPass) {
					logger(Test, "Test 24" + ": Pass", "I");
					TotalTestPass++;
				} else {

					Generic.appendxml(expImage, actImagePath, "TC_16713");
					logger(Test, "Test 24" + ": Fail", "F");
				}

			}else{
				TotalTestPass+=utility("Zoom","24","TC_16713");  
			}
			
			//Test 25

			Driver.findElement(By.linkText("Server-side redirect")).click();
			logger(Test, "Clicked on Server-side redirect", "I");
			Thread.sleep(250);
			Results[25] =Driver.findElement(Web.getWebElement("Test25")).getText();
			logger(Test, "Got " + Results[25], "I");
			if(Results[25].trim().equals("undefined")||Results[25].trim().equals("0")||Results[25].trim().equals("empty")||Results[25].trim().equals("")||Results[25]==null)
			{
				logger(Test, "Test25: Pass", "I");
				TotalTestPass++;
			}
			else{

				logger(Test, "Test25: Fail", "I");
			}    	    


			logger(Test, "Test case is done", "I");
			if(Generic.currentBR().equals("ie")||Generic.currentBR().equals("edge")){
				Assert.assertTrue(TotalTestPass==23, "TC_16713 failed with  "+ (23-TotalTestPass) + "  failed testcases.");
				Report.endTest(Test);}
			else{
				Assert.assertTrue(TotalTestPass==24, "TC_16713 failed with  "+ (24-TotalTestPass) + "  failed testcases.");
				Report.endTest(Test);
			}
		}



		catch(AssertionError | Exception e){
			logger(Test, e.getMessage(),"F");

			Report.endTest(Test);

			throw e;}




	}






}
