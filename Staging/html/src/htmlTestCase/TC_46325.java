package htmlTestCase;


import java.io.IOException;


import org.jdom2.JDOMException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utill.Generic;


public class TC_46325 extends Generic{


	@SuppressWarnings("static-access")
	   @BeforeMethod
		public void tc_Start() throws JDOMException, IOException{
	  
		Generic.setCurrentTestBaselinePath(TC_46325.class.getSimpleName());
	    }
		
		
	    @AfterMethod
		public void tc_end() throws JDOMException, IOException{
	    	System.out.println("Done TC_46325");
	    }
	
	
	
	@SuppressWarnings("static-access")
	
	@Test
	public static void tc_46325() throws IOException, InterruptedException{
	
		logger(Report, "TC_46325", "Verify Hello Word"); 
		logger(Test, "Br is launch", "I");
		
		
try
{		
		
	    String text1="Fetch the target url";
	    String text2="x0c added to";
	    String text3="x09 added to";
	    
		Driver.get("http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/MozillaBug4055745/regress_poc.html");
		logger(Test, "URL is Enter", "I");
 		Assert.assertTrue(Driver.getTitle().contains("Regression Test Case for https://watsonexp.corp.adobe.com/#bug=4055745"), "Actual Page title:- "+Driver.getTitle()+" doesn't match with expected:-'Regression Test Case for https://watsonexp.corp.adobe.com/#bug=4055745' Title");
 		logger(Test, "BR title is matched", "I");
 		
 	    WebElement webE1=Driver.findElement(Generic.Web.getWebElement("fetch1")); 
 	    Assert.assertTrue(webE1.isDisplayed(),text1+" 'WebElement' is not displayed");
		Assert.assertTrue(webE1.getText().contains(text1), "Expected text:-- "+text1+" doesn't match from Actual text:-- "+webE1.getText());
		webE1.click();
		Thread.sleep(1000);
		WebElement webE1_ACT=Driver.findElement(Generic.Web.getWebElement("fetch1_result"));
		Assert.assertTrue(webE1_ACT.getText().equalsIgnoreCase("PASSED"), "Expected 'PASSED' result does not match from Actual resut "+webE1_ACT.getText());
		
		
	    WebElement webE2=Driver.findElement(Generic.Web.getWebElement("fetch2")); 
 	    Assert.assertTrue(webE2.isDisplayed(),text2+" 'WebElement' is not displayed");
		Assert.assertTrue(webE2.getText().contains(text2), "Expected text:-- "+text2+" doesn't match from Actual text:-- "+webE2.getText());
		webE2.click();
		Thread.sleep(1000);
		WebElement webE2_ACT=Driver.findElement(Generic.Web.getWebElement("fetch2_result"));
		Assert.assertTrue(webE2_ACT.getText().equals("PASSED"), "Expected 'PASSED' result does not match from Actual resut "+webE2_ACT.getText());
		
		
	    WebElement webE3=Driver.findElement(Generic.Web.getWebElement("fetch3")); 
 	    Assert.assertTrue(webE3.isDisplayed(),text3+" 'WebElement' is not displayed");
		Assert.assertTrue(webE3.getText().contains(text3), "Expected text:-- "+text3+" doesn't match from Actual text:-- "+webE3.getText());
		webE3.click();
		Thread.sleep(1000);
		WebElement webE3_ACT=Driver.findElement(Generic.Web.getWebElement("fetch3_result"));
		Assert.assertTrue(webE1_ACT.getText().equals("PASSED"), "Expected 'PASSED' result does not match from Actual resut "+webE3_ACT.getText());
		
		
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


	
