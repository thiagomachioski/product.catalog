package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.*;
import in.thiago.product.catalog.utils.exception.CategoryCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface CategoryService {

    List<CategoryResult> getAll();

    CategoryResult get(String id) throws CategoryCollectionException;

    CategoryCreateResult create(CategoryCommand category) throws ConstraintViolationException, CategoryCollectionException;

    CategoryUpdateResult update(String id, CategoryCommand category) throws CategoryCollectionException;

    CategoryDeleteResult delete(String id) throws CategoryCollectionException;

}
