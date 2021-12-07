package shoppingCatalog.Data;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "catalogProducts")
public class EntityProduct {

	private String id;
	private String name;
	private double price;
	private String image;
	private HashMap<String, Object> productDetails;
	private String category;

	public EntityProduct() {
		super();
	}

	@Id
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
		return "EntityProduct [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image
				+ ", productDetails=" + productDetails + ", category=" + category + "]";
	}

	
	
}
