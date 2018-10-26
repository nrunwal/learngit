package utill;
/*@shubsing
 * Creates Html.xml Which is to used by the Image Validation Tool to Update baselines
 * Taken from Tofu
 */

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.tree.DefaultAttribute;

public class HtmlWriter extends org.dom4j.io.XMLWriter {

	Document xml;

	static OutputFormat format = OutputFormat.createPrettyPrint();
	Element rootElement;

	public HtmlWriter(FileOutputStream fos, String rootName) throws Exception {
		super(fos, format);

		xml = DocumentFactory.getInstance().createDocument();
		rootElement = xml.addElement(rootName);
		xml.setRootElement(rootElement);

	}

	public void addElement(String name, String actualPath, String baselinePath, String actualSrcPath,
			String p4DestinationPath, String fpstorageDestinationPath, String addOrEdit, String ats) throws Exception {
		Element elem = rootElement.addElement("bline");
		elem.add(new DefaultAttribute("name", name));
		elem.add(new DefaultAttribute("actual", actualPath));
		elem.add(new DefaultAttribute("baseline", baselinePath));
		elem.add(new DefaultAttribute("actualSrcPath", actualSrcPath));
		elem.add(new DefaultAttribute("p4DestinationPath", p4DestinationPath));
		elem.add(new DefaultAttribute("fpstorageDestinationPath", fpstorageDestinationPath));
		elem.add(new DefaultAttribute("addOrEdit", addOrEdit));
		elem.add(new DefaultAttribute("uploadToPerforce", "n"));
		elem.add(new DefaultAttribute("ats", ats));

	}

	public void writeXML() throws Exception {
		this.write(xml);
		this.flush();

	}

}
