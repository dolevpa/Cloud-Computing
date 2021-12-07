package shoppingCatalog.Logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shoppingCatalog.Boundary.Product;
import shoppingCatalog.Data.*;
import shoppingCatalog.Exceptions.*;

@Service
public class MongoShoppingCatalog implements ShoppingCatalogService {

	private Validator validator;
	private DaoShoppingCatalog daoShoppingCatalog;
	
	@Autowired
	public MongoShoppingCatalog(DaoShoppingCatalog daoShoppingCatalog,Validator validator) {
		super();
		this.daoShoppingCatalog = daoShoppingCatalog;
		this.validator=validator;
	}
	@Override
	public Mono<Product> store(Product newProduct) {
		return Mono.just(newProduct)
				.flatMap(boundary->{
					if(!this.validator.isValidProduct(boundary))
						return Mono.error(()-> new ProductInvalidException("Invalid Product input"));
					else {
						return this.daoShoppingCatalog
						.findById(boundary.getId())//Mono<ProductEntity>
						.flatMap(entity ->{
							return Mono.error(()-> new ProductAlreadyExistException("Product already exist"));
						})//Empty
						.switchIfEmpty(
								Mono.defer(() ->{
									return Mono.just(boundary)
											.map(this::toEntity)
											.flatMap(entity-> this.daoShoppingCatalog.save(entity))
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
						return Mono.error(() -> new InvalidIdException("Id must be at least 3 characters long, and at least 1 digit!"));
					else {
						return 	this.daoShoppingCatalog.
								findById(productId)
								.switchIfEmpty(Mono.error(() -> new ProductIsNotExistException("Product isn't exists "+productId)))// Mono<ProductEntity>
								.map(this::toBoundary) // Mono<Product>
								.log(); // Mono<Product>
					}	
				});
				
			
	}

	@Override
	public Mono<Void> deleteAllShoppingCatalog() {
		return this.daoShoppingCatalog
				.deleteAll();
	}

	public Product toBoundary(EntityProduct entity) {
		Product rv = new Product();

		rv.setId(entity.getId());
		rv.setName(entity.getName());
		rv.setPrice(""+entity.getPrice());
		rv.setImage(entity.getImage());
		rv.setProductDetails(entity.getProductDetails());
		rv.setCategory(entity.getCategory());

		return rv;
	}

	public EntityProduct toEntity(Product boundary) {
		EntityProduct rv = new EntityProduct();

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
							return Flux.error(() -> new InvalidSortAttributeException("Sort Attribute must be id/name/price/image/category"));
						}else {
							if(!this.validator.isValidOrder(order))
								return Flux.error(() -> new InvalidOrderException("Order must be ASC/DESC"));
						}
						if(filterType ==null) {
							return this.daoShoppingCatalog.findAll(
									Sort.by(order.equals("ASC") ? Direction.ASC : Direction.DESC, sortAttribute, "id"))
                                    .map(this::toBoundary)
                                    .log();
						}
						switch (filterType) {
							case "byName":
								return this.daoShoppingCatalog.findAllByName(
										value,
										Sort.by(order.equals("ASC")?Direction.ASC:Direction.DESC,sortAttribute,"id"))
										.map(this::toBoundary)
										.log();
								
							case "byMinPrice":
								if(!this.validator.isValidPrice(value))
									return Flux.error(() -> new InvalidPriceException("Price must be number greater then 0"));
								else {
									return this.daoShoppingCatalog.
											findAllByPriceEqualsOrPriceGreaterThan(
											Double.parseDouble(value),
											Sort.by(order.equals("ASC")?Direction.ASC:Direction.DESC,sortAttribute,"id"))//Flux<ProductEntity>
											.map(this::toBoundary)//Flux<Product>
											.log();//Flux<Product>
								}
								
							case "byMaxPrice":
								if(!this.validator.isValidPrice(value))
									return Flux.error(() -> new InvalidPriceException("Price must be number greater then 0"));
								else {
									return this.daoShoppingCatalog.
											findAllByPriceEqualsOrPriceLessThan(
											Double.parseDouble(value),
											Sort.by(order.equals("ASC")?Direction.ASC:Direction.DESC,sortAttribute,"id"))//Flux<ProductEntity>
											.map(this::toBoundary)//Flux<Product>
											.log();//Flux<Product>
								}
							case "byCategoryName":
								return this.daoShoppingCatalog.findAllByCategoryLike(
										value,
										Sort.by(order.equals("ASC")?Direction.ASC:Direction.DESC,sortAttribute,"id"))
										.map(this::toBoundary)//Flux<Product>
										.log();//Flux<Product>
							default:
								return this.daoShoppingCatalog.findAll(
										Sort.by(order.equals("ASC") ? Direction.ASC : Direction.DESC, sortAttribute, "id"))
	                                    .map(this::toBoundary)
	                                    .log();
		
						}
					}
				});
	}

}
