package shoppingCatalog.Data;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;

public interface DaoShoppingCatalog extends ReactiveMongoRepository<EntityProduct, String>{
	
	public Flux<EntityProduct> findAllByName(@Param("name") String name, Sort sort);

	public Flux<EntityProduct> findAllByPriceEqualsOrPriceGreaterThan(@Param("price") double price, Sort sort);

	public Flux<EntityProduct> findAllByPriceEqualsOrPriceLessThan(@Param("price") double price, Sort sort);

	public Flux<EntityProduct> findAllByCategoryLike(@Param("catgeory") String catgeory, Sort sort);

}
