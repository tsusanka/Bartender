package bartender;

import javax.swing.JSpinner;

/**
 * Reprezenting product.
 *
 * @author Tomas Susanka
 */
public class Product implements java.io.Serializable
{

	/**
	 * @var String name of the product
	 */
	private String name;
	/**
	 * @var double price of the product
	 */
	private double price;
	/**
	 * @var int how many user ordered of this drink
	 */
	private int amountOrdered = 0;
	/**
	 * @var JSpinner designated spinner for this product
	 */
	private JSpinner spinner;

	/**
	 * Product constructor
	 *
	 * @param name
	 * @param price
	 */
	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	/**
	 * Sets ordered amount by user.
	 * 
	 * @param amount 
	 */
	public void setAmount(int amount)
	{
		this.amountOrdered = amount;
	}

	/**
	 * Assigns spinner
	 * 
	 * @param spinner 
	 */
	public void setSpinner(JSpinner spinner)
	{
		this.spinner = spinner;
	}

	/**
	 * Name getter.
	 *
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Price getter.
	 *
	 * @return double
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * How many user ordered getter.
	 *
	 * @return int
	 */
	public int getAmountOrdered()
	{
		return amountOrdered;
	}

	/**
	 * Returns assigned spinner
	 *
	 * @return JSpinner
	 */
	public JSpinner getSpinner()
	{
		return spinner;
	}
}
