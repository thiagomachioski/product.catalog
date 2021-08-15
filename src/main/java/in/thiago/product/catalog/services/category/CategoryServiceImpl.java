package in.thiago.product.catalog.services.category;

import in.thiago.product.catalog.domain.category.CategoryHandler;
import in.thiago.product.catalog.domain.category.CategoryService;
import in.thiago.product.catalog.repository.category.CategoryRepository;
import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryHandler categoryHandler;

    @Override
    public CategoryResult create(CategoryCommand category) throws ConstraintViolationException, CategoryCollectionException {
        var categoryOptional = categoryRepository.findByCategory(category.getCategory());

        if (categoryOptional.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.CategoryAlreadyExists());

        var result = categoryRepository.save(categoryHandler.categoryCreateCommandToCategory(category));

        return categoryHandler.categoryToCategoryResult(result);
    }

    @Override
    public List<CategoryResult> getAll() {
        var categories = categoryRepository.findAll();
        if (categories.size() > 0)
            return categoryHandler.categoryToCategoryResult(categories);
        return new ArrayList<CategoryResult>();
    }

    @Override
    public CategoryResult get(String id) throws CategoryCollectionException {
        var category = categoryRepository.findById(id);
        if (!category.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.NotFoundException(id));
        return categoryHandler.categoryToCategoryResult(category.get());
    }

    @Override
    public CategoryResult update(String id, CategoryCommand category) throws CategoryCollectionException {
        var categoryWithId = categoryRepository.findById(id);
        var categoryWithSameName = categoryRepository.findByCategory(category.getCategory());

        if(!categoryWithId.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.NotFoundException(id));

        if(categoryWithSameName.isPresent() && categoryWithSameName.get().getId().equals(id))
            throw new CategoryCollectionException(CategoryCollectionException.CategoryAlreadyExists());

        var categoryToUpdate = categoryHandler.categoryCommandToCategoryUpdate(categoryWithId.get(), category);
        var result = categoryRepository.save(categoryToUpdate);
        return categoryHandler.categoryToCategoryResult(result);
    }

    @Override
    public Optional<CategoryResult> delete(String id) throws CategoryCollectionException {
        return Optional.empty();
    }
}
