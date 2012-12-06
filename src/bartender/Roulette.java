/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package bartender;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JFlashPlayer;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class represents the roulette game.
 */
public class Roulette extends JPanel
{
	/**
	 * @var int width of the roulette window
	 */
	private final int WIDTH = 400;
	/**
	 * @var int height of the roulette window
	 */
	private final int HEIGHT = 300;
	
	/**
	 * Main constructor. Initializes the roulette window and starts to spin.
	 * 
	 * @param int The outcome of the game (result), depending on that the animation is chosen.
	 */
	public Roulette(int num)
	{
		super(new BorderLayout());
		final JFlashPlayer flashPlayer = new JFlashPlayer();
		flashPlayer.load(getClass(), "imgs/wheel" + num + ".swf");
		add(flashPlayer, BorderLayout.CENTER);

		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		
		JLabel resultLabel = new JLabel("↓↓↓↓↓");
		resultLabel.setHorizontalAlignment(SwingUtilities.CENTER);
		
		JFrame frame = new JFrame("Automatic Bartender");
		frame.getContentPane().add(resultLabel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(flashPlayer, BorderLayout.CENTER);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}
