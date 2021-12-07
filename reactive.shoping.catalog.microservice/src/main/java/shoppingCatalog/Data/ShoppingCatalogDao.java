package shoppingCatalog.Data;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;

public interface ShoppingCatalogDao extends ReactiveMongoRepository<ProductEntity, String> {

	public Flux<ProductEntity> findAllByName(@Param("name") String name, Sort sort);

	public Flux<ProductEntity> findAllByPriceEqualOrBigger(@Param("minPrice") double minPrice, Sort sort);

	public Flux<ProductEntity> findAllByPriceEqualOrSmaller(@Param("maxPrice") double maxPrice, Sort sort);

	public Flux<ProductEntity> findAllByCategoryLike(@Param("catgeory") String catgeory, Sort sort);

}
