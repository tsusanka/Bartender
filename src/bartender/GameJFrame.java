package bartender;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Represents the gamble on specific product.
 * 
 * @author Tomas Susanka
 */
public final class GameJFrame extends OwnJFrame
{
	
	/**
	 * @var Product productGambled
	 */
	private Product productGambled;
	/**
	 * @var int Result of the game, randomly generated. Represents how many drinks customer will get.
	 */
	private int result;
	/**
	 * @var int Minimum of drinks the customer will get.
	 */
	private final int MIN_WIN = 1;
	/**
	 * @var int Maximum of drinks the customer will get.
	 */
	private final int MAX_WIN = 4;
	
	/**
	 * Constructor shows this frame.
	 *
	 * @param currentLang current language
	 */
	public GameJFrame(Language currentLang, Product productGambled)
	{
		super(currentLang);
		this.productGambled = productGambled;
		
		initComponents();
		decideResult();
	}

	@Override
	protected void initComponents()
	{
		JLabel label = new JLabel(currentLang.getSentence("letsplayabout") +
		productGambled.getName() + ":");
		c.insets = new Insets(30, 10, 10, 10);
		c.gridx = 0;
		pane.add(label, c);
				
		JButton btn = new JButton();
		btn.setText(currentLang.getSentence("twist"));
		c.gridx = 1;
		c.gridy = 4;
		pane.add(btn, c);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Roulette dummy = new Roulette(result);
			}
		});
	}
	
	/**
	 * Generates the result of this game.
	 */
	private void decideResult()
	{
		result = MIN_WIN + (int)(Math.random() * ((MAX_WIN - MIN_WIN) + 1));
		System.out.println(result);
	}

}
