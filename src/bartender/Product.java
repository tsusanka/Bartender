package bartender;

import javax.swing.JSpinner;

/**
 * Represents single product, mainly his price and name.
 *
 * This class presents one particular product. Besides price and name, each product has its own Spinner, which is placed next to its name and contains the amount ordered by customers. 
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

	/**
	 * Sets name.
	 * 
	 * @param name 
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Sets price of this product.
	 * 
	 * @param price 
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
	
}
