
package bartender;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 *  @author Tomas Susanka
 */
public class DoneJFrame extends JFrame
{

	/**
	 * @var Language  current language for accesing words
	 */
	private Language currentLang;
	
	/**
	 * Constructor shows this frame.
	 * 
	 * @param currentLang current language
	 */
	public DoneJFrame(Language currentLang)
	{
		this.currentLang = currentLang;
		JLabel label = new JLabel(currentLang.getSentence("done"));
		add(label);
		setSize(MainJFrame.WINDOW_W, MainJFrame.WINDOW_H);
		setTitle("Automatic Bartender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Shows the frame.
	 * 
	 * Shortcut for setVisible(true).
	 */
	public void showFrame() 
	{
		setVisible(true);
	}
	
	/**
	 * Hides the frame.
	 * 
	 * Shortcut for setVisible(false).
	 */
	public void hideFrame() 
	{
		setVisible(false);
	}
}
