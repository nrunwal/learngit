package htmlTestCase;


import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import utill.Generic;
import utill.Imagetest;


public class TC_41629 extends Generic{

//Firefox Only

	   @BeforeMethod
		public void tc_Start() throws JDOMException, IOException{
			Generic.setCurrentTestBaselinePath(TC_41629.class.getSimpleName());
	        //Xml.elementHandler(TC_44895.class.getSimpleName());
	    }
		
		
	    @AfterMethod
		public void tc_end() throws JDOMException, IOException{
	    	System.out.println("Done TC_41629");
	    }
	
	
	    
	    public static void fn_VAL(Match  match, Screen screen) throws FileNotFoundException, IOException, InterruptedException, FindFailed{
	    	String DeviceImage=Web.getImageElement("Device");
	 		Pattern DeviceObj=new Pattern(DeviceImage);
			//screen.wait(10);
			Thread.sleep(1000);
		    match=screen.exists(DeviceObj);
		    Assert.assertNotNull(match, "Device BaseLine image is not matched from Screen Image"); 
		    screen.click(DeviceImage);
		    logger(Test, "Device Drop down menu is clicked", "I");
	 		
		    String EmbeddedImage=Web.getImageElement("Embedded");
	 		Pattern EmbeddedObj=new Pattern(EmbeddedImage);
			//screen.wait(10);
			Thread.sleep(1000);
		    match=screen.exists(EmbeddedObj);
		    Assert.assertNotNull(match, " Embedded BaseLine image is not matched from Screen Image"); 
		    screen.click(EmbeddedImage);
		    logger(Test, "Embedded is selected", "I");
	 		
		        String RunTestImage=Web.getImageElement("RunTest");
		  		Pattern RunTestObj=new Pattern(RunTestImage);
		 		//screen.wait(10);
		 		Thread.sleep(1000);
		 	    match=screen.exists(RunTestObj);
		 	    Assert.assertNotNull(match, "RunTest BaseLine image is not matched from Screen Image"); 
		 	    screen.click(RunTestImage);
		 	    logger(Test, "RunTest is clicked", "I");
	    }
	    
	    
	    
	
	@SuppressWarnings("static-access")
	
	@Test
	public static void tc_41629() throws Exception{
	
		logger(Report, "TC_41629", "Verify SWFbox & new window"); 
		logger(Test, "Br is launch", "I");
		
		Match match = null;
		Screen screen;
try
{		
		
	    screen =new Screen();
	    String URL="http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/BugRegression/2825071/Bug2825071.html";
		Driver.get(URL);
		logger(Test, "URL is Enter", "I");
	//	System.out.println("Title:- "+Driver.getTitle());
 		Assert.assertTrue(Driver.getTitle().contains("Bug 2825071 Regression"), "Actual Page title:- "+Driver.getTitle()+" doesn't match with expected:-'Bug 2825071 Regression' Title");
 		logger(Test, "BR title is matched", "I");
 		String firstHVal=Driver.getWindowHandle();
 		String currentURL=Driver.getCurrentUrl();
 	
 		fn_VAL(match, screen);
 		 		
 		Driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
 		Driver.switchTo().window(Driver.getWindowHandle());
 		 String URLImage=Web.getImageElement("EnterURL");
 		Pattern urlObj=new Pattern(URLImage);
 		Match status=screen.exists(urlObj);
 		Assert.assertNotNull(status,"url bar is not matched with expected url bar");
 		screen.type(urlObj, URL);
 		Robot r=new Robot();
 		r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
 		r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
 		
 		  Thread.sleep(10000);
 	 	  fn_VAL(match, screen);
 	 	  Thread.sleep(10000);
 	 	 String FrameCNTImage=Web.getImageElement("FrameCNT");
 			Pattern RunTestObj=new Pattern(FrameCNTImage);
 			//screen.wait(10);
 			Thread.sleep(1000);
 		    match=screen.exists(RunTestObj);
 		    Assert.assertNotNull(match, "FrameCNT BaseLine image is not matched from Screen Image"); 
 		    screen.click(FrameCNTImage);
 		    logger(Test, "FrameCNT is matched", "I");
 		
 		//Driver.navigate().to(URL);
// 		
 		
 		
 	/*	Robot r=new Robot();
 		r.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
 		r.keyPress(java.awt.event.KeyEvent.VK_N);
 		r.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
 		r.keyRelease(java.awt.event.KeyEvent.VK_N);
 		
 		Set<String> CollVal=Driver.getWindowHandles();
 		Iterator<String> iteratorVal=CollVal.iterator();
 		while(iteratorVal.hasNext()){
 			String val=iteratorVal.next();
 		    if(val!=firstHVal){
 		    	Driver.switchTo().window(val);
 		    	Driver.get(URL);
 		    }
 		
 		}*/
 		
 		
// 		System.out.println("Size:- "+new ArrayList<String> (Driver.getWindowHandles()).size());
 		ArrayList<String> tabColl=new ArrayList<String> (Driver.getWindowHandles());
// 	   Assert.assertTrue(new ArrayList<String> (Driver.getWindowHandles()).size()==1,"Second tab is not opened");
 	  
 	/*  for(int i=0; i<=tabColl.size(); i++){
 		   String Val=tabColl.get(i).toString();
 		   if(firstHVal!=Val){
 	 		   System.out.println(",hhhhhhhhh");
 	 		   Driver.switchTo().window(tabColl.get(i));
 	 		   System.out.println("2nd tab done");
 	 		   //Driver.navigate().to(currentURL);
 	 		   Thread.sleep(10000);
 	 		   System.out.println(",fndbngfbkfj");
 	 		}
 	   }*/
 	
 	   
 		
 	   
 	   
 	   
 	   
 	   
 	 /*   String expImage=Web.getImageElement("SWFbox");
 		Pattern pObj=new Pattern(expImage);
		//screen.wait(10);
		Thread.sleep(1000);
	    match=screen.exists(pObj);
	    Assert.assertNotNull(match, "BaseLine image is not matched from Screen Image"); 
	       int x= match.getX();
		   int y= match.getY();
		   int h= match.getH();
		   int w= match.getW();
		    System.out.println(x+" "+y+" "+h+" "+w);
	    String actImagePath=getActualSnap(screen, "TC_41629", x, y, w, h);*/
	    
	 //   logger(Test, "Actual Snap is captured", "I");
	/*	System.out.println("actImage:-"+actImagePath);
		new Imagetest().compare(expImage, actImagePath);*/
	//	Driver.getWindowHandles();
	
	
	   
	   logger(Test, "Test case is done", "I");
		Report.endTest(Test);
		

}catch(AssertionError e){
	logger(Test, e.getMessage(),"F");
	Report.endTest(Test);
	throw e;
 
}catch(Exception e){
	logger(Test,e.getMessage(),"F");
	Report.endTest(Test);
    throw e;
}
			
	  
			
	  
}
	
}


	
