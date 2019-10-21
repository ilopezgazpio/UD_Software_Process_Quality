package com.sample.product;

import com.sample.product.util.ProductCatalog;

import java.io.File;

public class Product
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
    {
		String path = "src/main/resources/products";
		Product catalog = new Product();
		catalog.readCatalogFromFolder(path);

		try
        {
			System.in.read();
		}
		catch (Exception e)
        {
			e.printStackTrace();
		}
	}

	public void readCatalogFromFolder(String name)
    {
		
		if(name == null)
		{
			System.out.println("invalid folder name");
			return;
		}
		
		File file = new File(name);
		if(!file.exists() || !file.isDirectory())
		{
			System.out.println("invalid folder name " + name);
			return;
		}
		
		ProductCatalog info = new ProductCatalog();
		info.readData(name);
		
		System.out.println(info.getContent());
		
	}

}
