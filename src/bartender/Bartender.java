/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bartender;

import java.io.*;

/**
 * Main class creating instances
 *
 * @author Tomas Susanka
 */
public class Bartender
{

	/**
	 * Main static function.
	 */
	public static void main(String[] args)
	{
		System.out.println("Program started.");
		Language lang = new Language("en");
		MainJFrame window = new MainJFrame(lang);
		window.setVisible(true);

	
	}
}