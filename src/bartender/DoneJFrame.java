package bartender;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tomas Susanka
 */
public class DoneJFrame extends JFrame
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
	 * @var Products products offered and possibly ordered
	 */
	private Products products;
	/**
	 * @var Container pane
	 */
	private Container pane;

	/**
	 * Constructor shows this frame.
	 *
	 * @param currentLang current language
	 */
	public DoneJFrame(Language currentLang, Products products)
	{
		this.currentLang = currentLang;
		this.products = products;
		
		initFrame();

		JLabel label = new JLabel(currentLang.getSentence("done"));
		label.setFont(new Font("Arial", Font.BOLD, 18));
		c.insets = new Insets(30, 10, 10, 10);
		pane.add(label, c);

		initProductSummary();
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
	 * Initializes product labels for summary.
	 */
	private void initProductSummary()
	{
		JLabel label = new JLabel("<html><u>" + currentLang.getSentence("recap") + "</u></html>");
		
		c.insets = new Insets(15, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(label, c);
		int i = 2;
		for (Product product : products.getAll()) {
			if (product.getAmountOrdered() == 0)
				continue;
			JLabel productLabel = new JLabel("<html>" + product.getAmountOrdered() + "&times; " + product.getName() + "</html>");
			c.gridx = 0;
			c.gridy = i++;
			c.insets = new Insets(6, 10, 10, 10);
			pane.add(productLabel, c);
		}
	}
}
