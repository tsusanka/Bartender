/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bartender;

/**
 * Main class creating instances
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
	public final static int WINDOW_H = 350;
	/**
	 * @var String default language
	 */
	public static final String DEFAULT_LANG = "en";

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