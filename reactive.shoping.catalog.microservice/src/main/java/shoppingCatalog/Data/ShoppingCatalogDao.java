package shoppingCatalog.Data;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;

public interface ShoppingCatalogDao extends ReactiveMongoRepository<ProductEntity, String> {

	public Flux<ProductEntity> findAllByPriceEqualOrBigger(
			@Param("minPrice") long minPrice,
			Sort sort);
	
	public Flux<ProductEntity> findAllByPriceEqualOrSmaller(
			@Param("maxPrice") long maxPrice,
			Sort sort);
	
	public Flux<ProductEntity> findAllByCategoryLike(
			@Param("catgeory") String catgeory,
			Sort sort);
	
	
}
