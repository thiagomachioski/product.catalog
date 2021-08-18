package in.thiago.product.catalog.services.product;

import in.thiago.product.catalog.domain.enums.RequestType;
import in.thiago.product.catalog.domain.product.ProductHandler;
import in.thiago.product.catalog.domain.product.ProductService;
import in.thiago.product.catalog.repository.category.CategoryRepository;
import in.thiago.product.catalog.repository.product.ProductRepository;
import in.thiago.product.catalog.ui.product.dtos.ProductCommand;
import in.thiago.product.catalog.ui.product.dtos.ProductCreateResult;
import in.thiago.product.catalog.ui.product.dtos.ProductResult;
import in.thiago.product.catalog.ui.product.dtos.ProductUpdateResult;
import in.thiago.product.catalog.untils.exception.CategoryCollectionException;
import in.thiago.product.catalog.untils.exception.ProductCollectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductHandler productHandler;

    @Override
    public List<ProductResult> getAll() {
        return null;
    }

    @Override
    public ProductResult get(String id) throws ProductCollectionException {
        var product = productRepository.findById(id);
        if(!product.isPresent())
            throw new ProductCollectionException(ProductCollectionException.NotFoundException(id));
        return productHandler.productToProductResult(product.get());
    }

    @Override
    public ProductCreateResult create(ProductCommand product) throws ConstraintViolationException, ProductCollectionException, CategoryCollectionException {
        var category = categoryRepository.findById(product.getProductCategoryCommand().getId());
        if(!category.isPresent())
            throw new CategoryCollectionException(CategoryCollectionException.NotFoundException(product.getProductCategoryCommand().getId()));

        var result = productRepository.save(productHandler.productCreateCommandToProduct(product));
        return productHandler.productToProductCreateResult(result, RequestType.POST);
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
