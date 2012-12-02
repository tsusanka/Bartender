package bartender;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tomas Susanka
 */
public class GameJFrame extends JFrame
{

	/**
	 * @var Language current language for accesing words
	 */
	private Language currentLang;
	/**
	 * @var GridBagContraints c
	 */
	private GridBagConstraints c;
	/**
	 * @var Container pane
	 */
	private Container pane;

	/**
	 * Constructor shows this frame.
	 *
	 * @param currentLang current language
	 */
	public GameJFrame(Language currentLang)
	{
		this.currentLang = currentLang;
		
		initFrame();

		JLabel label = new JLabel(currentLang.getSentence("letsplay"));
		c.insets = new Insets(30, 10, 10, 10);
		pane.add(label, c);

	}

	/**
	 * Sets the frame window, height, title etc.
	 */
	private void initFrame()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		pane = mainPanel;
		add(mainPanel, BorderLayout.NORTH);
		
		this.c = new GridBagConstraints();
		setSize(Bartender.WINDOW_W, Bartender.WINDOW_H);
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
