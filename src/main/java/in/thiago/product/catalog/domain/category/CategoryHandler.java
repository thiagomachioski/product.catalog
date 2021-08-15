package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;

public interface CategoryHandler {

    Category createCategoryByCreateCommand(CategoryCommand category);
    CategoryResult createCategoryResultByCategory(Category category);
}
