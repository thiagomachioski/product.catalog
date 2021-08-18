package in.thiago.product.catalog.domain.product;

import in.thiago.product.catalog.ui.product.dtos.ProductCommand;
import in.thiago.product.catalog.ui.product.dtos.ProductCreateResult;
import in.thiago.product.catalog.ui.product.dtos.ProductResult;
import in.thiago.product.catalog.ui.product.dtos.ProductUpdateResult;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface ProductService {

    List<ProductResult> getAll();

    ProductResult get(String id) throws ProductCollectionException;

    ProductCreateResult create(ProductCommand product) throws ConstraintViolationException, ProductCollectionException;

    ProductUpdateResult update(String id, ProductCommand product) throws ProductCollectionException;

    ProductUpdateResult delete(String id) throws ProductCollectionException;

}
