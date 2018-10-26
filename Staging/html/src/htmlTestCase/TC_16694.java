package htmlTestCase;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Key;
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
import utill.MyRobot;

@Test

public class TC_16694 extends Generic {


	@SuppressWarnings("static-access")
	@BeforeMethod
	public void tc_Start() throws JDOMException, IOException{
	
		Generic.setCurrentTestBaselinePath(TC_16694.class.getSimpleName());
		Xml.elementHandler(TC_16694.class.getSimpleName());

	}




	@AfterMethod
	public void tc_end() throws JDOMException, IOException{
		System.out.println("Done TC_16694");
	}
	@SuppressWarnings("static-access")


	public static void tc_16694() throws Exception{

		logger(Report, "TC_16694 ", "Player Controls");
		logger(Test, "Browser is launched", "I");

		Match match = null;
		Match match1 = null;
		Match match2=null;
		Screen screen; 
		boolean testPass;
		try
		{		


			int totalPass=0;
			screen =new Screen();
			int x,y,h,w;
			String expImage, expImage1,expImage2,expImage3,actImagePath;
			Pattern pObj,pObj1,pObj2,pObj3;

			Driver.get("http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/PlayerControls/playercontrols.html");
			logger(Test, "Loading : http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/PlayerControls/playercontrols.html", "I");
			org.testng.Assert.assertTrue(Driver.getTitle().equalsIgnoreCase("Player Controls"), "Actual Page title:- "+Driver.getTitle()+" doesn't match with expected:-Player Controls");
			logger(Test, "Loaded : http://ats.macromedia.com/Players/ATS/ATS9AS2/Shipping/html/PlayerControls/playercontrols.html", "I");
			Thread.sleep(1000);



			//Test 1		
			//	WebElement loop= Driver.findElement(Web.getWebElement("Loop"));
			WebElement loop= Driver.findElement(Web.getWebElement("Loop"));
			//	WebElement loop= Driver.findElement(By.xpath( "/html/body/table[2]/tbody/tr[4]/td[2]"));
			Generic.rightClick(loop);   
			expImage=Web.getImageElement("ContextMenu");
			logger(Test, " Baseline Image found", "I");
			pObj=new Pattern(expImage);
			Thread.sleep(1000);
			match=screen.exists(pObj);

			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextLoop");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextMenu Loop");
			match1.click();
			Thread.sleep(500);

			expImage2=Web.getImageElement("LoopResult");
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);

			match2=screen.exists(pObj2.exact(),5);

			Assert.assertNotNull(match2, "BaseLine image doesn't match with Screen Image");
			x= match2.getX();
			y= match2.getY();
			h= match2.getH();
			w= match2.getW();
			System.out.println(x+" "+y+" "+h+" "+w);
			actImagePath=getActualSnap(screen, "TC_16694_1", x, y, w, h);
			logger(Test, "Actual Snap is captured", "I");
			System.out.println("actImage:-"+actImagePath);
			testPass=new Imagetest().compare(expImage2, actImagePath);
			if(testPass){
				totalPass++;
				logger(Test, "Test1: Pass", "I");
			}
			else{
				logger(Test, "Test1: Fail", "F");
			}


			//Test 2
			Thread.sleep(250);
			String expImageLogo = Web.getImageElement("CaptureLogo");
			Thread.sleep(1000);
			logger(Test, "Looking for image located at :"+expImage, "I");
			Pattern expImageObj=new Pattern(expImageLogo);
			Thread.sleep(1000);
			screen.wait(expImageObj);
			screen.find(expImageObj);
			Thread.sleep(1000);
			screen.wait(expImageObj);
			screen.rightClick(expImageObj);
			Thread.sleep(1000);	         			

			String image2 = "CapturePrint";
			expImage = imageFinder(image2);
			actImagePath = printMatcher(screen, "TC_16694",expImage,image2);
			imageMatcher(expImage,actImagePath);


			if(actImagePath != null){
				totalPass++;

				logger(Test, "Test2: Pass", "I");

			}
			else{
				logger(Test, "Test2: Fail", "F");
			}




			//Test 3
			//Animation Testcase.Hence Skipping Step 2 validation.

