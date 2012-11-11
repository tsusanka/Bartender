package bartender;

import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Class representing particular language.
 *
 * All sentences in the application are taken from this class, which reads in
 * specific file, based on the language, selected by customer.
 *
 * @author Tomas Susanka
 */
public final class Language
{

	/**
	 * @var String Language code representing language (en, fr..)
	 */
	String currentLangCode;
	/**
	 * @var HashMap loaded current language in HashMap.
	 */
	HashMap<String, String> currentLang;

	/**
	 * Language constructor loads demanded language.
	 *
	 * @param languageCode
	 */
	public Language(String languageCode)
	{
		this.currentLangCode = languageCode;
		loadLanguage();
	}

	/**
	 * Returns apropriate sentence.
	 *
	 * @param what
	 */
	public String getSentence(String what)
	{
		if (!currentLang.containsKey(what)) {
			return null;
		}
		return currentLang.get(what);
	}

	/**
	 * Loads language from a file
	 *
	 * @return boolean
	 */
	public boolean loadLanguage()
	{
		currentLang = new HashMap<String, String>();
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(currentLangCode + ".xml"));

			// normalize text representation
			doc.getDocumentElement().normalize();
			NodeList sentences = doc.getElementsByTagName("sentence");

			if (sentences == null || sentences.getLength() == 0) {
				return false;
			}
			for (int i = 0; i < sentences.getLength(); i++) {
				Element s = (Element) sentences.item(i);
				if (!"sentence".equals(s.getNodeName())) {
					return false;
				}
				currentLang.put(s.getAttribute("what"), s.getTextContent());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
}
