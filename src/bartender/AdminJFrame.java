/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bartender;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tomáš Sušánka
 */
public class AdminJFrame extends JFrame
{
	/**
	 * @var Container pane
	 */
	private Container pane;
	/**
	 * @var GridBagContraints c
	 */
	private GridBagConstraints c;
	/**
	 * @var Language in administration the default language is used
	 */
	private Language lang;
	
	/**
	 * Creates instance of admin frame.
	 */
	public AdminJFrame()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		pane = mainPanel;
		add(mainPanel, BorderLayout.NORTH);
		c = new GridBagConstraints();
		
		lang = new Language(Bartender.DEFAULT_LANG);

		setSize(Bartender.WINDOW_W, Bartender.WINDOW_H);
		setTitle("Automatic Bartender - admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	/**
	 * Initializes all components.
	 */
	public void initComponents()
	{
		JLabel productsLabel = new JLabel("<html><b><u>" + lang.getSentence("admin") + "</u></b></html>");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(10, 10, 10, 10);
		pane.add(productsLabel, c);
	
		initComponents();
	}
}
