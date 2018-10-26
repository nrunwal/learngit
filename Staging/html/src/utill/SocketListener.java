package utill;

/*
 Taken From Tofu. This gets all the actual values of the parameters (Flash version ,OS, Debug etc)
 */
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utill.Generic;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class SocketListener extends Thread {
	private Socket socket;

	private String clientIP;

	public SocketListener(Socket sock, Generic g) {
		this.socket = sock;
	}

	@Override
	public void run() {
		super.run();

		clientIP = socket.getInetAddress().getHostAddress();
		System.out.println(clientIP.toString() + " connected");

		try {
			// set the socket read timeout to 15 seconds
			socket.setSoTimeout(200 * 1000);

			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			StringBuilder sb = new StringBuilder();
			byte[] buf = new byte[4096];
			try {
				int bytesRead = in.read(buf);
				while (bytesRead != -1) {
					System.out.println("read " + bytesRead + " bytes.");
					sb.append(new String(buf, 0, bytesRead));
					if (sb.indexOf("policy-file-request") != -1) {
						servePolicyFile(socket.getInputStream(), socket.getOutputStream());
						return;
					}
					bytesRead = in.read(buf);

					System.out.println(sb.toString());
					System.out.println("next read value read :->" + bytesRead + " bytes.");
				}

			} catch (SocketTimeoutException e) {
				System.out.println("Read timeout occured. This is OK.");
			}

			String receivedXml = sb.toString();

			System.out.println("This XML Came from SocketListener: " + receivedXml);

			System.out.println(receivedXml);

			SAXBuilder parser = new SAXBuilder();
			StringReader sr = new StringReader(receivedXml.trim());
			Document doc = parser.build(sr);
			// System.out.println(doc.getRootElement().getChildren());
			// System.out.println(doc.getRootElement().getChild("properties"));

			if (doc.getRootElement().getChild("properties") != null) {
				Element properties = doc.getRootElement().getChild("properties");
				List<Element> al2 = new ArrayList<Element>();
				List<?> l2 = properties.getChildren("property");
				for (int i = 0; i < l2.size(); i++)
					if (l2.get(i) instanceof Element)
						al2.add((Element) l2.get(i));

				for (Element object : al2) {
					if ("version".equalsIgnoreCase(object.getAttribute("name").getValue())) {
						String FlashVersion = object.getAttribute("value").getValue();
						// String actualFlashVersion[] =
						// object.getAttribute("value").getValue().split("
						// ")[1].split(","); //20,0,0,123
						String actualFlashVersion[] = object.getAttribute("value").getValue().split(" ")[1].split(",");
						System.out.println("Flash Version ===" + Arrays.deepToString(actualFlashVersion));
						System.out.println("Flash Version ===" + FlashVersion);
						Generic.setFlashVersion(FlashVersion);
						// Generic.setFlashbranch(FlashVersion);
					} else if ("debugger".equalsIgnoreCase(object.getAttribute("name").getValue()))

					{
						boolean isDebugger = object.getAttribute("value").getValue().equalsIgnoreCase("true");
						Generic.setIsdebug(isDebugger);
						System.out.println("Debugger==" + isDebugger);
					}

					else if ("os".equalsIgnoreCase(object.getAttribute("name").getValue())) {
						String OSVersion = object.getAttribute("value").getValue();
						System.out.println("OS Version: " + OSVersion);
						Generic.setOsVersion(OSVersion);

					}

					else if ("playerType".equalsIgnoreCase(object.getAttribute("name").getValue())) {
						String playerType = object.getAttribute("value").getValue();
						System.out.println("playerType " + playerType);
						Generic.setPlayerType(playerType);
					}

					else if ("cpuArchitecture".equalsIgnoreCase(object.getAttribute("name").getValue())) {
						String CpuArchitecture = object.getAttribute("value").getValue();
						System.out.println("CpuArchitecture " + CpuArchitecture);
						// Generic.setCpuArchitecture(CpuArchitecture);
					}
				}
				Generic.setBaselinePath();
				Generic.setTofuRunID();
			}

			/*
			 * if (receivedXml.indexOf("<policy-file-request") != -1) // flash
			 * player policy file request {
			 * 
			 * } else { System.out.println("PLease run again");
			 * XMLParser.doActionsByXml(receivedXml); }
			 * HoneyComb.updateMachineTimeStamp(new Date());
			 * //HoneyComb.getInstance().refreshMachineStatus();
			 * 
			 * 
			 */
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("Looks like we got truncated XML from the ATS.");
			/* recoverAndMoveToNextUrl(); */
		}
		/*
		 * catch (JDOMParseException e) { System.out.println(e);
		 * System.out.println("Looks like we got truncated XML from the ATS.");
		 * recoverAndMoveToNextUrl(); }
		 */
		catch (IOException e) {
			System.out.println(e);
		}
		/*
		 * catch (JDOMException e) { System.out.println(e); }
		 */catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e);
		 } finally {
			 this.closeSocket();
		 }
	}

	private void servePolicyFile(InputStream instr, OutputStream outstr) {
		BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(outstr));
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"?>\n");
		sb.append(
				"<!DOCTYPE cross-domain-policy SYSTEM \"http://www.adobe.com/xml/dtds/cross-domain-policy.dtd\">\n\n");
		sb.append("<cross-domain-policy>\n");
		sb.append("  <site-control permitted-cross-domain-policies=\"all\" />\n");
		sb.append("  <allow-access-from domain=\"*\" to-ports=\"25001,25002\" secure=\"false\" />\n");
		sb.append("  <allow-http-request-headers-from domain=\"*\" headers=\"*\" secure=\"false\" />\n");
		sb.append("</cross-domain-policy>\n\u0000");
		try {
			System.out.println("Serving policy file: " + sb.toString());
			bos.write(sb.toString());
			bos.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void closeSocket() {
		try {
			System.out.println("Close socket");
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
