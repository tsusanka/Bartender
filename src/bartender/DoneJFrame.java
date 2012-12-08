package bartender;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JLabel;

/**
 * Final frame showing summary of the order.
 * 
 * This class represents the final window, that is displayed after the order is finished. It contains a simple summary of all products ordered and it informs the customer that his/hers order is being served.
 * 
 * @author Tomas Susanka
 */
public final class DoneJFrame extends OwnJFrame
{

	/**
	 * @var Products products offered and possibly ordered
	 */
	private Products products;

	/**
	 * Constructor shows this frame.
	 *
	 * @param currentLang current language
	 */
	public DoneJFrame(Language currentLang, Products products)
	{
		super(currentLang);
		this.products = products;
		
		initComponents();
	}

	@Override
	protected void initComponents()
	{
		JLabel label = new JLabel(currentLang.getSentence("done"));
		label.setFont(new Font("Arial", Font.BOLD, 18));
		c.insets = new Insets(30, 10, 10, 10);
		pane.add(label, c);

		initProductSummary();
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
			if (product.getAmountOrdered() == 0) {
				continue;
			}
			JLabel productLabel = new JLabel("<html>" + product.getAmountOrdered() + "&times; " + product.getName() + "</html>");
			c.gridx = 0;
			c.gridy = i++;
			c.insets = new Insets(6, 10, 10, 10);
			pane.add(productLabel, c);
		}
	}
}
