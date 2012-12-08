package bartender;

/**
 * Main class creating instances.
 * 
 * This is the main class with main(String[] args) function. It creates the main window and shows it.
 *
 * @author Tomas Susanka
 */
public class Bartender
{

	/**
	 * @var int Window width
	 */
	public final static int WINDOW_W = 550;
	/**
	 * @var int Window height
	 */
	public final static int WINDOW_H = 330;
	/**
	 * @var String default language
	 */
	public static final String DEFAULT_LANG = "en";
	/**
	 * @var String title of all program windows
	 */
	public static final String WINDOW_TITLE = "Automatic Bartender";

	/**
	 * Main static function.
	 */
	public static void main(String[] args)
	{
		System.out.println("Program started.");
		Language lang = new Language(DEFAULT_LANG);
		MainJFrame window = new MainJFrame(lang);
		window.showFrame();
	}
	
}