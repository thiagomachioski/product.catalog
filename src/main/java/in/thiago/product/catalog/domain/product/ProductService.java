package in.thiago.product.catalog.domain.product;

import in.thiago.product.catalog.ui.product.dtos.*;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface ProductService {

    List<ProductResultList> getAll();

    ProductResult get(String id) throws ProductCollectionException;

    ProductCreateResult create(ProductCommand product) throws ConstraintViolationException, ProductCollectionException, CategoryCollectionException;

    ProductUpdateResult update(String id, ProductCommand product) throws ProductCollectionException;

    ProductUpdateResult delete(String id) throws ProductCollectionException;

}
