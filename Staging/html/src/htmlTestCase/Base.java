package htmlTestCase;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import java.net.UnknownHostException;

import org.jdom2.JDOMException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.sikuli.script.App;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import utill.Generic;
import utill.SocketManager;

public class Base extends Generic{
	 static long startTime;
	 static long endTime;
	 public static ServerSocket svrsock;
	 public static long executionTime;
	 @SuppressWarnings("static-access")
	 @Parameters({ "browser", "OS" })
	 @BeforeTest
	 public void  brLauncher(String browser, String OS) throws JDOMException, IOException{
		 
		@SuppressWarnings("unused")
		ExtentReports report=reporter();
		GenericChild.webUtill().launchBrowser(browser, OS);
		/*Driver.manage().window().maximize();*/
		Generic.setcurrentBR(browser);
		Generic.setcurrentOS(OS);
		startTime = System.currentTimeMillis();
		if((OS.equals("mac")==true && browser.equals("chrome")==true)){
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Point position = new Point(0, 0);
			Driver.manage().window().setPosition(position);
			Dimension maximizedScreenSize =
					new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());

			Driver.manage().window().setSize(maximizedScreenSize);
		}else if((OS.equals("mac")==true && browser.equals("firefox")==true)){
			//App.focus(browser);
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Point position = new Point(0, 0);
			Driver.manage().window().setPosition(position);
			Dimension maximizedScreenSize =
					new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());

			Driver.manage().window().setSize(maximizedScreenSize);
		}else if(browser.equals("firefox")){
			App.focus(browser);
		}else{
			App.focus(browser);
			Driver.manage().window().maximize();
		}	
		
		 java.net.InetAddress localMachine;
			try {
				localMachine = java.net.InetAddress.getLocalHost();
				System.out.println("Hostname of local machine: " + localMachine.getHostName());
				Generic.setMachineName(localMachine.getHostName());
				
			} catch (UnknownHostException e) {
			
				e.printStackTrace();
			}
		
		
		
	}
	@BeforeTest(dependsOnMethods = { "brLauncher" })
	public void getFlashDetails(){
		
		Generic.sockMan=new SocketManager(new Generic());
		Generic.sockMan.start();
		Driver.get("http://fpqa.macromedia.com/version/getVersion.html");
	    	
	     try {
			Thread.sleep(5000);
		   }catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	     
	    }
	
	@BeforeTest(dependsOnMethods = { "brLauncher","getFlashDetails" })
	public void downloadBaselineFolder(){
		System.out.println("Path:  "+Generic.getBaselinePath());
		String CurrentDir=System.getProperty("user.dir");
		
		String RemotePath=Generic.getbaselineServerPath()+Generic.getBaselinePath();
		String SaveDir=CurrentDir+File.separator+Generic.getBaselinePath();
		System.out.println(RemotePath+"                "+SaveDir);
		try {
			Generic.downloadDirectory(RemotePath, SaveDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not Download baseline!!!");
		}
	    }
	
	@BeforeTest(dependsOnMethods = { "brLauncher","getFlashDetails","downloadBaselineFolder"})
	public void CalculateOffset(){
		if(CURRENTBROWSER.equals("firefox")){
		
			System.out.println("Offset is being Calculated!!!! Using the Textbox in TC_44954 to do so.");	
			if(CURRENTOS.equals("mac")){
				try{
					String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/Bug3300031/index.html";
					Driver.get(url);
					Thread.sleep(500);
					
					Screen s = new Screen();
			        String Path=System.getProperty("user.dir")+File.separator+Generic.getBaselinePath()+File.separator+"TC_Offset"+File.separator+"TextBox1";
					System.out.print("Baseline for Offset calculationn ==>"+Path);
					Pattern pObj=new Pattern(Path);
					Match match=s.exists(pObj);
					int x= match.getX();
					int y= match.getY();
					
					
					WebElement ele = Driver.findElement(By.xpath("/html/body/h3[1]"));
					Point point = ((Locatable)ele).getCoordinates().inViewPort();
				// Get offset of the element.
					System.out.println("X offset:" + (point.getX()-x) + "Y offset :" +(point.getY()-y));
					Generic.setOffset((point.getX()-x),(point.getY()-y));
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				try{
					String url = "http://ats.macromedia.com/Players/ATS/ATS10AS3/Shipping/html/Security/Bug3300031/index.html";
					Driver.get(url);
					Thread.sleep(500);
					
					Screen s = new Screen();
			        String Path=System.getProperty("user.dir")+File.separator+Generic.getBaselinePath()+File.separator+"TC_Offset"+File.separator+"TextBox";
					System.out.print("Baseline for Offset calculationn ==>"+Path);
					Pattern pObj=new Pattern(Path);
					Match match=s.exists(pObj);
					int x= match.getX();
					int y= match.getY();
					
					
					WebElement ele = Driver.findElement(By.xpath("/html/body/div[5]/ul/form/input"));
					Point point = ((Locatable)ele).getCoordinates().inViewPort();
				// Get offset of the element.
					System.out.println("X offset:" + (point.getX()-x) + "Y offset :" +(point.getY()-y));
					Generic.setOffset((point.getX()-x),(point.getY()-y));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	
		}
		else{
			System.out.println("No Offset Calculation is required!!!!");
		}
	}
	@AfterTest
     public  void brShutDown(){
    	 
    	   Generic.sockMan.stopSockMan();
		   logger(Test, "Br is Closed", "I");
    	   Report.flush();
           //Driver.close();
    	   endTime = System.currentTimeMillis();
    	   executionTime = endTime - startTime;
		   Driver.quit();
		
	}
	
}
