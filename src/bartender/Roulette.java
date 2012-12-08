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
 * Mainly it's animation.
 *
 * @author Tomas Susanka
 */
public class Roulette extends JPanel
{

	/**
	 * @var int width of the roulette window
	 */
	private final int ROULETTE_WIDTH = 400;
	/**
	 * @var int height of the roulette window
	 */
	private final int ROULETTE_HEIGHT = 300;
	/**
	 * @var JFrame roulette's frame
	 */
	private JFrame frame;

	/**
	 * Main constructor. Initializes the roulette window and starts to spin.
	 *
	 * @param int The outcome of the game (result), depending on that the
	 * animation is chosen.
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

		frame = new JFrame(Bartender.WINDOW_TITLE);
		frame.getContentPane().add(resultLabel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(flashPlayer, BorderLayout.CENTER);
		frame.setSize(ROULETTE_WIDTH, ROULETTE_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Hides the main frame.
	 */
	public void hideFrame()
	{
		frame.setVisible(false);
	}
	
	
}
