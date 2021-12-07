package shoppingCatalog.Boundary;

import java.util.HashMap;

public class Product {
	
	private String id;
	private String name;
	private String price;
	private String image;
	private HashMap<String,Object> productDetails;
	private String category;
	
	public Product() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public HashMap<String, Object> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(HashMap<String, Object> productDetails) {
		this.productDetails = productDetails;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", productDetails="
				+ productDetails + ", category=" + category + "]";
	}
	
	
	
	
	

}
