package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;

import java.util.ArrayList;
import java.util.List;


public interface CategoryHandler {
    Category categoryCreateCommandToCategory(CategoryCommand category);
    CategoryResult categoryToCategoryResult(Category category);
    ArrayList<CategoryResult> categoryToCategoryResult(List<Category> categories);
    Category categoryCommandToCategoryUpdate(Category category, CategoryCommand categoryCommand);
}
