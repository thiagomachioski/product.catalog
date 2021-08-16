package in.thiago.product.catalog.services.category;

import in.thiago.product.catalog.domain.category.Category;
import in.thiago.product.catalog.domain.category.CategoryHandler;
import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryCreateResult;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;
import in.thiago.product.catalog.ui.category.dtos.CategoryUpdateResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryHandlerImpl implements CategoryHandler {

    @Override
    public Category categoryCreateCommandToCategory(CategoryCommand category) {
        return new Category(category.getCategory(), new Date(System.currentTimeMillis()));
    }

    @Override
    public CategoryResult categoryToCategoryResult(Category category) {
        return new CategoryResult(category.getId(), category.getCategory(), category.getCreatedAt(), category.getUpdatedAt());
    }

    @Override
    public CategoryCreateResult categoryToCategoryCreateResult(Category category, RequestType requestType) {
        return setCategoryToCategoryResults(category, requestType);
    }

    @Override
    public CategoryUpdateResult categoryToCategoryUpdateResult(Category category, RequestType requestType) {
        return setCategoryToCategoryResults(category, requestType);
    }

    @Override
    public ArrayList<CategoryResult> categoryToCategoryResult(List<Category> categories) {
        var categoriesResult = new ArrayList<CategoryResult>();
        for (var category : categories) {
            categoriesResult.add(new CategoryResult(category.getId(), category.getCategory(), category.getCreatedAt(), category.getUpdatedAt()));
        }
        return categoriesResult;
    }

    @Override
    public Category categoryCommandToCategoryUpdate(Category category, CategoryCommand categoryCommand) {
        var categoryUpdate = category;
        categoryUpdate.setCategory(categoryCommand.getCategory());
        categoryUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
        return categoryUpdate;
    }

    private <T> T setCategoryToCategoryResults(Category category, RequestType requestType) {
        if(requestType == RequestType.POST)
            return (T) new CategoryCreateResult(category.getId(), category.getCategory(), category.getCreatedAt());

        return (T) new CategoryUpdateResult(category.getId(), category.getCategory(), category.getCreatedAt(), category.getUpdatedAt());
    }
}
