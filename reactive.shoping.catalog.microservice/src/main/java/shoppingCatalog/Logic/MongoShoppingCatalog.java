package shoppingCatalog.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shoppingCatalog.Boundary.Product;
import shoppingCatalog.Data.*;
import shoppingCatalog.Exceptions.*;

@Service
public class MongoShoppingCatalog implements ShoppingCatalogService {

	private Validator validator;
	private ShoppingCatalogDao shoppingCatalogDao;
	
	@Autowired
	public MongoShoppingCatalog(ShoppingCatalogDao shoppingCatalogDao,Validator validator) {
		super();
		this.shoppingCatalogDao = shoppingCatalogDao;
		this.validator=validator;
	}
	@Override
	public Mono<Product> store(Product newProduct) {
		return Mono.just(newProduct)
				.flatMap(boundary->{
					if(!this.validator.isValidProduct(boundary))
						return Mono.error(()-> new ProductInvalidException("Invalid Product input"));
					else {
						return this.shoppingCatalogDao
						.findById(boundary.getId())//Mono<ProductEntity>
						.flatMap(entity ->{
							return Mono.error(()-> new ProductAlreadyExistException("Product already exist"));
						})//Empty
						.switchIfEmpty(
								Mono.defer(() ->{
									return Mono.just(boundary)
											.map(this::toEntity)
											.flatMap(entity-> this.shoppingCatalogDao.save(entity))
											.map(this::toBoundary);
								}))//Mono<Object>
						.cast(Product.class);//Mono<Product>
					}
				});
				
	}

	@Override
	public Mono<Product> getProductById(String productId) {
		
		Product productToCheck = new Product();
		productToCheck.setId(productId);
		
		return Mono.just(productToCheck)
				.flatMap(boundary ->{
					if(!this.validator.isValidId(productToCheck.getId()))
						return Mono.error(() -> new ProductIsNotExistException("Product isn't exists "+productId));
					else {
						return 	this.shoppingCatalogDao.
								findById(productId)
								.switchIfEmpty(Mono.error(() -> new ProductIsNotExistException("Product isn't exists "+productId)))// Mono<ProductEntity>
								.map(this::toBoundary) // Mono<Product>
								.log(); // Mono<Product>
					}	
				});
				
			
	}

	@Override
	public Mono<Void> deleteAllShoppingCatalog() {
		return this.shoppingCatalogDao
				.deleteAll();
	}

	public Product toBoundary(ProductEntity entity) {
		Product rv = new Product();

		rv.setId(entity.getId());
		rv.setName(entity.getName());
		rv.setPrice(""+entity.getPrice());
		rv.setImage(entity.getImage());
		rv.setProductDetails(entity.getProductDetails());
		rv.setCategory(entity.getCategory());

		return rv;
	}

	public ProductEntity toEntity(Product boundary) {
		ProductEntity rv = new ProductEntity();

		rv.setId(boundary.getId());
		rv.setName(boundary.getName());
		rv.setPrice(Double.parseDouble(boundary.getPrice()));
		rv.setImage(boundary.getImage());
		rv.setProductDetails(boundary.getProductDetails());
		rv.setCategory(boundary.getCategory());

		return rv;
	}
	@Override
	public Flux<Product> getSortedProducts(String filterType, String value, String sortAttribute, String order) {
		Product helper = new Product();

		return Flux.just(helper)
				.flatMap(boundary ->{
					
					if(!this.validator.isValidFilterType(filterType)) {
						return Flux.error(() -> new InvalidFilterTypeException("Filter type must be byName/byMinPrice/byMaxPrice/byCategoryName"));}
					else {
						if(!this.validator.isValidSortAttribute(sortAttribute)) {
							Flux.error(() -> new InvalidSortAttributeException("Sort Attribute must be id/name/price/image/category"));
						}else {
							if(!this.validator.isValidOrder(order))
								Flux.error(() -> new InvalidOrderException("Order must be ASC/DESC"));
						}
						switch (filterType) {
							case "byName":
								
								break;
							case "byMinPrice":
								
								break;
							case "byMaxPrice":
								
								break;
							case "byCategoryName":
								
								break;
						}
					}
					return this.shoppingCatalogDao.findAll()
							.map(this::toBoundary)
							.log();
				});
	}

}
