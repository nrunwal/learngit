package utill;

import java.io.File;
import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

/*
 * @shubsing
 * Getting the Test statistics(Pass/Fail/Skipped) + Generating XML to push + Pushing the bitmaps onto server.
 * This class is a Listener of testNG xml  <listener class-name="utill.TestStatistics"/>

 */
public class TestStatistics implements IReporter {

	protected Vector<String> HTMLBitmaps;
	protected Vector<String> Screenshot;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		// Closing Html.xml used for the Validation tool
		try {
			Generic.writer.writeXML();
		} catch (Exception e1) {
			System.out.println("Could not Write XML");
			e1.printStackTrace();
		}
		// End

		// Creating a XML which is to be pushed onto the dashboard.
		File xmlResult = null;
		Element testsuites = new Element("testsuites");
		final Document doc = new Document(testsuites);

		long time1 = htmlTestCase.Base.executionTime;
		TimeUnit.MILLISECONDS.toMinutes(time1);
		System.out.println("Time : " + time1);
		String time = String.valueOf(time1);// time

		// Setting email parameter
		if (Generic.getDriverFailure()) {
			SendEmail.send("DriverFailure");
		}

		else {

			/*
			 * Proceeding further only if the installed Flash Version matches
			 * with the arguments given. ToDo : Exit early if the flash versions
			 * do not match. This should be done after entire automation is
			 * completed as this assists in debugging
			 */
			if (Generic.IsFlashVersionCorrect()) {
				try {
					// Iterating over each suite included in the test
					for (ISuite suite : suites) {
						// Following code gets the suite name
						String suiteName = suite.getName();// name
						// String time=suite.
						Element testsuite = new Element("testsuite");
						String date_string;
						final Date now = new Date();
						SimpleDateFormat formatter;
						SimpleDateFormat formatter2;
						formatter = new SimpleDateFormat("yyyy-MM-dd");
						formatter2 = new SimpleDateFormat("HH:MM:ss");
						date_string = formatter.format(now) + "T" + formatter2.format(now);// timestamp

						// Getting the results for the said suite
						Map<String, ISuiteResult> suiteResults = suite.getResults();
						for (ISuiteResult sr : suiteResults.values()) {
							ITestContext tc = sr.getTestContext();

							System.out.println("Passed tests for suite '" + suiteName + "' is:"
									+ tc.getPassedTests().getAllResults().size());
							int totalPass = tc.getPassedTests().getAllResults().size();// Passed
							Generic.settotalPass(totalPass);

							System.out.println("Failed tests for suite '" + suiteName + "' is:"
									+ tc.getFailedTests().getAllResults().size());
							int totalFail = tc.getFailedTests().getAllResults().size();
							Generic.settotalFail(totalFail);
							System.out.println("Skipped tests for suite '" + suiteName + "' is:"
									+ tc.getSkippedTests().getAllResults().size());
							int totalSkipped = tc.getSkippedTests().getAllResults().size();// errors
							Generic.settotalskipped(totalSkipped);
							int total = totalPass + totalFail + totalSkipped;// tests

							testsuite.setAttribute("errors", Integer.toString(totalSkipped));
							testsuite.setAttribute("failures", Integer.toString(totalFail));
							testsuite.setAttribute("name", suiteName);
							testsuite.setAttribute("tests", Integer.toString(total));
							testsuite.setAttribute("time", time);
							testsuite.setAttribute("timestamp", date_string);

							final Element properties = new Element("properties");

							Map<String, String> PropertyTag = new HashMap<String, String>();
							PropertyTag.put("playerversion", Generic.getFlashVersion());
							PropertyTag.put("playerdebug", String.valueOf(Generic.getIsdebug()));
							PropertyTag.put("playerType", Generic.getPlayerType());
							if (Generic.getPlayerType().equalsIgnoreCase("activex")) {
								PropertyTag.put("subproduct", "activex");
							} else if (Generic.getPlayerType().equalsIgnoreCase("plugin")) {
								switch (Generic.currentBR()) {
								case "chrome":
									PropertyTag.put("subproduct", "google_pepper_plugin");
									break;
								case "firefox":
								case "safari":
									PropertyTag.put("subproduct", "adobe_plugin");

								}
							}
							PropertyTag.put("branch", Generic.getFlashbranch());
							PropertyTag.put("product", "player");
							if (Generic.getIsdebug()) {
								PropertyTag.put("target", "debug");
							} else {
								PropertyTag.put("target", "release");
							}

							PropertyTag.put("tofurunid", Generic.getTofuRunID());
							if (Generic.CURRENTBROWSER.equals("edge")) {
								PropertyTag.put("container", "spartan");

							} else {
								PropertyTag.put("container", Generic.CURRENTBROWSER);
							}
							if (Generic.getbrowserVersion() != null) {
								PropertyTag.put("browserversion", Generic.getbrowserVersion());
							} else {
								PropertyTag.put("browserversion", "00");
							}
							PropertyTag.put("browserbits", Generic.getBrowswerBits());
							if (Generic.CURRENTOS.equals("mac")) {
								PropertyTag.put("os", "Mac OS X");
								PropertyTag.put("osver", Generic.getOsVersion()
										.substring((Generic.getOsVersion().indexOf("Mac OS ") + 7)));
							} else {
								PropertyTag.put("os", Generic.getOsVersion());
								PropertyTag.put("osver", System.getProperty("os.version"));
							}
							PropertyTag.put("osbits", Generic.getCpuArchitecture());
							PropertyTag.put("build", Generic.getBuildName());
							PropertyTag.put("buildtype", "daily");
							PropertyTag.put("buildchangelist", "1111111");
							java.net.InetAddress localMachine;
							try {
								localMachine = java.net.InetAddress.getLocalHost();
								System.out.println("Hostname of local machine: " + localMachine.getHostName());
								PropertyTag.put("hostname", localMachine.getHostName());
							} catch (UnknownHostException e) {

								e.printStackTrace();
							}

							try {
								PropertyTag.put("machineipv4", Inet4Address.getLocalHost().getHostAddress());
							} catch (UnknownHostException e) {
								e.printStackTrace();
							}
							PropertyTag.put("tofuversion", "4.0");
							PropertyTag.put("crash", "false");
							PropertyTag.put("runlog", "http://fpqa.macromedia.com/Tofu/HTML_logs/"
									+ Generic.getBuildName() + "/" + Generic.getTofuRunID());

							System.out.println("isdebug=" + Generic.getIsdebug() + "flash version="
									+ Generic.getFlashVersion() + "playertype=" + Generic.getPlayerType());

							for (Map.Entry<String, String> entry : PropertyTag.entrySet()) {
								Element new_property = new Element("property");
								new_property.setAttribute("name", entry.getKey());
								new_property.setAttribute("value", entry.getValue());
								properties.addContent(new_property);
							}

							testsuite.addContent(properties);

							Set<ITestResult> TestResult = tc.getPassedTests().getAllResults();
							for (ITestResult tr : TestResult) {

								String methodName = tr.getName().toString().trim();
								String className = tr.getMethod().getTestClass().getName();
								System.out.println(methodName);
								Element testcase = new Element("testcase");
								testcase.setAttribute("classname", className);
								
								testcase.setAttribute("name", methodName.substring(3));
								long temp = tr.getEndMillis() - tr.getStartMillis();
								System.out.println(temp);
								long temp2 = TimeUnit.MILLISECONDS.toMinutes(temp);
								System.out.println(temp2);
								testcase.setAttribute("time", String.valueOf(temp));
								testsuite.addContent(testcase);

							}

							Set<ITestResult> TestResult2 = tc.getFailedTests().getAllResults();

							for (ITestResult tr : TestResult2) {
								String className = tr.getMethod().getTestClass().getName();
								String methodName = tr.getName().toString().trim();
								System.out.println(methodName);
								Element testcase = new Element("testcase");
								testcase.setAttribute("classname", className);
								testcase.setAttribute("name", methodName.substring(3));
								long temp = tr.getEndMillis() - tr.getStartMillis();
								TimeUnit.MILLISECONDS.toMinutes(temp);
								testcase.setAttribute("time", String.valueOf(temp));
								Element failure = new Element("failure");

								String EscapedMessage = RemoveEscapeCharacters(tr.getThrowable().getMessage());

								failure.setAttribute("message", "Failed  " + EscapedMessage);
								failure.setAttribute("type", "testcase");
								testcase.addContent(failure);
								testsuite.addContent(testcase);

							}

							Set<ITestResult> TestResult3 = tc.getSkippedTests().getAllResults();

							for (ITestResult tr : TestResult3) {
								String methodName = tr.getName().toString().trim();
								String className = tr.getMethod().getTestClass().getName();
								System.out.println(methodName);
								Element testcase = new Element("testcase");
								testcase.setAttribute("classname", className);
								testcase.setAttribute("name", methodName.substring(3));
								long temp = tr.getEndMillis() - tr.getStartMillis();
								TimeUnit.MILLISECONDS.toMinutes(temp);
								testcase.setAttribute("time", String.valueOf(temp));
								Element failure = new Element("failure");
								String EscapedMessage = RemoveEscapeCharacters(tr.getThrowable().getMessage());
								failure.setAttribute("message", "Failed  " + EscapedMessage);
								failure.setAttribute("type", "testcase");
								testcase.addContent(failure);
								testsuite.addContent(testcase);

							}

						}
						testsuites.addContent(testsuite);

					}

					xmlResult = new File(Generic.getOutputPath() + File.separator + "TEST-" + Generic.CURRENTOS + "_"
							+ Generic.CURRENTBROWSER + ".xml");

					System.out.println("xmlResult= " + xmlResult.getAbsolutePath());
					try {
						XMLOutputter xmlOutput = new XMLOutputter();

						String xmlString = "";
						String responseData = "";

						System.out.println(xmlString);
						String output = xmlOutput.outputString(doc);
						// Pushing the XML file generated above to dashboard via
						// PushData class
						PushData h = new PushData();
						responseData = h.sendData(output);
						System.out.println(responseData);
						System.out.println("output=" + output);
					} catch (Exception e) {
						System.err.println("Error while sending data to dashboard:  " + e.getMessage());
					}

					// Pushing the Files to Server via pushFileToServer method
					// of Generic Class !!!!
					Generic g = new Generic();
					System.out.println("Output Path=" + Generic.getOutputPath());
					String XmlURL = g.pushFileToServer(Generic.getOutputPath() + File.separator + "Html.xml", "Xml");
					System.out.println("URL is =" + XmlURL);

					String TestNGURL = g.pushFileToServer(Generic.getOutputPath() + File.separator + "HTML_Automation"
							+ File.separator + "HTML_Certification.html", "Others");
					String ExecutionReportURL = g.pushFileToServer(
							Generic.getOutputPath() + File.separator + "ExecutionReport.html", "Others");

					System.out.println("TestNGURL is =" + TestNGURL);
					System.out.println("ExecutionReportXML is =" + ExecutionReportURL);

					// Pushing HTML_BITMAPS

					StringBuilder loglog;
					// Process all files in HTML_LOGS\Timestamp\actualImage
					// folder
					HTMLBitmaps = processPathsAndReturnInVectorForm(traverseFileSystemAndLookForFiles(new File(
							Generic.getOutputPath() + File.separator + "actualImage" + File.separator + "tc_images")));

					Enumeration<String> vEnum = HTMLBitmaps.elements();
					System.out.println("\\nElements in vector  HTMLBitmaps:");
					while (vEnum.hasMoreElements())
						System.out.println(vEnum.nextElement() + " ");
					System.out.println();

					if (HTMLBitmaps != null && HTMLBitmaps.size() > 0) {
						loglog = new StringBuilder("Pushing HTML_BITMAPS files: [");
						for (int i = 0; i < HTMLBitmaps.size(); i++) {
							loglog.append("+");
							String testidurl = g.pushFileToServer(HTMLBitmaps.elementAt(i).toString(),
									"FailureBitmaps");
							System.out.println("The path on Server is:  " + testidurl);
						}
						loglog.append("] Completed.");
						System.out.println("loglog:  " + loglog);
					}

					// Process all files in HTML_LOGS\Timestamp\Screenshot
					// folder
					Screenshot = processPathsAndReturnInVectorForm(traverseFileSystemAndLookForFiles(
							new File(Generic.getOutputPath() + File.separator + "Screenshot")));
					Enumeration<String> vEnum1 = Screenshot.elements();
					System.out.println("\\nElements in vector  Screenshot:");
					while (vEnum1.hasMoreElements())
						System.out.println(vEnum1.nextElement() + " ");
					System.out.println();

					loglog = new StringBuilder("Pushing HTML_LOGS files: [");
					for (int i = 0; i < Screenshot.size(); i++) {
						loglog.append("+");
						String ScreenshotUrl = g.pushFileToServer(Screenshot.elementAt(i).toString(), "FailureBitmaps");
						System.out.println("The path on Server is:  " + ScreenshotUrl);
					}
					loglog.append("] Completed.");
					// End of Pushing files
					// Writing the xml HTML_LOGS\Timestamp\ folder
					try {

						final FileOutputStream out = new FileOutputStream(xmlResult);
						final XMLOutputter outputter = new XMLOutputter(
								Format.getPrettyFormat().setOmitDeclaration(false));
						outputter.output(doc, out);
						out.close();
						SendEmail.send("");
					} catch (final java.io.IOException se) {
						se.printStackTrace();
					}
					// End of Writing XML
				} catch (Exception E) {
					System.err.println("Coulnot make XML!!!See the mail for more information!!");
					System.err.println(E.getMessage());
					SendEmail.send("NoXML");

				}
			} else {
				// If Flash Version is incorrect
				SendEmail.send("InstallationFailure");

			}

		}
	}

	// Utility method to handle escape characters from XML to be Pushed on
	// dashboard
	public String RemoveEscapeCharacters(String original) {
		String finalString = null;
		finalString = StringEscapeUtils.escapeXml(original);
		return finalString;

	}

	// Utility methods to find all the files to be pushed on the Server
	protected String traverseFileSystemAndLookForFiles(File path) {
		String allpaths = "";

		if (path.isFile()) {
			return path.getAbsolutePath() + "\n";
		} else { // traverse the directory
			try {
				File[] files = path.listFiles();
				for (int i = 0; i < files.length; i++) {
					allpaths += traverseFileSystemAndLookForFiles(files[i]);
				}
			} catch (NullPointerException npe) {
				// To avoid error log for screenshots here
				if (path.toString().indexOf("SCREENSHOTS") < 0)
					System.out.println("Could not find file " + path.toString() + ". " + npe.getMessage());
				return "";
			}
		}
		return allpaths;
	}

	protected Vector<String> processPathsAndReturnInVectorForm(String failedTestCasePaths) {
		int start = 0;
		int end = 0;
		String temp = failedTestCasePaths;
		Vector<String> vec = new Vector<String>();

		while (start < failedTestCasePaths.length()) {
			end = failedTestCasePaths.indexOf("\n", start);
			temp = failedTestCasePaths.substring(start, end);
			vec.add(new String(temp.toString()));
			start = end + 1;
		}
		return vec;
	}
}
