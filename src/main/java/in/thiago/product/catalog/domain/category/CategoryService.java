package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryCreateResult;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;
import in.thiago.product.catalog.ui.category.dtos.CategoryUpdateResult;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryResult> getAll();

    CategoryResult get(String id) throws CategoryCollectionException;

    CategoryCreateResult create(CategoryCommand category) throws ConstraintViolationException, CategoryCollectionException;

    CategoryUpdateResult update(String id, CategoryCommand category) throws CategoryCollectionException;

    Optional<CategoryCreateResult> delete(String id) throws CategoryCollectionException;

}
