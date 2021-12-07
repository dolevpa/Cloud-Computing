package shoppingCatalog.Logic;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import shoppingCatalog.Boundary.Product;

@Component
public class ValidatorImplementation implements Validator {

	@Override
	public boolean isValidId(String id) {

		boolean flag = false;
		if (id == null)
			return flag;
		if (id.length() < 3)
			return flag;
		for (int i = 0; i < id.length(); i++) {
			if (Character.isDigit(id.charAt(i)))
				flag = true;
		}

		return flag;
	}

	@Override
	public boolean isValidName(String name) {
		if (name == null)
			return false;
		if (name.isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean isValidPrice(String price) {
		
		try {
			if(Double.parseDouble(price) < 0 )
				return false;
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isValidImage(String image) {
		if (image == null)
			return false;
		
		String regex = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$)";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);
		// Pattern class contains matcher() method
		// to find matching between given string
		// and regular expression.
		Matcher m = p.matcher(image);
		// Return if the string
		// matched the ReGex
		return m.matches();
	
	}

	@Override
	public boolean isValidProductDetails(HashMap<String, Object> productDetails) {
		if(productDetails == null)
			return false;
		return true;
	}

	@Override
	public boolean isValidCategory(String category) {
		if(category==null)
			return false;
		if (category.isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean isValidProduct(Product product) {
		if(product == null)
			return false;
		else {
			return this.isValidCategory(product.getCategory()) &&
					this.isValidId(product.getId())&&
					this.isValidImage(product.getImage())&&
					this.isValidName(product.getName())&&
					this.isValidPrice(product.getPrice())&&
					this.isValidProductDetails(product.getProductDetails());
		}
	}

	@Override
	public boolean isValidFilterType(String filterType) {
		if(filterType !=null){
			if(		filterType.equals("byName") || 
					filterType.equals("byMinPrice") ||
					filterType.equals("byMaxPrice") ||
					filterType.equals("byCategoryName"))
				return true;
			else
				return false;
		}
		else
			return true;
	}



	@Override
	public boolean isValidSortAttribute(String sortAttribute) {
		if(		sortAttribute.equals("id") || 
				sortAttribute.equals("name") ||
				sortAttribute.equals("price") ||
				sortAttribute.equals("image") ||
				sortAttribute.equals("category"))
			return true;
		else
			return false;
	}

	@Override
	public boolean isValidOrder(String order) {
		if(		order.equals("ASC") || 
				order.equals("DESC") )
			return true;
		else
			return false;
	}

}
