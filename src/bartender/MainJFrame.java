package bartender;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Main window containg all buttons, labels etc.
 *
 * @author Tomas Susanka
 */
public class MainJFrame extends JFrame
{

	/**
	 * @var int waiting time for payment (showing dialog) in miliseconds
	 */
	private static final int PAYMENT_WAITING_TIME = 2000; 
	/**
	 * @var String[] active languages that can be selected
	 */
	private static final String[] activeLanguages = {"en", "cs", "es"};
	/**
	 * @var int Window width
	 */
	public final static int WINDOW_W = 500;
	/**
	 * @var int Window width
	 */
	public final static int WINDOW_H = 300;
	/**
	 * @var JButton save button
	 */
	private JButton payButton;
	/**
	 * @var Language language for accesing words
	 */
	private Language currentLang;
	/**
	 * @var ProductsAccess products offered
	 */
	private Products products;
	/**
	 * @var Container pane
	 */
	private Container pane;
	/**
	 * @var GridBagContraints c
	 */
	private GridBagConstraints c;

	/**
	 * Constructor initialazing components.
	 */
	public MainJFrame(Language language)
	{
		currentLang = language;
		initComponents();
	}

	/**
	 * Inicialization of top screen.
	 */
	private void initMainPanel()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		pane = mainPanel;
		add(mainPanel, BorderLayout.NORTH);
		c = new GridBagConstraints();
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
		payButton.addActionListener(new ActionListener() //adding action listener to show paying dialog
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
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
				DoneJFrame pf = new DoneJFrame(currentLang);
				hideFrame();
				pf.showFrame();
			}
		});

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
		int i = 1;
		for (String lang : activeLanguages) {
			ImageIcon icon = new ImageIcon(getClass().getResource("imgs/" + lang + ".jpg"));
			JButton btn = new JButton("", icon);
			btn.setPreferredSize(new Dimension(60, 26));
			btn.setBorder(BorderFactory.createEmptyBorder());
			c.gridx = 9;
			c.gridy = i++;
			c.gridwidth = 3;
			c.insets = new Insets(10, 10, 10, 10);
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
			JLabel label = new JLabel(product.getName());
			c.gridx = 0;
			c.gridy = i++;
			c.insets = new Insets(10, 10, 10, 10);
			pane.add(label, c);
			c.gridx = 5;
			c.insets = new Insets(0, 0, 0, 0);
			SpinnerModel modeltau = new SpinnerNumberModel(0, 0, 99, 1);
			JSpinner spinner = new JSpinner(modeltau);
			spinner.setPreferredSize(new Dimension(40, 40));
			pane.add(spinner, c);
		}
	}

	/**
	 * Inicialization of components.
	 */
	private void initComponents()
	{
		initMainPanel();
		initTop();
		initCenter();
		initBottom();

		setSize(WINDOW_W, WINDOW_H);
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
