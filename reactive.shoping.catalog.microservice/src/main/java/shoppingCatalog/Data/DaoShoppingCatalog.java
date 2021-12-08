package shoppingCatalog.Data;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;

public interface DaoShoppingCatalog extends ReactiveMongoRepository<EntityProduct, String> {

	public Flux<EntityProduct> findAllByName(@Param("name") String name, Sort sort);

	public Flux<EntityProduct> findAllByPriceGreaterThanEqual(@Param("price") double price, Sort sort);

	public Flux<EntityProduct> findAllByPriceLessThanEqual(@Param("price") double price, Sort sort);

	public Flux<EntityProduct> findAllByCategory(@Param("catgeory") String catgeory, Sort sort);

}
