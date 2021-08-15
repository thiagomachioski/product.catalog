package in.thiago.product.catalog.services.category;

import in.thiago.product.catalog.domain.category.Category;
import in.thiago.product.catalog.domain.category.CategoryHandler;
import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;

public class CategoryHandlerImpl implements CategoryHandler {

    @Override
    public Category createCategoryByCreateCommand(CategoryCommand category) {
        return new Category(category.getCategory(), category.getCreatedAt());
    }

    @Override
    public CategoryResult createCategoryResultByCategory(Category category) {
        return new CategoryResult(category.getId(), category.getCategory(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
