package in.thiago.product.catalog.repository.product;

import in.thiago.product.catalog.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    
    @Query("{title: ?0}")
    Optional<Product> findByTitle(String title);

}
