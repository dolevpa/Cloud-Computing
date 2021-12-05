package shoppingCatalog.Boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import shoppingCatalog.Logic.ShoppingCatalogService;


@RestController
public class ShoppingCatalogController {

	private ShoppingCatalogService shoppingCatalogService;

	@Autowired
	public ShoppingCatalogController(ShoppingCatalogService shoppingCatalogService) {
		super();
		this.shoppingCatalogService = shoppingCatalogService;
	}

	@RequestMapping(path = "/shopping/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> store(@RequestBody Product newProduct) {
		return this.shoppingCatalogService.store(newProduct);
	}

	@RequestMapping(path = "/shopping/products/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Product> getProductById(@PathVariable("productId") String productId) {
		return this.shoppingCatalogService.getProductById(productId);
	}

	@RequestMapping(path = "/shopping", method = RequestMethod.DELETE)
	public Mono<Void> deleteAllShoppingCatalog() {
		return this.shoppingCatalogService.deleteAllShoppingCatalog();
	}

	@RequestMapping(path = "/shopping/products", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getSortedProducts(@RequestParam(name = "filterType", required = false) String filterType,
			@RequestParam(name = "filterValue", required = false) String value,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortAttribute,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") String order) {

		return this.shoppingCatalogService.getSortedProducts(filterType, value, sortAttribute, order);

	}
}
