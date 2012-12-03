package bartender;

import java.awt.*;
import javax.swing.JButton;
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
	 * @var Product productGambled
	 */
	private Product productGambled;
	
	/**
	 * Constructor shows this frame.
	 *
	 * @param currentLang current language
	 */
	public GameJFrame(Language currentLang, Product productGambled)
	{
		this.currentLang = currentLang;
		this.productGambled = productGambled;
		
		initFrame();

		JLabel label = new JLabel(currentLang.getSentence("letsplayabout") + productGambled.getName() + ":");
		c.insets = new Insets(30, 10, 10, 10);
		c.gridx = 0;
		pane.add(label, c);
		
		JButton btn = new JButton();
		btn.setText(currentLang.getSentence("twist"));
		c.gridx = 1;
		c.gridy = 4;
		pane.add(btn, c);
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
