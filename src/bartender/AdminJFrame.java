/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bartender;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
	 * @var JLabel main label of this frame.
	 */
	private JLabel mainLabel;
	
	/**
	 * @var Products Names etc of products.
	 */
	private Products products;
	
	/**
	 * Creates instance of admin frame.
	 */
	public AdminJFrame(Products products)
	{
		this.products = products;
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
		mainLabel = new JLabel("<html><b><u>" + lang.getSentence("passwd") + "</u></b></html>");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(10, 10, 10, 10);
		pane.add(mainLabel, c);
		
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
					mainLabel.setText("Please edit the fields and press the save button.");
					passwdField.setVisible(false);
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
		final ArrayList<Product> p = products.getAll();
		final ArrayList<JTextField> fields = new ArrayList<JTextField>();
		for (int i = 0; i < 5; i++) {
			c.gridy = 30 * (i + 1);
			JTextField field = new JTextField();
			fields.add(field);
			field.setBounds(20, 20, 20, 20);
			field.setPreferredSize(new Dimension(400, 20));
			field.setText(p.get(i).getName());
			pane.add(field, c);
		}
			
		JButton savebtn = new JButton();
		savebtn.addActionListener(new ActionListener() //adding action listener to show paying dialog
			{
				@Override
				public void actionPerformed(ActionEvent ae)
				{
					for (int i = 0; i < 5; i++) {
						p.get(i).setName(fields.get(i).getText());
					}
					ProductsAccess.write(new Products(p));
					setVisible(false);
					MainJFrame dummy = new MainJFrame(new Language("en"));
					dummy.showFrame();
				}
			});
		
		savebtn.setBounds(80, 20, 20, 20);
		savebtn.setText(lang.getSentence("save"));
		c.gridy = 180;
		pane.add(savebtn, c);
	}
	
}
