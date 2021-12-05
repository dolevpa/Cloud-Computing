package shoppingCatalog.Logic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shoppingCatalog.Boundary.Product;

public interface ShoppingCatalogService {

	Mono<Product> store(Product newProduct);

	Mono<Product> getProductById(String productId);

	Mono<Void> deleteAllShoppingCatalog();

	Flux<Product> getSortedProducts(String filterType, String value, String sortAttribute, String order);
	
	
}