			WebElement play= Driver.findElement(Web.getWebElement("Play"));
			Generic.rightClick(play);
			Thread.sleep(500);
			expImage=Web.getImageElement("ContextMenu3");
			logger(Test, " Baseline Image found", "I");
			pObj=new Pattern(expImage);
			match=screen.exists(pObj);
			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextPlay");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextMenu Play");
			match1.click();
			Thread.sleep(500);
			int c=0;  
			List<Pattern> pobj = new ArrayList<Pattern>();
			String[] expImage21 = new String[15];
			for(int i =0 ;i<=11;i++){

				expImage21[i]= Web.getImageElement("Test3")+"\\Frame"+i;
				System.out.println(expImage21[i]);
				logger(Test, " Frames found" +i  , "I");
				pobj.add(new Pattern(expImage21[i]));

			}
			int j=0;
			for ( Pattern pobj1 : pobj) {
				match=null;
				System.out.println("Inside for loop");
				logger(Test, "Inside for loop" +j++ , "I");
				match=screen.exists(pobj1.similar((float) 0.99));
				System.out.println("outside if " +c);
				if(match!=null){
					System.out.println("inside if " +c);
					c++;
				}
			}

			if(c==1)
			{
				logger(Test, "Test3: Pass", "I");
				totalPass++;
			}


			else{

				logger(Test, "Test3: Fail ; Could not find Test3.png on Screen. c= "+c, "F");
			}



			//Test4

			WebElement Rewind= Driver.findElement(Web.getWebElement("Rewind"));
			Generic.rightClick(Rewind);
			Thread.sleep(1000);

			expImage=Web.getImageElement("ContextMenu4");
			logger(Test, " Baseline Image found", "I");
			pObj=new Pattern(expImage);
			match=screen.exists(pObj);
			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextRewind");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			System.out.println(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextRewind");
			match1.click();

			expImage2=Web.getImageElement("RewindResult1");
			logger(Test,"Baseline RewindResult1 found","I");
			pObj2=new Pattern(expImage2);
			match2=screen.exists(pObj2);

			expImage3=Web.getImageElement("RewindResult");
			logger(Test,"Baseline RewindResult found","I");
			pObj3=new Pattern(expImage3);

			Match  match3=match2.exists(pObj3.exact());

			x= match3.getX();
			y= match3.getY();
			h= match3.getH();
			w= match3.getW();
			System.out.println(x+" "+y+" "+h+" "+w);
			actImagePath=getActualSnap(screen, "TC_16694_4", x, y, w, h);
			logger(Test, "Actual Snap is captured", "I");
			System.out.println("actImage:-"+actImagePath);
			testPass=new Imagetest().compare(expImage3, actImagePath);
			if(testPass){
				totalPass++;
				logger(Test, "Test4: Pass", "I");

			}
			else{
				logger(Test, "Test4: Fail", "F");
			}



			expImage=Web.getImageElement("ContextMenu2");
			logger(Test, " Baseline Image found", "I");
			pObj=new Pattern(expImage);





			//Test 5

			WebElement LowQuality= Driver.findElement(Web.getWebElement("LowQuality"));

			((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", LowQuality);
			Thread.sleep(500);
			Generic.rightClick(LowQuality);

			match=screen.exists(pObj);
			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextQuality");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextQuality");
			match1.click();

			expImage2=Web.getImageElement("ContextQualitySubMenu");
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);
			match1=screen.exists(pObj2);
			Assert.assertNotNull(match1, "Could not Locate ContextQualitySubmenu");


			expImage3=Web.getImageElement("Low");
			pObj3=new Pattern(expImage3);
			match2=match1.exists(pObj3.exact());			         
			match2.click();
			Thread.sleep(500);


			//  screen=new Screen();
			expImage2=Web.getImageElement("ResultQualityLow1");
			System.out.println(expImage2);
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);
			match1=screen.exists(pObj2.similar(0.99f));

			Assert.assertNotNull(match1, "Could not Locate Image");
			getActualSnap(screen, "TC_16694_5_1", match1.getX(), match1.getY(), match1.getW(), match1.getH());


			expImage3=Web.getImageElement("ResultQualityLow");
			pObj3=new Pattern(expImage3);
			match2=match1.exists(pObj3.similar(0.99f));			         
			if(match2!=null)  {  
				x= match2.getX();
				y= match2.getY();
				h= match2.getH();
				w= match2.getW();
				System.out.println(x+" "+y+" "+h+" "+w);
				actImagePath=getActualSnap(screen, "TC_16694_5", x, y, w, h);
				logger(Test, "Actual Snap is captured", "I");
				System.out.println("actImage:-"+actImagePath);
				testPass=new Imagetest().compare(expImage3, actImagePath);
				if(testPass){
					totalPass++;
					logger(Test, "Test5: Pass", "I");

				}
			}
			else{
				logger(Test, "Test5: Fail", "F");
			}   


			//Test 6

			WebElement MediumQuality= Driver.findElement(Web.getWebElement("MediumQuality"));


			Generic.rightClick(MediumQuality);

			match=screen.exists(pObj);
			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextQuality");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextQuality");
			match1.click();

			expImage2=Web.getImageElement("ContextQualitySubMenu");
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);
			match1=screen.exists(pObj2);
			Assert.assertNotNull(match1, "Could not Locate ContextQualitySubmenu");


			expImage3=Web.getImageElement("Medium");
			pObj3=new Pattern(expImage3);
			match2=match1.exists(pObj3.exact());			         
			match2.click();
			Thread.sleep(500);


			//  screen=new Screen();
			expImage2=Web.getImageElement("ResultQualityMedium1");
			System.out.println(expImage2);
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);
			match1=screen.exists(pObj2);

			Assert.assertNotNull(match1, "Could not Locate Image");
			getActualSnap(screen, "TC_16694_6_1", match1.getX(), match1.getY(), match1.getW(), match1.getH());


			expImage3=Web.getImageElement("ResultQualityMedium");
			pObj3=new Pattern(expImage3);
			match2=match1.exists(pObj3.similar(0.99f));			         
			if(match2!=null)  {  
				x= match2.getX();
				y= match2.getY();
				h= match2.getH();
				w= match2.getW();
				System.out.println(x+" "+y+" "+h+" "+w);
				actImagePath=getActualSnap(screen, "TC_16694_6_2", x, y, w, h);
				logger(Test, "Actual Snap is captured", "I");
				System.out.println("actImage:-"+actImagePath);
				testPass=new Imagetest().compare(expImage3, actImagePath);
				if(testPass){
					totalPass++;
					logger(Test, "Test6: Pass", "I");

				}
			}
			else{
				logger(Test, "Test6: Fail", "F");
			}   


			//Test 7
			WebElement HighQuality= Driver.findElement(Web.getWebElement("HighQuality"));


			Generic.rightClick(HighQuality);

			match=screen.exists(pObj);
			Assert.assertNotNull(match, "Could not Locate ContextMenu");

			expImage1=Web.getImageElement("ContextQuality");
			logger(Test, " Baseline Image found", "I");
			pObj1=new Pattern(expImage1);
			match1=match.exists(pObj1.exact());
			Assert.assertNotNull(match1, "Could not Locate ContextQuality");
			match1.click();

			expImage2=Web.getImageElement("ContextQualitySubMenu");
			logger(Test, " Baseline Image found", "I");
			pObj2=new Pattern(expImage2);
			match1=screen.exists(pObj2);
			Assert.assertNotNull(match1, "Could not Locate ContextQualitySubmenu");


			expImage3=Web.getImageElement("High");
			pObj3=new Pattern(expImage3);
			match2=match1.exists(pObj3.exact());			         
			match2.click();
			Thread.sleep(500);



			/*     
				 			       //  screen=new Screen();
				 			        expImage2=Web.getImageElement("ResultQualityHigh1");
				 			        System.out.println(expImage2);
				                     logger(Test, " Baseline Image found", "I");
				                     pObj2=new Pattern(expImage2);
				 			          match1=screen.exists(pObj2);

				 			         Assert.assertNotNull(match1, "Could not Locate Image");
				 			         getActualSnap(screen, "TC_16694_6_1", match1.getX(), match1.getY(), match1.getW(), match1.getH());
			 */     



			expImage3=Web.getImageElement("ResultQualityHigh");
			pObj3=new Pattern(expImage3);
			match2=screen.exists(pObj3);			         
			if(match2!=null)  {  
				x= match2.getX();
				y= match2.getY();
				h= match2.getH();
				w= match2.getW();
				System.out.println(x+" "+y+" "+h+" "+w);
				actImagePath=getActualSnap(screen, "TC_16694_7", x, y, w, h);
				logger(Test, "Actual Snap is captured", "I");
				System.out.println("actImage:-"+actImagePath);
				testPass=new Imagetest().compare(expImage3, actImagePath);
				if(testPass){
					totalPass++;
					logger(Test, "Test7: Pass", "I");

				}
			}
			else{
				logger(Test, "Test7: Fail", "F");
			}   





			/*	

					String expImage=Web.getImageElement("Green");
                    logger(Test, " Baseline Image found", "I");
                    Pattern pObj=new Pattern(expImage);
                    Thread.sleep(1000);
            	    match=screen.exists(pObj.exact());
            	    Assert.assertNotNull(match, "BaseLine image doesn't match with Screen Image");
            	    int x= match.getX();
         		    int y= match.getY();
         		    int h= match.getH();
         		    int w= match.getW();
         		    System.out.println(x+" "+y+" "+h+" "+w);
         	        String actImagePath=getActualSnap(screen, "TC_16694", x, y, w, h);
         	        logger(Test, "Actual Snap is captured", "I");
         			System.out.println("actImage:-"+actImagePath);
         			testPass=new Imagetest().compare(expImage, actImagePath);  
         			Assert.assertTrue(testPass, "TestCase Fails");
			 */logger(Test, "Test case is done", "I");
			 Assert.assertTrue(totalPass==7, "TC_16694 failed with  "+ (7-totalPass) + "  failed testcases.");


			 Report.endTest(Test);
		}



		catch(Exception  e){
			logger(Test, e.getMessage(),"F");

			Report.endTest(Test);

			throw e;
			}




	}
}
