package bartender;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class representing particular language.
 *
 * All sentences in the application are taken from this class, which reads in
 * specific file, based on the language
 * selected by customer.
 *
 * @author Tomas Susanka
 */
public class Language
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
	 * Loads language from a file;
	 * @return boolean 
	 */
	private boolean loadLanguage()
	{
		//TODO: loading language from a file
		currentLang = new HashMap<String, String>();
		currentLang.put("choose", "Please choose a drink:");
		currentLang.put("pay", "Pay");
		return true;
	}

	/**
	 * Returns apropriate sentence.
	 *
	 * @param what
	 */
	public String getSentence(String what)
	{
		if (!currentLang.containsKey(what))
			return null;
		return currentLang.get(what);
	}
}
