
/*
 * @shubsing
 * Entry Point to the Entire Suite.Calls the TestNG framework based on the input arguments.Initailisation of basic stuff
 */
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

import utill.Generic;
import utill.HtmlWriter;

public class Test {
	public static void main(String[] args) {

		Date date = new Date();
		String temp = date.toString().substring(date.toString().length() - 4) + " "
				+ date.toString().substring(4, 16).replaceAll(":", ".");
		String Path = temp.replaceAll(" ", "_");
		Generic.setOutputPath("HTML_LOGS" + System.getProperty("file.separator") + Path);
		System.out.println(Path);

		File log_dir = new File(
				"HTML_LOGS" + System.getProperty("file.separator") + Path + File.separator + "Screenshot");
		log_dir.mkdirs();
		File log_dir2 = new File("HTML_LOGS" + System.getProperty("file.separator") + Path + File.separator
				+ "actualIMAGE" + File.separator + "tc_images");
		log_dir2.mkdirs();

		if (Generic.fos == null) {
			try {
				Generic.fos = new FileOutputStream("HTML_LOGS" + System.getProperty("file.separator") + Path
						+ System.getProperty("file.separator") + "Html.xml");
				Generic.writer = new HtmlWriter(Generic.fos, "baselines");
			} catch (Exception e) {
				System.out.println("Could not Initiate Html.xml");
				e.printStackTrace();
			}

		}
		TestNG testng = new TestNG();

		testng.setOutputDirectory("HTML_LOGS" + System.getProperty("file.separator") + Path);
		System.out.println("HTML_LOGS" + System.getProperty("file.separator") + Path);
		List<String> suites = Lists.newArrayList();

		String os = null, browser = null;

		if (args.length > 0) {

			for (String arg : args) {
				if (arg.startsWith("--OS=")) {
					String split[] = arg.split("--OS=");
					os = split[1];
				} else if (arg.startsWith("--browser=")) {
					String split[] = arg.split("--browser=");
					browser = split[1];
				} else if (arg.startsWith("--browserbits=")) {
					String split[] = arg.split("--browserbits=");
					System.out.println("Split is " + split[1]);
					Generic.setBrowserBits(split[1]);
				} else if (arg.startsWith("--build=")) {
					String split[] = arg.split("--build=");
					System.out.println("Split is " + split[1]);
					Generic.setBuildName(split[1]);
				} else if (arg.startsWith("--branchName=")) {
					String split[] = arg.split("--branchName=");
					System.out.println("Split is " + split[1]);
					Generic.setFlashbranch(split[1]);
				}

			}

		} else {

			System.out.println("NO arguments Given!!!!Exiting!!!!!");
			System.exit(0);
		}

		if (os.equalsIgnoreCase("win")) {
			if (browser.equalsIgnoreCase("Firefox")) {
				suites.add("Assets/testNG_win_firefox.xml");
				System.out.println("Using Assets/testNG_win_firefox.xml");
			} else if (browser.equalsIgnoreCase("Chrome-Pepper-Plugin")) {
				suites.add("Assets/testNG_win_chrome.xml");
				System.out.println("Using Assets/testNG_win_chrome.xml");
			} else if (browser.equalsIgnoreCase("IE")) {
				suites.add("Assets/testNG_win_ie.xml");
				System.out.println("Using Assets/testNG_win_ie.xml");
			} else if (browser.equalsIgnoreCase("Spartan")) {
				suites.add("Assets/testNG_win_edge.xml");
				System.out.println("Using Assets/testNG_win_edge.xml");
			} else {
				System.out.println(
						"Browser Name is Incorrect!!! Use these ==> IE,Firefox,Spartan,Opera,Chrome-Pepper-Plugin");
				System.exit(0);
			}

		} else if (os.equalsIgnoreCase("mac")) {
			if (browser.equalsIgnoreCase("Firefox")) {
				suites.add("Assets/testNG_mac_firefox.xml");
				System.out.println("Using Assets/testNG_mac_firefox.xml");
			} else if (browser.equalsIgnoreCase("Chrome-Pepper-Plugin")) {
				suites.add("Assets/testNG_mac_chrome.xml");
				System.out.println("Using Assets/testNG_mac_chrome.xml");
			} else if (browser.equalsIgnoreCase("Safari")) {
				suites.add("Assets/testNG_mac_safari.xml");
				System.out.println("Using Assets/testNG_mac_safari.xml");
			} else {
				System.out.println(
						"Browser Name is Incorrect!!! Use these ==> IE,Firefox,Spartan,Opera,Chrome-Pepper-Plugin,Safari");
				System.exit(0);
			}
		} else {
			System.out.println("OS name should be given in small letters!Either mac/win  Exiting!!!");
			System.exit(0);
		}

		testng.setTestSuites(suites);
		testng.run();
	}

}
