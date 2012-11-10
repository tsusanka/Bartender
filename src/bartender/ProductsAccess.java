package bartender;

import java.io.*;

/**
 * Provides access to read and write product's names.
 *
 * @author Tomáš Sušánka
 */
public class ProductsAccess
{

	private static final String PRODUCTS_FILENAME = "products.ser";

	/**
	 * Dummy constructor.
	 */
	public ProductsAccess()
	{
	}

	/**
	 * Loads Products from earlier serialized file.
	 *
	 * @return Products
	 */
	public static Products read()
	{
		//TODO: loading products from file
		Products products = null;
		try {
			FileInputStream fileIn =
					new FileInputStream(PRODUCTS_FILENAME);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			products = (Products) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Products class notfound.");
			c.printStackTrace();
			return null;
		}
		return products;
	}

	/**
	 * Saves serilized Products to a file.
	 *
	 * @param products
	 */
	public static void write(Products products)
	{
		try {
			FileOutputStream fileOut =
					new FileOutputStream(PRODUCTS_FILENAME);
			ObjectOutputStream out =
					new ObjectOutputStream(fileOut);
			out.writeObject(products);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
