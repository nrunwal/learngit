package utill;

/*@shubsing
 * Reading of the Correct Xpath from the XML file
 * @BeforeTest annotation contain call to this class
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.testng.Assert;

public class DataHandler {

	public static Map<String, String> collection;
	public static Map<String, String> collectionIMG;
	public static ArrayList<String> Type;
	public static ArrayList<String> Name;
	private static ArrayList<String> Value;

	// Handling of the testWEor.xml to read Proper Xpaths Corresponding to
	// OS-Browser Combinations.

	public static Map<String, String> elementHandler(String ID) {

		try {

			String OS = Generic.currentOS();
			String browser = Generic.currentBR();

			Name = new ArrayList<String>();
			Value = new ArrayList<String>();
			Type = new ArrayList<String>();
			collection = new HashMap<String, String>();

			File inputFile = new File("Assets/src/xml/testWEor.xml").getAbsoluteFile();

			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);

			System.out.println("Root element :" + document.getRootElement().getName());

			Element classElement = document.getRootElement();

			List<Element> superList = classElement.getChildren("testCase");
			List<Element> testList;

			for (int temp = 0; temp < superList.size(); temp++) {
				Element superElement = superList.get(temp);
				Element browsertag = null, OStag = null;
				String attribute = superElement.getAttribute("ID").getValue();

				if (ID.equalsIgnoreCase(attribute)) {
					System.out.println("ID : " + attribute);

					OStag = superElement.getChild(OS);
					if (OStag != null) {
						browsertag = OStag.getChild(browser);
						if (browsertag != null) {
							testList = browsertag.getChildren("test");
							System.out.println("browsertag!=null");
						} else {
							testList = OStag.getChildren("test");
							System.out.println("From OS tag");
						}

					} else {
						testList = superElement.getChildren("test");
						System.out.println("generic");
					}

					for (int count = 0; count < testList.size(); count++) {
						Element testElement = testList.get(count);
						String key = testElement.getAttribute("name").getValue();
						String val = testElement.getAttribute("value").getValue();
						String type = testElement.getAttribute("type").getValue();
						System.out.print("Key" + key + "   " + Value + "  " + type);
						Name.add(count, key);
						Value.add(count, val);
						Type.add(count, type);
						collection.put(key, val);
					}
				} else if (temp == superList.size()) {
					Assert.assertTrue(false, ID + " is not exist in WebElement OR");
				}
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return collection;
	}

	// End
}
