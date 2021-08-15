package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{category: ?0}")
    Optional<CategoryCommand> findByCategory(String category);

}
