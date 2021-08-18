package in.thiago.product.catalog.services.product;

import in.thiago.product.catalog.domain.product.ProductService;
import in.thiago.product.catalog.ui.product.dtos.ProductCommand;
import in.thiago.product.catalog.ui.product.dtos.ProductCreateResult;
import in.thiago.product.catalog.ui.product.dtos.ProductResult;
import in.thiago.product.catalog.ui.product.dtos.ProductUpdateResult;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductResult> getAll() {
        return null;
    }

    @Override
    public ProductResult get(String id) throws ProductCollectionException {
        return null;
    }

    @Override
    public ProductCreateResult create(ProductCommand product) throws ConstraintViolationException, ProductCollectionException {
        return null;
    }

    @Override
    public ProductUpdateResult update(String id, ProductCommand product) throws ProductCollectionException {
        return null;
    }

    @Override
    public ProductUpdateResult delete(String id) throws ProductCollectionException {
        return null;
    }
}
