package utill;

/*
 @shubsing
 This Class is used to Construct and Send an Email in proper Format based on various parameters.(Null,DriverFailure,Flash version incorrect ) 
 */
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

	protected static String body = "";
	protected static String Subject = "";
	protected static String endl = "<br>\n";

	public static void send(String param) {
		// Recipient's email ID needs to be mentioned.
		String to = "FlashRuntimeDesktopQENOIDA@adobe.com";

		// Sender's email ID needs to be mentioned
		String from = "frauto@adobe.com";

		// Assuming you are sending email from localhost
		String host = "namail.corp.adobe.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field

			Subject = makeSubject();
			message.setSubject(Subject);

			// Now set the actual message
			body = makeBody(param);
			// message.setText(body);

			message.setContent(body, "text/html; charset=utf-8");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	protected static String makeSubject() {

		String sbj = "";
		try {
			sbj += "[FRAuto]HTMLRun" + "|";

			if (Generic.gettotalFail() > 0 || Generic.gettotalSkipped() > 0) {
				sbj += "Fail|Test";
			} else {
				if (Generic.gettotalPass() > 0) {
					sbj += "Pass|Test";
				} else {
					sbj += "  Installation Failure |";
				}
			}

			if (Generic.getIsdebug()) {
				sbj += "Debug ";
			} else {
				sbj += "Release ";
			}

			if (Generic.getPlayerType().equalsIgnoreCase("activex")) {
				sbj += "activex";
			} else if (Generic.getPlayerType().equalsIgnoreCase("plugin")) {
				switch (Generic.currentBR()) {
				case "chrome":
					sbj += "google_pepper_plugin";
					break;
				case "firefox":
				case "safari":
					sbj += "adobe_plugin";
				}
			} else {
				sbj += "CouldNotDetermine";
			}
			sbj += " " + Generic.getBuildName() + " |";
			if (Generic.CURRENTOS.equals("mac")) {
				sbj += "Mac OS X";
				// PropertyTag.put("osver",
				// Generic.getOsVersion().substring((Generic.getOsVersion().indexOf("Mac
				// OS ")+7)));
			} else {
				sbj += Generic.getOsVersion();
				// PropertyTag.put("osver", System.getProperty("os.version"));
			}
			sbj += " -" + Generic.getMachineName();
			return sbj;
		} catch (Exception e) {
			java.net.InetAddress localMachine;
			try {
				localMachine = java.net.InetAddress.getLocalHost();
				System.out.println("Hostname of local machine: " + localMachine.getHostName());
				sbj += "[FRAuto]HTMLRun" + "|" + "Driver Initialisaton Failure" + " | " + Generic.CURRENTBROWSER + " | "
						+ localMachine.getHostName();
				return sbj;

			} catch (UnknownHostException e1) {

				e.printStackTrace();
				System.exit(0);
				return " ";

			}

		}
	}

	protected static String makeBody(String param) {

		// Header Part
		try {
			if (param.equalsIgnoreCase("DriverFailure")) {
				body = endl;
				body += "<strong>Flash Player Automated HTML Test</strong>";
				body += endl;
				body += "OS " + System.getProperty("os.name") + endl;
				body += "OS Version: " + System.getProperty("os.version") + endl;
				body += "Browser: " + Generic.currentBR() + endl;
				// body+="TofuRunID: "+Generic.getTofuRunID()+endl;
				body += "<strong>Test suite:</strong>" + "HTML_AUTOMATION" + endl;
				body += "<strong>Could Not Launch Browser due to Selenium Driver Issues.Please Check!!!!!</strong>";

			} else {

				body = endl;
				body += "<strong>Flash Player Automated HTML Test</strong>";
				body += endl;
				if (Generic.CURRENTOS.equals("mac")) {
					body += "OS:Mac OS X" + endl;

					body += "OS Version: "
							+ Generic.getOsVersion().substring((Generic.getOsVersion().indexOf("Mac OS ") + 7)) + endl;
				} else {
					body += "OS:  " + Generic.getOsVersion() + endl;
					body += "OS Version: " + System.getProperty("os.version") + endl;
				}
				body += "OS Arch:  " + Generic.getCpuArchitecture() + endl;
				body += "playerType: " + Generic.getPlayerType() + endl;
				body += "TestMachine: " + Generic.getMachineName();
				try {
					body += "(" + Inet4Address.getLocalHost().getHostAddress() + ")";
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				body += endl;

				body += "Browser: " + Generic.currentBR() + "_" + Generic.getBrowswerBits() + endl;
				body += "BrowserVersion :" + Generic.getbrowserVersion() + endl;
				long time1 = htmlTestCase.Base.executionTime;
				TimeUnit.MILLISECONDS.toMinutes(time1);
				System.out.println("Time : " + time1);
				String time = String.valueOf(time1);
				body += "Total Elapsed Time:  " + time + endl;
				body += "TofuRunID: " + Generic.getTofuRunID() + endl;

				body += endl;
				body += endl;

				// Body Details

				if (param.equalsIgnoreCase("InstallationFailure")) {
					body += "<strong>Could not Install build </strong>" + Generic.getBuildName()
							+ "<strong>. Please install manually... </strong>";
				} else {

					if (param.equalsIgnoreCase("nNoXML")) {
						body += "<strong>Could not send XML. See the results here. </strong>" + Generic.gettotalPass()
								+ endl;
						body += endl;
					}
					body += "<strong>Total testcases passed: </strong>" + Generic.gettotalPass() + endl;
					body += "<strong>Total testcases with errors: </strong>" + Generic.gettotalFail() + endl;
					body += "<strong> Number of crashes or timeouts detected: </strong>" + Generic.gettotalSkipped()
							+ endl;

					body += "<strong>Test suite:</strong>" + "HTML_AUTOMATION" + endl;
					body += "Player Version: " + Generic.getFlashVersion() + endl;
					if (Generic.gettotalFail() > 0 || Generic.gettotalSkipped() > 0) {
						body += "<strong>Failed </strong>";
					} else {
						body += "<strong>Passed </strong>";

					}
					body += "with " + Generic.gettotalPass() + " correct testcases,and " + Generic.gettotalFail()
							+ " failed testcases." + endl;
					body += "Click ";
					String URL = "http://fpqa.macromedia.com/Tofu/HTML_logs/" + Generic.getBuildName() + "/"
							+ Generic.getTofuRunID() + "/" + "HTML_Certification.html";
					body += "<a href=\"" + URL + "\">";
					body += "here ";
					body += "</a>";
					body += "to see the HTML report for details of all testcases." + endl;

					body += "Click ";
					String URL1 = "http://fpqa.macromedia.com/Tofu/HTML_logs/" + Generic.getBuildName() + "/"
							+ Generic.getTofuRunID() + "/" + "ExecutionReport.html";
					body += "<a href=\"" + URL1 + "\">";
					body += "here ";
					body += "</a>";
					body += "to see the Logger report for details of all testcases." + endl;

					body += "Click ";
					String URL3 = "http://ats.macromedia.com/Players/Projects/ImageValidationTool/bin-release/main.html?ulluXML=http://fpqa.macromedia.com/Ullu/NeedsHTMLValidation/"
							+ Generic.getTofuRunID() + "/HTML_LOGS/Html.xml" + "&ATS=HTML";
					body += "<a href=\"" + URL3 + "\">";
					body += "here";
					body += "</a>";
					body += "to see failed bitmaps. " + endl;
				}

				body += endl;
				body += endl;
				body += endl;
			}

			// Server Details:

			InetAddress address = null;

			boolean isUSserver = false;
			String serverIPAddress = "";
			String serverHostname = "";
			String serverGeoLocation = "";
			final String ATS_SERVER_URL = "ats.macromedia.com";

			try {
				address = InetAddress.getByName(ATS_SERVER_URL);
				if (address != null) {
					serverIPAddress = address.getHostAddress();

					if (serverIPAddress != "") {
						InetAddress host = InetAddress.getByName(serverIPAddress);
						// System.getenv().put(ATS_SERVER_GEO_LOCATION_ENV_VAR,
						// serverName);
						serverHostname = host.getHostName();
						if (serverHostname != "" && serverHostname.startsWith("sj")) {
							isUSserver = true;
						}

					} else {
						System.out.println("Unable to get IP address to host name.");
					}

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

			if (isUSserver) {
				serverGeoLocation = "US";
			} else {
				serverGeoLocation = "NOIDA";

			}

			body += "<strong>ATS Server details : </strong>" + endl;
			body += "Running from \"" + serverGeoLocation + " Server\"" + endl;
			body += "Server IP address - " + serverIPAddress + endl;
			body += "Server Hostname " + serverHostname + endl;

			body += endl;
			body += endl;
			body += endl;
			// Body Footer!
			body += "About the HTML Autorun Process: " + endl;
			body += "https://wiki.corp.adobe.com/display/flashruntime/HTML+AUTOMATION";
			body += endl;
			body += "Questions or problems: ";
			body += "<a href=\"mailto:" + "shubsing@adobe.com" + "\">Email</a>" + endl;

		} catch (Exception e) {
			System.out.println("Error in creating body!!!!");
		}

		return body;

	}

}