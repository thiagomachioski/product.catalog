package in.thiago.product.catalog.services.category;

import in.thiago.product.catalog.domain.category.CategoryHandler;
import in.thiago.product.catalog.domain.category.CategoryRepository;
import in.thiago.product.catalog.domain.category.CategoryService;
import in.thiago.product.catalog.ui.category.dtos.CategoryCreateCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryHandler categoryHandler;

    @Override
    public CategoryResult create(CategoryCreateCommand category) throws ConstraintViolationException, CategoryCollectionException {
         var categoryOptional = categoryRepository.findByCategory(category.getCategory());

         if(categoryOptional.isPresent())
             throw new CategoryCollectionException(CategoryCollectionException.CategoryAlreadyExists());

         category.setCreatedAt(new Date(System.currentTimeMillis()));
         var result = categoryRepository.save(categoryHandler.createCategoryByCreateCommand(category));

         return categoryHandler.createCategoryResultByCategory(result);
    }

    @Override
    public List<CategoryResult> getAll() {
        return null;
    }

    @Override
    public CategoryResult get(String id) throws CategoryCollectionException {
        return null;
    }

    @Override
    public Optional<CategoryResult> update(String id, CategoryCreateCommand todo) throws CategoryCollectionException {
        return Optional.empty();
    }

    @Override
    public Optional<CategoryResult> delete(String id) throws CategoryCollectionException {
        return Optional.empty();
    }
}
