package bartender;

import chrriis.dj.nativeswing.NativeComponentWrapper;
import chrriis.dj.nativeswing.NativeSwing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		this.currentLang = currentLang;
		this.productGambled = productGambled;
		
		decideResult();
		initFrame();
		initComponents();
	}

	/**
	 * Sets the frame window, height, title etc.
	 */
	private void initFrame()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		pane = mainPanel;
		add(mainPanel, BorderLayout.NORTH);
		c = new GridBagConstraints();

		setSize(Bartender.WINDOW_W, Bartender.WINDOW_H);
		setTitle("Automatic Bartender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Initializes components.
	 */
	private void initComponents()
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
