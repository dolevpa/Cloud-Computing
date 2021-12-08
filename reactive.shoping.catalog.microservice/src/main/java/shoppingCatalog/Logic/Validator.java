package shoppingCatalog.Logic;

import java.util.HashMap;

import shoppingCatalog.Boundary.Product;

public interface Validator {
	
	public boolean isValidId(String id);
	
	public boolean isValidName(String name);
	
	public boolean isValidPrice(String price);
	
	public boolean isValidImage(String image);
	
	public boolean isValidProductDetails(HashMap<String,Object> productDetails);
	
	public boolean isValidCategory(String category);
	
	public boolean isValidProduct(Product product);
	
	public boolean isValidFilterType(String filterType);
	
	public boolean isValidSortAttribute(String sortAttribute);
	
	public boolean isValidOrder(String order);

}
