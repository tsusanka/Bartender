package bartender;

import java.util.ArrayList;

/**
 * This class represents products - collection of Product instances.
 *
 * @author Tomáš Sušánka
 */
public class Products implements java.io.Serializable
{

	/**
	 * @var ArrayList<Product> array containing all products
	 */
	private ArrayList<Product> arr;

	/**
	 * Constructor from ArrayList.
	 *
	 * @param ArrayList<Product>
	 */
	public Products(ArrayList<Product> a)
	{
		arr = (ArrayList<Product>) a.clone();
	}

	/**
	 * Empty constructor.
	 *
	 */
	public Products()
	{
	}

	/**
	 * Returns all products in ArrayList.
	 *
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getAll()
	{
		return arr;
	}
}
