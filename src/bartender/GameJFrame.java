package bartender;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Frame containing information about the game and possibility to play.
 *
 * This class represents the window that's opened, when the customer clicks on one of the red buttons. If so, a window is opened containing two buttons. One to spin the roulette and play for the drinks, the other one is to chicken out and just take normal order. 
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
	 * @var int Result of the game, randomly generated. Represents how many
	 * drinks customer will get.
	 */
	private int result;
	/**
	 * @var int Minimum of drinks the customer will get.
	 */
	private final int MIN_WIN_NUM = 1;
	/**
	 * @var int The maximum random number generated. That means how many places the roulette has. 
	 */
	private final int MAX_WIN_NUM = 8;
	/**
	 * @var int The animation's length in ms.
	 */
	private final int ANIMATION_DURATION = 9400;
	/**
	 * @var int waiting time for payment (showing dialog) in miliseconds
	 */
	private static final int CONGRATS_WAITING_TIME = 3000;

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
		initTop();
		initMain();
	}

	/**
	 * Initializes top part of the frame.
	 */
	private void initTop()
	{
		JLabel label = new JLabel(currentLang.getSentence("letsplayabout")
				+ productGambled.getName() + ":");
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 4;
		pane.add(label, c);

	}

	/**
	 * Initializes the rest of the frame.
	 */
	private void initMain()
	{
		ImageIcon rouletteIcon = new ImageIcon(getClass().getResource("imgs/roulette.png"));
		JLabel roulette = new JLabel(rouletteIcon);
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 3;
		pane.add(roulette, c);

		initTwistButton();
		initNoGameButton();
	}
	
	/**
	 * Initializes button, which twists the roulette.
	 */
	private void initTwistButton()
	{
		JButton btn = new JButton(currentLang.getSentence("twist"));
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		pane.add(btn, c);
		btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Roulette roulette = new Roulette(result);
				waitForAnimationToFinish(roulette);
			}
		});
	}
	
	/**
	 * Initializes button, which cancels the game and gives the customer paid order.
	 */
	private void initNoGameButton()
	{
		JButton exitBtn = new JButton(currentLang.getSentence("noback"));
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		pane.add(exitBtn, c);

		productGambled.setAmount(2);
		exitBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				DoneJFrame dummy = new DoneJFrame(currentLang, new Products(productGambled));
				hideFrame();
				dummy.showFrame();
			}
		});
	}

	/**
	 * Generates the result of this game.
	 * 
	 * Probability of 1x or 2x is bigger than 3x or 4x, that's why an if statement. 
	 */
	private void decideResult()
	{
		int gen = MIN_WIN_NUM + (int) (Math.random() * ((MAX_WIN_NUM - MIN_WIN_NUM) + 1)); 
		
		if (gen < 4)
			result = 1;
		else if (gen < 7)
			result = 2;
		else if (gen == 7)
			result = 3;
		else if (gen == 8)
			result = 4;
	}

	/**
	 * Set timers to wait for the animation to finish based on the constant.
	 * 
	 * @param rouletteToHide instance of roulette game we are hiding
	 */
	private void waitForAnimationToFinish(final Roulette rouletteToHide)
	{
		JOptionPane optionPane = new JOptionPane(currentLang.getSentence("result" + result));
		final JDialog dialog = optionPane.createDialog(pane, "Result");
		Timer timer = new Timer(ANIMATION_DURATION, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
				dialog.setVisible(true);
			}
		});
		timer.setRepeats(false);
		timer.start();
		
		productGambled.setAmount(result);
		Timer timer2 = new Timer(ANIMATION_DURATION + CONGRATS_WAITING_TIME, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent ae)
			{
				rouletteToHide.hideFrame();
				dialog.setVisible(false);
				hideFrame();
				DoneJFrame dummy = new DoneJFrame(currentLang, new Products(productGambled));
				dummy.showFrame();
			}
		});

		timer2.setRepeats(false);
		timer2.start();
	}
}
