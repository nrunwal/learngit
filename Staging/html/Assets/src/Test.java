

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import utill.Generic;
import utill.HtmlWriter;

public class Test {
	 public static void main ( String [ ] args) 
	  {
		 
		 Date date=new Date();
		 String temp = date.toString().substring(date.toString().length() - 4) + " "
						+ date.toString().substring(4, 16).replaceAll(":", ".");
		 String Path=temp.replaceAll(" ", "_");
		 Generic.setOutputPath("HTML_LOGS"+System.getProperty("file.separator")+Path);
		 System.out.println(Path);
			
		File log_dir = new File("HTML_LOGS"+System.getProperty("file.separator")+Path+File.separator+"Screenshot");
				 log_dir.mkdirs();
		File log_dir2=new File("HTML_LOGS"+System.getProperty("file.separator")+Path+File.separator+"actualIMAGE"+File.separator+"tc_images");
		log_dir2.mkdirs();

         if(Generic.fos==null){
        	 try {
			  	Generic.fos=new FileOutputStream("HTML_LOGS"+System.getProperty("file.separator")+Path+System.getProperty("file.separator")+"Html.xml");
			    Generic.writer=new HtmlWriter(Generic.fos,"baselines");
        	 } catch (Exception e) {
				System.out.println("Could not Initiate Ullu.xml");
				e.printStackTrace();
			}
        	 
         }
		 TestListenerAdapter tla = new TestListenerAdapter();
		 TestNG testng = new TestNG();
		 
		 testng.setOutputDirectory("HTML_LOGS"+System.getProperty("file.separator")+Path);
		 System.out.println("HTML_LOGS"+System.getProperty("file.separator")+Path);
		 List<String> suites = Lists.newArrayList();
		 
		 if (args.length > 0){
			 switch(args[0]){
			 case "win":
				 switch(args[1]){
				 case "firefox":
				 case "FF":
				 case "mozilla":
				 case "Firefox":	 
					 suites.add("testNG_win_firefox.xml");
					 break;
				 case "chrome":
				 case "CHM":
				 case "Chrome":	 
				      suites.add("testNG_win_chrome.xml");
				      System.out.println("Using testNG_win_chrome.xml");
				      break;
				 case "ie":
				 case "InternetExplorer":
				 case "internetexplorer":
				 case  "iexplore":
					 suites.add("testNG_win_ie.xml");
					 System.out.println("Using testNG_win_ie.xml");
					 break;
				 case "Edge":
				 case "Spartan":
				 case "spartan":	 
				 case "edge":
					 suites.add("testNG_win_edge.xml");
					 System.out.println("Using testNG_win_edge.xml");					 
					 break;
				  default:
					  System.out.println("Arguments are incorrect!!! Exiting!");
					  System.exit(0);
					  break;
					  }
				 break;
			 
			 case "mac":
				 switch(args[1]){
				 case "firefox":
				 case "FF":
				 case "mozilla":
				 case "Firefox":	 
					 suites.add("testNG_mac_firefox.xml");
					 System.out.println("Using testNG_mac_firefox.xml");
					 break;
				 case "chrome":
				 case "CHM":
				 case "Chrome":	 
				      suites.add("testNG_mac_chrome.xml");
				      System.out.println("Using testNG_mac_chrome.xml");
				      break;
				 case "safari":
				 case "Safari":	 
					 suites.add("testNG_mac_safari.xml");
					 System.out.println("Using testNG_mac_safari.xml"); 
					 break;
				 default:
					 System.out.println("BrowserName is incorrect!!! Exiting!");
					  System.exit(0);
					  break;
			 }
			 break;
			 default:
				 System.out.println("OS name should be given in small letters!Please check! Exiting!!!");
				 System.exit(0);
				  break;
	            }
			 Generic.setBrowserBits(args[2]);}
		 else{
		 
		 System.out.println("NO arguments Given!!!!Running Default TestNG.xml!!!!");
		 suites.add("testNG.xml");//path to xml..
		 }
		 Generic.setBrowserBits(args[2]);
		 Generic.setBuildName(args[3]);
		 Generic.setFlashbranch(args[4]);
		 testng.setTestSuites(suites);
		 testng.run();
	  }

}
