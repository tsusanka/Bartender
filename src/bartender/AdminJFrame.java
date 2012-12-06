package bartender;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Tomas Susanka
 */
public final class AdminJFrame extends OwnJFrame
{

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
		super(new Language(Bartender.DEFAULT_LANG));
		this.products = products;

		initComponents();
	}

	@Override
	protected void initComponents()
	{
		mainLabel = new JLabel("<html><b><u>" + currentLang.getSentence("passwd") + "</u></b></html>");

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
					JOptionPane optionPane = new JOptionPane(currentLang.getSentence("wrongPasswd"));
					final JDialog dialog = optionPane.createDialog(pane, currentLang.getSentence("wrongPasswd"));
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
		savebtn.setText(currentLang.getSentence("save"));
		c.gridy = 180;
		pane.add(savebtn, c);
	}
}
