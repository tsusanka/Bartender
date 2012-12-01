/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bartender;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.*;

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
	 * @var String default password
	 */
	private final char[] DEFAULT_PASSWD = {'h', 'o', 'r', 's', 'e', 'n', 's'};
	
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
		
		initComponents();
	}
	
	/**
	 * Initializes all components.
	 */
	private void initComponents()
	{
		JLabel label = new JLabel("<html><b><u>" + lang.getSentence("passwd") + "</u></b></html>");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(10, 10, 10, 10);
		pane.add(label, c);
		
		initPasswordCheck();
	}
	
	/**
	 * Creates labels and inputs. Manages password check.
	 */
	private void initPasswordCheck() 
	{
		final JPasswordField passwdField = new JPasswordField();
		c.gridy = 30;
		passwdField.setBounds(20, 20, 20, 20);
		passwdField.setPreferredSize(new Dimension(400, 20));
		
		passwdField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				System.out.println(passwdField.getPassword());
				if (Arrays.equals(passwdField.getPassword(), DEFAULT_PASSWD)) {
					initProductChange();
				} else {
					JOptionPane optionPane = new JOptionPane(lang.getSentence("wrongPasswd"));
					final JDialog dialog = optionPane.createDialog(pane, lang.getSentence("wrongPasswd"));
					dialog.setVisible(true);
				}
					
			}
		});
		
		pane.add(passwdField, c);
	}
	
	/**
	 * Creates inputs for changing the names of products
	 */
	private void initProductChange() 
	{
		
		//TODO
	}
	
}
