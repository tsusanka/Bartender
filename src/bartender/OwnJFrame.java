package bartender;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The parent class for all frames.
 * 
 * Sets the width and height of a window, sets a title and creates instances further used in the descendants.
 * 
 * @author Tomas Susanka
 */
public abstract class OwnJFrame extends JFrame
{

	/**
	 * @var Language language for accesing words
	 */
	protected Language currentLang;
	/**
	 * @var Container pane
	 */
	protected Container pane;
	/**
	 * @var GridBagContraints c
	 */
	protected GridBagConstraints c;
	/**
	 * @var JPanel mainPanel
	 */
	protected JPanel mainPanel;

	/**
	 * Constructor of the main Frame.
	 *
	 * @param currentLang language that will be in effect in this frame
	 */
	public OwnJFrame(Language currentLang)
	{
		this.currentLang = currentLang;
		setSize(Bartender.WINDOW_W, Bartender.WINDOW_H);
		setTitle(Bartender.WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initMainPanel();
	}

	/**
	 * Inicialization of top screen.
	 */
	private void initMainPanel()
	{
		mainPanel = new JPanel(new GridBagLayout());
		pane = mainPanel;
		add(mainPanel, BorderLayout.NORTH);
		c = new GridBagConstraints();
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
	
	/**
	 * Inicialization of components on the frame.
	 * 
	 * Initiliazes all components on specific frame.
	 */
	protected abstract void initComponents();
}
