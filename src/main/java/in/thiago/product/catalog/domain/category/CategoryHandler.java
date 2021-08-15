package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCreateCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;


public interface CategoryHandler {
    Category createCategoryByCreateCommand(CategoryCreateCommand category);
    CategoryResult createCategoryResultByCategory(Category category);
}
