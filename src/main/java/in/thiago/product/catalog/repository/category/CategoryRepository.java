package in.thiago.product.catalog.repository.category;

import in.thiago.product.catalog.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{category: ?0}")
    Optional<Category> findByCategory(String category);

}
