package bartender;

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
}
