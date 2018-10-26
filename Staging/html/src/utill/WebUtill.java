package utill;

import java.awt.Toolkit;
/*
 @shubsing
 This Class launches the browser using appropriate Drivers. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class WebUtill extends Generic {
	private static final String slash = System.getProperty("file.separator");

	public static WebDriver launchBrowser(String browserNAME, String OS) {
		String currentDir = System.getProperty("user.dir");

		try {

			/*
			 * String buildName = Generic.getBuildName(); // Play_20_0_d0_123
			 * buildName = buildName.replace("Play_", ""); buildName =
			 * buildName.replace("_", "."); buildName = buildName.replace("d",
			 * ""); buildName = buildName.replace("r", "");
			 * System.out.println("buildName ="+ buildName);
			 */
			String buildName = Generic.getBuildName();// Play_20_0_d0_123

			String[] parts = buildName.split("_");
			String part2 = parts[1]; // 20
			String part3 = parts[2]; // 0
			String part4 = parts[3].replace("d", ""); // d0
			part4 = part4.replace("r", "");
			String part5 = parts[4]; // 123
			buildName = part2 + "." + part3 + "." + part4 + "." + part5;
			System.out.println(buildName + " <==  buildName");

			if (OS.equalsIgnoreCase("MAC")) {

				if (browserNAME.contains("safari")) {

					System.out.println("Starting Safari Driver!Ensure that Webdriver Extension is Installed");
					Driver = new SafariDriver();

				} else if (browserNAME.contains("chrome")) {
					try {
						if (Generic.getBrowswerBits().equals("32")) {
							ChromeDriverManager.getInstance().arch32().setup();
						} else {
							ChromeDriverManager.getInstance().arch64().setup();
						}
					} catch (Exception e) {
						System.setProperty("webdriver.chrome.driver",
								"driver" + slash + "mac" + slash + "chromedriver");
						System.out
								.println("Starting ChromeDriver! Path: " + currentDir + "\\driver\\mac\\chromedriver");
					}

					ChromeOptions options = new ChromeOptions();
					String filepath = "/Users/admin/Download/TofuWorkspace/new/downloads/installers/PepperFlashPlayer.plugin";
					System.out.println(" Temporary filepath is " + filepath);
					options.addArguments("start-maximized");
					options.addArguments("disable-infobars");
					options.addArguments("--ppapi-flash-path=" + filepath);
					options.addArguments("--ppapi-flash-version=" + buildName);

					Driver = new ChromeDriver(options);
					System.out.println(Driver);

				} else if (browserNAME.contains("firefox")) {
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("dom. ipc. plugins. enabled", true);
					profile.setPreference("browser.flash-protected-mode-flip.enable", false);

					profile.setPreference("plugins.flashBlock.enabled", false);

					profile.setPreference("plugin.state.flash", 2);

					try {
						System.setProperty("wdm.gitHubTokenName", "shubsing");
						System.setProperty("wdm.gitHubTokenSecret", "89e9aaf270b10ba5d1d1a6f2f6ac75a0480e91a7");
						// System.setProperty("webdriver.gecko.driver","driver"+slash+"mac"+slash+"geckodriver");
						System.out.print("Set the Property");
						FirefoxDriverManager.getInstance().setup();
					} catch (Exception e) {
						System.setProperty("webdriver.gecko.driver", "driver" + slash + "mac" + slash + "geckodriver");
						System.out.print("Using local Webdriver");
						System.out.print("Starting Firefox Driver!Path:" + currentDir + " //driver//mac//geckodriver");
					}
					Driver = new FirefoxDriver(profile);
					try {
						Thread.sleep(1500);
						Driver.manage().window().maximize();
						Thread.sleep(1500);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

				}
			} else if (OS.equalsIgnoreCase("WIN")) {

				if (browserNAME.contains("firefox")) {
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("dom. ipc. plugins. enabled", true);
					profile.setPreference("browser.flash-protected-mode-flip.enable", false);

					profile.setPreference("plugins.flashBlock.enabled", false);

					profile.setPreference("plugin.state.flash", 2);

					try {
						System.setProperty("wdm.gitHubTokenName", "shubsing");
						System.setProperty("wdm.gitHubTokenSecret", "89e9aaf270b10ba5d1d1a6f2f6ac75a0480e91a7");
						System.out.print("Set the Property");
						if (Generic.getBrowswerBits().equals("32")) {
							FirefoxDriverManager.getInstance().arch32().setup();
						} else {
							FirefoxDriverManager.getInstance().arch64().setup();
						}
					}

					catch (Exception e) {
						System.out.print("Using Local Driver!!!");
						System.out.print("Starting Firefox Driver!Path:" + currentDir + " driver\\geckodriver");
						System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
					}
					Driver = new FirefoxDriver(profile);
					try {
						Thread.sleep(500);
						Driver.manage().window().maximize();
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (browserNAME.contains("chrome")) {

					try {
						if (Generic.getBrowswerBits().equals("32")) {
							ChromeDriverManager.getInstance().arch32().setup();
						} else {
							ChromeDriverManager.getInstance().arch64().setup();
						}
					} catch (Exception e) {
						System.out.print("Using Local Driver!!!");
						System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
					}

					String filepath = "C:\\tofu_build_workspace\\downloads\\installers\\pepflashplayer.dll";
					ChromeOptions options = new ChromeOptions();

					System.out.println(" Temporary filepath is  " + filepath);
					// options.addArguments("--allow-outdated-plugins");
					options.addArguments("--disable-popup-blocking");
					// options.addArguments("--disable-bundled-ppapi-flash");
					options.addArguments("--no-first-run");
					// options.setExperimentalOption("excludeSwitches",
					// Arrays.asList("disable-component-update"));
					options.addArguments("--ppapi-flash-path=" + filepath);
					options.addArguments("--ppapi-flash-version=" + buildName);
					options.addArguments("start-maximized");
					options.addArguments("disable-infobars");

					Driver = new ChromeDriver(options);

				} else if (browserNAME.contains("ie")) {

					try {
						InternetExplorerDriverManager.getInstance().setup();

					} catch (Exception e) {
						System.out.print("Using Local Driver!!!");
						System.out.println(
								"Starting ie browser!Ensure Protected Mode Settings are the same!!Disable Enhanced Protected Mode!!!Check for value in registry!!!!");
						System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
						DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
						// Settings to Accept the SSL Certificate in the
						// Capability object
						capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						System.out.println(e.getMessage());
						System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");

					}
					Driver = new InternetExplorerDriver();
				} else if (browserNAME.contains("edge")) {

					System.out.println(
							"Starting Edge browser!Ensure that MicrosoftWebDriver.exe matches WINVER of the current machine!!! ");

					try {
						//System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");

						EdgeDriverManager.getInstance().setup();
					} catch (Exception e) {
						System.out.print("Using Local Driver!!!");
						System.setProperty("webdriver.edge.driver", "driver/MicrosoftWebDriver.exe");
					}
					Driver = new EdgeDriver();
				}

			}
		} catch (Exception e) {
			Generic.setDriverFailure(true);
			System.out.println("Driver Initialisation failure! :" + e.getMessage());

		}

		return Driver;

	}

	// ToDo:Move to DataHandler
	@SuppressWarnings("static-access")
	public static By getWebElement(String locatorName) throws IOException {
		DataHandler instance = new DataHandler();

		Map<String, String> colletionVAL = instance.collection;
		String locatorValue = colletionVAL.get(locatorName).toString();
		String locatorType = null;
		for (int i = 0; i <= colletionVAL.size() - 1; i++) {
			if (locatorName.equals(instance.Name.get(i).toString())) {
				locatorType = instance.Type.get(i).toString();
			}
		}

		// WebDriver Driver = null;
		By we = null;

		if (locatorType.equalsIgnoreCase("XP")) {
			we = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("CSS")) {
			we = By.cssSelector(locatorValue);
		} else if (locatorType.equalsIgnoreCase("CLS")) {
			we = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("ID")) {
			we = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("NM")) {
			we = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("LK")) {
			we = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("PLK")) {
			we = By.partialLinkText(locatorValue);
		} else {
			System.out.println();
			logger(Test, locatorType + " - Wrong locator type. Please check", "E");
		}
		return we;
	}

	public static String getImageElement(String name) {

		return Generic.getCurrentTestBaselinePath() + File.separator + name;
	}

	public static void openURL(String url) {
		Driver.get(url);
	}

}
