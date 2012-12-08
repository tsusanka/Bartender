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
	 * Constructor from one item.
	 *
	 */
	public Products(Product a)
	{
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(a);
		arr = list;
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
	
	/**
	 * Sets amount of drinks customer ordered.
	 */
	public void setAmountsOrdered() {
		for (Product product : arr) {
			product.setAmount((Integer) product.getSpinner().getValue());
		}
	}
}
