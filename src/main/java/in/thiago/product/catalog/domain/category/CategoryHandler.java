package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.ui.category.dtos.*;

import java.util.ArrayList;
import java.util.List;


public interface CategoryHandler {

    Category categoryCreateCommandToCategory(CategoryCommand category);

    CategoryResult categoryToCategoryResult(Category category);

    ArrayList<CategoryResult> categoryToCategoryResult(List<Category> categories);

    CategoryCreateResult categoryToCategoryCreateResult(Category category, RequestType requestType);

    CategoryUpdateResult categoryToCategoryUpdateResult(Category category, RequestType requestType);

    CategoryDeleteResult categoryToCategoryDeleteResult(Category category, RequestType requestType);

    Category categoryCommandToCategoryUpdate(Category category, CategoryCommand categoryCommand);

}
