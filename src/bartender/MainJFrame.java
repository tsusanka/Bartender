package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Main window containg all buttons, labels etc.
 *
 * @author Tomas Susanka
 */
public class MainJFrame extends JFrame
{

	/** @var int Window width */
	private final static int WINDOW_W = 500;
	
	/** @var int Window width */
	private final static int WINDOW_H = 300;
	
	/** @var JButton save button*/
	private JButton savebtn;
	
	/** @var Language language for accesing words */
	private Language lang;
	

	/**
	 * Constructor initialazing components.
	 */
	public MainJFrame(Language language)
	{
		lang = language;
		initComponents();
	}

	/**
	 * Inicialization of top screen.
	 */
	private void initTop()
	{
		JLabel productsLabel = new JLabel("<html><b>" + lang.getSentence("choose") + "</b></html>");
		productsLabel.setBorder(new EmptyBorder(new Insets(20, 10, 20, 0)));
		add(productsLabel, BorderLayout.NORTH);
	}

	/**
	 * Inicialization of bottom screen.
	 */
	private void initBottom()
	{
		JPanel pan = new JPanel(new BorderLayout());

		ImageIcon okIcon = new ImageIcon(getClass().getResource("imgs/coins.png"));
		savebtn = new JButton(lang.getSentence("pay"), okIcon);
		savebtn.setPreferredSize(new Dimension(100, 60));
		savebtn.setBorder(new BasicBorders.ButtonBorder(Color.lightGray, Color.lightGray, Color.lightGray, Color.lightGray));
		/*
		 * savebtn.addActionListener(new ActionListener() {
		 *
		 * @Override
		 * public void actionPerformed(ActionEvent ae) {
		 * //performed?
		 * }
		 * });
		 */
		pan.add(savebtn, BorderLayout.EAST);

		add(pan, BorderLayout.SOUTH);
	}

	/**
	 * Inicialization of center screen.
	 */
	private void initCenter()
	{
		//center components
		//add(table.getTableInScrollPane(), BorderLayout.CENTER);
	}

	/**
	 * Inicialization of components.
	 */
	private void initComponents()
	{
		initTop();

		initCenter();

		initBottom();

		setSize(WINDOW_W, WINDOW_H);
		setTitle("Automatic Bartender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
