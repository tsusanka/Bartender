package bartender;

import chrriis.dj.nativeswing.NativeSwing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Main window containing all buttons, labels etc.
 *
 * This is the window, that is opened at the very beggining by Bartender default main method. It contains all the buttons, name and prices of products and many other components.
 * 
 * @author Tomas Susanka
 */
public final class MainJFrame extends OwnJFrame
{

	/**
	 * @var int waiting time for payment (showing dialog) in miliseconds
	 */
	private static final int PAYMENT_WAITING_TIME = 2000;
	/**
	 * @var String[] active languages that can be selected
	 */
	private static final String[] activeLanguages = {"en", "cs", "es", "fr", "lv", "dk"};
	/**
	 * @var JButton save button
	 */
	private JButton payButton;
	/**
	 * @var ProductsAccess products offered
	 */
	private Products products;

	/**
	 * Constructor initialazing components.
	 */
	public MainJFrame(Language language)
	{
		super(language);
		
		initComponents();
	}

	@Override
	protected void initComponents()
	{
		NativeSwing.initialize();

		initTop();
		initCenter();
		initBottom();
		initAdmin();
	}

	/**
	 * Inicialization of top headline.
	 */
	public void initTop()
	{
		JLabel productsLabel = new JLabel("<html><b><u>"
				+ currentLang.getSentence("choose") + "</u></b></html>");

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.insets = new Insets(10, 10, 10, 10);
		pane.add(productsLabel, c);
	}

	/**
	 * Inicialization of bottom screen.
	 */
	private void initBottom()
	{
		JPanel pan = new JPanel(new BorderLayout());

		ImageIcon coinsIcon = new ImageIcon(getClass().getResource("imgs/coins.png"));
		payButton = new JButton(currentLang.getSentence("pay"), coinsIcon);
		payButton.setPreferredSize(new Dimension(150, 50));
		payButton.setBorder(new BasicBorders.ButtonBorder(Color.lightGray, Color.lightGray, Color.lightGray, Color.lightGray));
		payButton.addActionListener(getPayActionListener());

		c.gridx = 9;
		c.gridy = 5;
		c.gridwidth = 3;
		c.insets = new Insets(10, 70, 10, 10);

		pane.add(payButton, c);
	}

	/**
	 * Inicialization of center screen.
	 */
	private void initCenter()
	{
		initProductsBox();
		initLanguages();
	}

	/**
	 * Creates language flags.
	 */
	private void initLanguages()
	{
		int y = 1;
		int x = 9;
		for (final String lang : activeLanguages) {
			ImageIcon icon = new ImageIcon(getClass().getResource("imgs/" + lang + ".jpg"));
			JButton btn = new JButton(icon);
			btn.setPreferredSize(new Dimension(50, 26));
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
			btn.addActionListener(new ActionListener() //adding action listener to show paying dialog
			{

				@Override
				public void actionPerformed(ActionEvent ae)
				{
					MainJFrame newFrame = new MainJFrame(new Language(lang));
					newFrame.showFrame();
					hideFrame();
				}
			});

			if (y == 4) {
				y = 1;
				x += 2;
			}
			c.gridx = x;
			c.gridy = y++;
			c.gridwidth = 3;

			pane.add(btn, c);
		}

	}

	/**
	 * Initialize product labels.
	 */
	private void initProductsBox()
	{
		products = ProductsAccess.read();
		int i = 1;
		for (Product product : products.getAll()) {
			JLabel label = new JLabel(product.getName() + ":   " + product.getPrice());
			c.gridx = 0;
			c.gridy = i++;
			c.insets = new Insets(10, 10, 10, 10);
			pane.add(label, c);
			c.gridx = 4;
			c.insets = new Insets(0, 0, 0, 0);
			SpinnerModel modeltau = new SpinnerNumberModel(0, 0, 99, 1);
			JSpinner spinner = new JSpinner(modeltau);
			spinner.setPreferredSize(new Dimension(40, 40));
			pane.add(spinner, c);

			c.gridx = 8;
			c.insets = new Insets(10, 10, 10, 10);
			JButton gameButton = getGameButton(product);
			pane.add(gameButton, c);
			product.setSpinner(spinner);
		}
	}

	/**
	 * Returns game button with icon and associated product.
	 *
	 * @param product
	 * @return
	 */
	private JButton getGameButton(Product product)
	{
		ImageIcon buttonIcon = new ImageIcon(getClass().getResource("imgs/redbutton.png"));
		JButton btn = new JButton("", buttonIcon);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);

		btn.addActionListener(getPayActionListenerForGame(product));
		btn.setPreferredSize(new Dimension(30, 30));

		return btn;
	}

	/**
	 * Returns action listener for game buttons.
	 *
	 * @param Product product to be gambled on
	 * @return ActionListener to be attached
	 */
	private ActionListener getPayActionListenerForGame(Product product)
	{
		return getPayActionListener(product);
	}

	/**
	 * Returns action listener for pay button.
	 *
	 * @return ActionListener to be attached
	 */
	private ActionListener getPayActionListener()
	{
		return getPayActionListener(null);
	}

	/**
	 * Returns action listener to assign to specific button.
	 *
	 * @param game if true, the game is paid, that means no setting amount
	 * required
	 * @return ActionListener to be attached
	 */
	private ActionListener getPayActionListener(final Product gameProduct)
	{
		return new ActionListener() //adding action listener to show paying dialog
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
				if (gameProduct == null) //meaning we are not playing game
				{
					products.setAmountsOrdered();
				}
				JOptionPane optionPane = new JOptionPane(currentLang.getSentence("waitingForPayment"));
				final JDialog dialog = optionPane.createDialog(pane, currentLang.getSentence("waitingForPayment"));
				Timer timer = new Timer(PAYMENT_WAITING_TIME, new ActionListener() //waiting three seconds for finishin payment
				{

					@Override
					public void actionPerformed(ActionEvent ae)
					{
						dialog.setVisible(false); //hiding the dialog after three seconds pass
					}
				});
				timer.setRepeats(false);
				timer.start();
				dialog.setVisible(true);

				// after three seconds pass show next dialog
				if (gameProduct == null) {
					DoneJFrame pf = new DoneJFrame(currentLang, products);
					hideFrame();
					pf.setVisible(true);
				} else {
					GameJFrame pf = new GameJFrame(currentLang, gameProduct);
					hideFrame();
					pf.setVisible(true);
				}
			}
		};
	}

	/**
	 * Initializes admin interface for editing products names and prices.
	 */
	public void initAdmin()
	{
		ActionListener actionListener = new ActionListener()
		{

			public void actionPerformed(ActionEvent actionEvent)
			{
				AdminJFrame adminFrame = new AdminJFrame(products, currentLang);
				adminFrame.setVisible(true);
				hideFrame();
			}
		};

		KeyStroke keystroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false);
		mainPanel.registerKeyboardAction(actionListener, keystroke, JComponent.WHEN_FOCUSED);
		JButton btn = new JButton();
		btn.registerKeyboardAction(null, null, ICONIFIED);
	}
}
