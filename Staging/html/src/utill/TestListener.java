package utill;


import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener extends Generic implements ITestListener  {
	WebDriver driver=null;
	//String filePath=new File("ScreenShot").getAbsolutePath();
	String filePath=Generic.getOutputPath()+File.separator+"Screenshot";
	private static final String slash = System.getProperty("file.separator");
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName);
    }
    
	public void takeScreenShot(String methodName) {
    	//get the driver
    	WebDriver driver=Driver;
    	if(CURRENTBROWSER.equals("firefox")){
    		try {
                String fileName = filePath+ slash +methodName+".png";  
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage screenFullImage = MyRobot.getInstance().createScreenCapture(screenRect);
                ImageIO.write(screenFullImage, "png", new File(fileName));
                 
                System.out.println("A full screenshot saved!");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }else{
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
            	String location=filePath+ slash +methodName+".png";
				FileUtils.copyFile(scrFile, new File(location));
				System.out.println("***Placed screen shot in "+location+" ***");
			} catch (IOException e) {
				System.out.println("INside Catch in TestListener");
				e.printStackTrace();
			}
    	}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  