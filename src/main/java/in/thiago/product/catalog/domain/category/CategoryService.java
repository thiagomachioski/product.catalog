package in.thiago.product.catalog.domain.category;

import in.thiago.product.catalog.ui.category.dtos.CategoryCreateCommand;
import in.thiago.product.catalog.ui.category.dtos.CategoryResult;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryResult create(CategoryCreateCommand category) throws ConstraintViolationException, CategoryCollectionException;

    List<CategoryResult> getAll();

    CategoryResult get(String id) throws CategoryCollectionException;

    Optional<CategoryResult> update(String id, CategoryCreateCommand todo) throws CategoryCollectionException;

    Optional<CategoryResult> delete(String id) throws CategoryCollectionException;

}
